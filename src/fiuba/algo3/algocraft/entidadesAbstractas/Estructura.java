package fiuba.algo3.algocraft.entidadesAbstractas;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Interfaces.IEstructura;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Estructura extends ColaDeAcciones implements IEstructura{

	public Estructura(int dimension, JFrame ventana, Vector2D posicion, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int turnos) {
		super(dimension, ventana, posicion, vida, rangoDeVision, jugador, nombre, costo, requiere, turnos);
	}
	
	
	public Estructura(Estructura estructura) {
		super(estructura);
	}

	public void actualizarPoblacion() {
		
	}
	
	public void eliminar(){
		
	}

}
