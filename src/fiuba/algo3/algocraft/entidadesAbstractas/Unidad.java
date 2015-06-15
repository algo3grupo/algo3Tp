package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;


public abstract class Unidad extends ColaDeAcciones {
	private int suministro;
	private int transporte;

	public Unidad(JFrame ventana, Vector2D posicion, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, 
			int suministro, int transporte, int turnos) {
		super(ventana, posicion, vida, rangoDeVision, jugador, nombre, costo, requiere, turnos);
		this.suministro = suministro;
		this.transporte = transporte;
	}


	public int suministro() {
		
		return suministro;
	}


	public ArrayList<Unidad> obtenerUnidadesAliadasEnRango(int rango) {
		//devuelve tmb a la unidad q llama lafuncion
		ArrayList<Unidad> unidadesTodas = getJugador().ObtenerUnidades();
		ArrayList<Unidad> unidadesCercanas = new ArrayList<Unidad>();
		
		for ( int i= 0; i < unidadesTodas.size(); i++ ){
			
			if ( this.obtenerPosicion().distanciaA(unidadesTodas.get(i).obtenerPosicion()) < rango){
				
				unidadesCercanas.add(unidadesTodas.get(i));
			}
		}
		return null;
	}


	public int transporte() {
		
		return transporte;
	}


	public boolean esVoladora() {
		
		if( transporte == 0){
			return true;
		}
		
		return false;
	}


	


	
}
