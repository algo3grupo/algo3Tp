package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.excepciones.NoEsPosibleCargarEstaUnidad;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class UnidadNave extends Unidad {
	private int capacidad;
	private int cargado;
	private ArrayList<Unidad> unidadesCargadas;

	public UnidadNave( Vector2D posicion, int vida, int rangoDeVision, Jugador jugador,  Costo costo, int suministro, int turnos) {
		super( posicion, vida, rangoDeVision, jugador, "Nave Transporte" , costo, "Puerto Estelar", suministro, 0, turnos);
		capacidad = 8;
		cargado = 0;
		unidadesCargadas = new ArrayList<Unidad>();
	}
	
	public void cargarUnidad(Unidad unidad) throws NoEsPosibleCargarEstaUnidad{
		if ( (cargado + unidad.transporte() > capacidad) || (unidad.esVoladora())){
			throw new NoEsPosibleCargarEstaUnidad();
		}
		else {
			cargado+= unidad.transporte();
			unidadesCargadas.add(unidad);
		}
		
	}
	
	public void descargarUnidad(Unidad unidad){
		int i = unidadesCargadas.indexOf(unidad);
		unidadesCargadas.remove(i);
	}
	
	public int cantidadCarga(){
		return cargado;
	}
}
