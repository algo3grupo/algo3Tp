package fiuba.algo3.algocraft.mundo;

import java.util.ArrayList;
import java.util.Comparator;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.DivisionDeGrillaNoEsMultiploDeResolucion;
import fiuba.algo3.algocraft.excepciones.NoHayUnidadEnEsaPosicion;
import fiuba.algo3.algocraft.excepciones.ParametroNegativo;
import fiuba.algo3.algocraft.excepciones.ParametroNulo;
import fiuba.algo3.algocraft.excepciones.posicionDeJugadorIndefinida;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Mundo{
	
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
		
		baseJugador1 = pixelAGrilla(new Vector2D(4*divisionGrilla,4*divisionGrilla));
		baseJugador2 = pixelAGrilla(new Vector2D(resolucion-4*divisionGrilla,resolucion-4*divisionGrilla));
		
		Vector2D posicionGas = new Vector2D(0,0), posicionMineral;
		
		gas.add(new Gas(divisionGrilla,posicionGas));
		
		posicionGas = new Vector2D(resolucion-divisionGrilla,resolucion-divisionGrilla);
		
		gas.add(new Gas(divisionGrilla,posicionGas));
		
		
		for(int i=0;i<divisionGrillaParaAnalisis;i++)
			for(int a=0;a<divisionGrillaParaAnalisis;a++)
				for(int j=0;j<50;j++)
				{
					posicionMineral = pixelAGrilla(new Vector2D().aleatorio(tamañoDivision*i,tamañoDivision*(i+1)-divisionGrilla,tamañoDivision*a,tamañoDivision*(a+1)-divisionGrilla));
					
					if(!hayMineral(posicionMineral) && !hayGas(posicionMineral) && baseJugador1.distintoA(posicionMineral) && baseJugador2.distintoA(posicionMineral))
						mineral.add(new Mineral(divisionGrilla,posicionMineral));	

				}
		
		for(int i=0;i<divisionGrillaParaAnalisis;i++)
			for(int a=0;a<divisionGrillaParaAnalisis;a++)
				for(int j=0;j<10;j++)
				{
					posicionGas = pixelAGrilla(new Vector2D().aleatorio(tamañoDivision*i,tamañoDivision*(i+1)-divisionGrilla,tamañoDivision*a,tamañoDivision*(a+1)-divisionGrilla));
					
					if(!hayMineral(posicionGas) && !hayGas(posicionGas) && baseJugador1.distintoA(posicionGas) && baseJugador2.distintoA(posicionGas))
						gas.add(new Gas(divisionGrilla,posicionGas));	
				}
		
	}

	public Vector2D pixelAGrilla(Vector2D posicion)
	{
		double posicionX = ((int)posicion.obtenerCoordenadaX()/divisionGrilla)*divisionGrilla, posicionY = ((int)posicion.obtenerCoordenadaY()/divisionGrilla)*divisionGrilla;
		
		return new Vector2D(posicionX,posicionY);		
	}

	public Mundo(int resolucion, int divisionGrilla, Juego juego)
	{
		
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
		
		int limite;
		
		if(mineralOrdenadosPorDistancia.size() >= 5)
			limite = 5;
		else
			limite = mineralOrdenadosPorDistancia.size();
		
		for(int i=0;i<limite;i++)
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
		
		int limite;
		
		if(GasOrdenadosPorDistancia.size() >= 5)
			limite = 5;
		else
			limite = GasOrdenadosPorDistancia.size();
		
		for(int i=0;i<limite;i++)
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
		
		Vector2D direccion = new Vector2D();		
		ArrayList<Vector2D> camino;
		
		camino = (fin.restarA(inicio)).dividirSegunLongitud(10); 
		
		for(int i=0; i < camino.size();i++)
		{
			direccion = camino.get(i);
			direccion = direccion.sumarA(inicio);
			camino.set(i,direccion);
		}		
		
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

	public int obtenerDivisionDeGrilla() 
	{
		return divisionGrilla;
	}

	public Unidad obtenerUnidadEn(Vector2D posicion) throws NoHayUnidadEnEsaPosicion {
		
		ArrayList<Unidad> unidades = juego.obtenerUnidadesDeJugador1();
		
		for(int i=0;i<unidades.size();i++){
			if(unidades.get(i).incluyeA(posicion)){
				return unidades.get(i);
			}
		}
		unidades = juego.obtenerUnidadesDeJugador2();
		for(int i=0;i<unidades.size();i++){
			if(unidades.get(i).incluyeA(posicion)){
				return unidades.get(i);
			}
		}
		throw new NoHayUnidadEnEsaPosicion();
	}

	public ArrayList<Gas> obtenerGas() 
	{
		return gas;
	}

	public ArrayList<Mineral> obtenerMinerales() 
	{
		return mineral;
	}

	public Juego obtenerJuego() 
	{
		return juego;
		
	}
	
	public Entidad obtenerElemento(Vector2D posicion)
	{
		for(int i=0;i<mineral.size();i++)
			if(mineral.get(i).incluyeA(posicion))
			return mineral.get(i);
		
		for(int i=0;i<gas.size();i++)
			if(gas.get(i).incluyeA(posicion))
			return gas.get(i);
		
		return null;
		
	}

	public ArrayList<Entidad> entidadesEnRectangulo(Vector2D supizq, int dimension) 
	{
		ArrayList<Entidad> aux = new ArrayList<Entidad>();
		
		for(int i=0;i<mineral.size();i++)
			if(mineral.get(i).estaEn(supizq,dimension))
				aux.add(mineral.get(i));		
		
		for(int i=0;i<gas.size();i++)
			if(gas.get(i).estaEn(supizq,dimension))
				aux.add(gas.get(i));		
		
		return aux;
	}
}
