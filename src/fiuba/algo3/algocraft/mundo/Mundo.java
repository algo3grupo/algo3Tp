package fiuba.algo3.algocraft.mundo;

import java.util.ArrayList;
import java.util.Comparator;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.entidadesAbstractas.Dibujable;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.DivisionDeGrillaNoEsMultiploDeResolucion;
import fiuba.algo3.algocraft.excepciones.ParametroNegativo;
import fiuba.algo3.algocraft.excepciones.ParametroNulo;
import fiuba.algo3.algocraft.excepciones.posicionDeJugadorIndefinida;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Mundo extends Dibujable{
	
	private int divisionGrillaParaAnalisis;
	private int resolucion;
	private int divisionGrilla;
	private ArrayList<Mineral> mineral;
	private ArrayList<Gas> gas;
	private ArrayList<Espacio> espacio;
	private Vector2D baseJugador1;
	private Vector2D baseJugador2;
	private Juego juego;
	
	
	public void generar()
	{
		double tamañoDivision = (double)resolucion/divisionGrillaParaAnalisis;
		
		baseJugador1 = new Vector2D(4*divisionGrilla,4*divisionGrilla);
		baseJugador2 = new Vector2D(resolucion-4*divisionGrilla,resolucion-4*divisionGrilla);
		
		for(int i=0;i<divisionGrillaParaAnalisis;i++)
			for(int a=0;a<divisionGrillaParaAnalisis;a++)
				for(int j=0;j<10;j++)
				{
					Vector2D posicionMineral = pixelAGrilla(new Vector2D().aleatorio(tamañoDivision*i,tamañoDivision*(i+1)-divisionGrilla,tamañoDivision*a,tamañoDivision*(a+1)-divisionGrilla));
					
					if(!hayMineral(posicionMineral) && !hayGas(posicionMineral) && baseJugador1.distintoA(posicionMineral) && baseJugador2.distintoA(posicionMineral))
						mineral.add(new Mineral(obtenerVentana(),posicionMineral,divisionGrilla));	

				}
		
		for(int i=0;i<divisionGrillaParaAnalisis;i++)
			for(int a=0;a<divisionGrillaParaAnalisis;a++)
				for(int j=0;j<5;j++)
				{
					Vector2D posicionGas = pixelAGrilla(new Vector2D().aleatorio(tamañoDivision*i,tamañoDivision*(i+1)-divisionGrilla,tamañoDivision*a,tamañoDivision*(a+1)-divisionGrilla));
					
					if(!hayMineral(posicionGas) && !hayGas(posicionGas) && baseJugador1.distintoA(posicionGas) && baseJugador2.distintoA(posicionGas))
						gas.add(new Gas(obtenerVentana(),posicionGas,divisionGrilla));	
				}
		
	}

	public Vector2D pixelAGrilla(Vector2D posicion)
	{
		double posicionX = ((int)posicion.obtenerCoordenadaX()/divisionGrilla)*divisionGrilla, posicionY = ((int)posicion.obtenerCoordenadaY()/divisionGrilla)*divisionGrilla;
		
		return new Vector2D(posicionX,posicionY);		
	}

	public Mundo(JFrame ventana, int resolucion, int divisionGrilla, Juego juego)
	{
		super(ventana);
		
		if(resolucion < 0 || divisionGrilla < 0)
			throw new ParametroNegativo();
		
		if(resolucion == 0 || divisionGrilla == 0)
			throw new ParametroNulo();
		
		if(resolucion % divisionGrilla != 0)
			throw new DivisionDeGrillaNoEsMultiploDeResolucion();
		
		this.juego = juego;		
		this.resolucion = resolucion;
		this.divisionGrilla = divisionGrilla;
		divisionGrillaParaAnalisis = 2;
		
		this.baseJugador1 = null;
		this.baseJugador2 = null;
		
		mineral = new ArrayList<Mineral>();
		gas = new ArrayList<Gas>();
		espacio = new ArrayList<Espacio>();
	}
	
	public boolean hayMineral(Vector2D posicion)
	{
		for(int i=0;i<mineral.size();i++)
			if(mineral.get(i).incluyeA(posicion))
				return true;
		return false;			
	}
	
	public boolean hayGas(Vector2D posicion)
	{
		for(int i=0;i<gas.size();i++)
			if(gas.get(i).incluyeA(posicion))
				return true;
		return false;	
	}
	
	public boolean hayEspacio(Vector2D posicion)
	{
		for(int i=0;i<espacio.size();i++)
			if(espacio.get(i).incluyeA(posicion))
				return true;
		return false;	
	}
	
	public Vector2D posicionBaseJugador1()
	{
		if(baseJugador1 == null)
			throw new posicionDeJugadorIndefinida();
		return new Vector2D(baseJugador1);
	}
	
	public Vector2D posicionBaseJugador2()
	{
		if(baseJugador2 == null)
			throw new posicionDeJugadorIndefinida();
		return new Vector2D(baseJugador2);
	}
	
	public ArrayList<Mineral> mineralesCercanos(Vector2D posicion)
	{
		ArrayList<Mineral> mineralOrdenadosPorDistancia = new ArrayList<Mineral>(), mineralesMasCercanos = new ArrayList<Mineral>();
		
		for(int i=0;i<mineral.size();i++)
			mineralOrdenadosPorDistancia.add(new Mineral(mineral.get(i)));
		
		class ClaseComparadoraLocal implements Comparator<Mineral>
		{
			private Vector2D referencia;
			
			public ClaseComparadoraLocal(Vector2D posicion) 
			{
				referencia = posicion;
			}

			public int compare(Mineral m1, Mineral m2)
			{
				Vector2D posicionM1 = m1.obtenerPosicion(), posicionM2 = m2.obtenerPosicion();
				
				if(posicionM1.distanciaA(referencia) < posicionM2.distanciaA(referencia))
					return -1;
				else if(posicionM1.distanciaA(referencia) > posicionM2.distanciaA(referencia))
					return 1;
				return 0;
			}
			
		
		}
		
		mineralOrdenadosPorDistancia.sort(new ClaseComparadoraLocal(posicion));
		
		for(int i=0;i<5;i++)
			mineralesMasCercanos.add(new Mineral(mineralOrdenadosPorDistancia.get(i)));	
		
		return mineralesMasCercanos;
		
	}
	
	public ArrayList<Gas> gasCercano(Vector2D posicion)
	{
		ArrayList<Gas> GasOrdenadosPorDistancia = new ArrayList<Gas>(), gasesMasCercanos = new ArrayList<Gas>();
		
		for(int i=0;i<gas.size();i++)
			GasOrdenadosPorDistancia.add(new Gas(gas.get(i)));
		
		class ClaseComparadoraLocal implements Comparator<Gas>
		{
			private Vector2D referencia;
			
			public ClaseComparadoraLocal(Vector2D posicion) 
			{
				referencia = posicion;
			}

			public int compare(Gas m1, Gas m2)
			{
				Vector2D posicionM1 = m1.obtenerPosicion(), posicionM2 = m2.obtenerPosicion();
				
				if(posicionM1.distanciaA(referencia) < posicionM2.distanciaA(referencia))
					return -1;
				else if(posicionM1.distanciaA(referencia) > posicionM2.distanciaA(referencia))
					return 1;
				return 0;
			}
			
		
		}
		
		GasOrdenadosPorDistancia.sort(new ClaseComparadoraLocal(posicion));
		
		for(int i=0;i<5;i++)
			gasesMasCercanos.add(new Gas(GasOrdenadosPorDistancia.get(i)));	
		
		return gasesMasCercanos;
		
	}	
	
	public int obtenerResolucion()
	{
		return resolucion;
	}

	public boolean hayMineralesCercanos(Vector2D posicion) 
	{
		int a = 0;
		ArrayList<Mineral> aux = mineralesCercanos(posicion);
		
		for(int i=0;i<aux.size();i++)
			if(aux.get(i).obtenerPosicion().distanciaA(posicion) < 2*resolucion/divisionGrillaParaAnalisis)
				a++;
		
		if(a > 2)
			return true;
		return false;
	}

	public boolean hayGasCercano(Vector2D posicion) 
	{
		int a = 0;
		ArrayList<Gas> aux = gasCercano(posicion);
		
		for(int i=0;i<aux.size();i++)
			if(aux.get(i).obtenerPosicion().distanciaA(posicion) < 2*resolucion/divisionGrillaParaAnalisis)
				a++;
		
		if(a > 2)
			return true;
		return false;
	}
	
	public ArrayList<Unidad> obtenerUnidadesEnZona(Vector2D centro, int radio)
	{
		
		ArrayList<Unidad> unidadesJugador1 = juego.obtenerUnidadesDeJugador1(), unidadesJugador2 = juego.obtenerUnidadesDeJugador2(), resultado = new ArrayList<Unidad>();
		
		for(int i=0;i<unidadesJugador1.size();i++)
			if(unidadesJugador1.get(i).obtenerPosicion().distanciaA(centro) <= radio)
				resultado.add(unidadesJugador1.get(i));
		
		for(int i=0;i<unidadesJugador2.size();i++)
			if(unidadesJugador2.get(i).obtenerPosicion().distanciaA(centro) <= radio)
				resultado.add(unidadesJugador2.get(i));
		
		return resultado;
		
	}
	
	public ArrayList<Vector2D> obtenerRutaSeguraEntre(Vector2D inicio, Vector2D fin)
	{
		ArrayList<Vector2D> camino = new ArrayList<Vector2D>();
		
		
		
		
		
		
		return camino;
	}

	public boolean estaLibre(Vector2D posicion)
	{
		if(hayMineral(posicion))
			return false;
		
		if(hayGas(posicion))
			return false;
		
		if(hayEspacio(posicion))
			return false;
		
		ArrayList<Unidad> unidades = juego.obtenerUnidadesDeJugador1();
		ArrayList<Estructura> estructuras = juego.obtenerEstructurasDeJugador1();
		
		for(int i=0;i<unidades.size();i++)
			if(unidades.get(i).incluyeA(posicion))
				return false;
		
		unidades = juego.obtenerUnidadesDeJugador2();
		
		for(int i=0;i<unidades.size();i++)
			if(unidades.get(i).incluyeA(posicion))
				return false;
		
		for(int i=0;i<estructuras.size();i++)
			if(estructuras.get(i).incluyeA(posicion))
				return false;
		
		estructuras = juego.obtenerEstructurasDeJugador2();
		
		for(int i=0;i<estructuras.size();i++)
			if(estructuras.get(i).incluyeA(posicion))
				return false;
		
		return true;
		
	}
	
	public void dibujar()
	{
		
		dibujarImagenEnMosaico("terreno.jpg",new Vector2D(0,0),resolucion,resolucion);
		
		for(int i=0;i<mineral.size();i++)
			mineral.get(i).dibujar();
		
		for(int i=0;i<gas.size();i++)
			gas.get(i).dibujar();
		
		for(int i=0;i<espacio.size();i++)
			espacio.get(i).dibujar();
	}
}
