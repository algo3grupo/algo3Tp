package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Interfaces.IEstructura;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Estructura extends ColaDeAcciones implements IEstructura{

	public Estructura(int dimension, Vector2D posicion, Vida vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int turnos) {
		super(dimension, posicion, vida, 4, jugador, nombre, costo, requiere, turnos);
		
	}
	
	
	public Estructura(Estructura estructura) {
		super(estructura);
		this.despejarZona();
	}

	public void actualizarPoblacion() {
		
	}
	
	public void eliminar(){
		super.eliminar();
	}


	public abstract ArrayList<String> obtenerUnidadesCreables();


	public Vector2D obtenerPuntoDeCreacion() 
	{
		
		Vector2D posicion = new Vector2D();
		
		posicion.aleatorio(obtenerPosicion().obtenerCoordenadaX(), obtenerPosicion().obtenerCoordenadaX()+obtenerDimension(), obtenerPosicion().obtenerCoordenadaY(), obtenerPosicion().obtenerCoordenadaY()+obtenerDimension());
		
		return posicion;
	}

}
