package fiuba.algo3.algocraft.estructurasProtoss;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class PuertoEstelar extends Protegidas {

	public PuertoEstelar(int dimension, JFrame ventana, Vector2D posicion, Jugador jugador) {
		super(dimension, ventana, posicion, 600, 0, jugador, "Puerto Estelar", new Costo(150,150), "Acceso", 10);
	}

	
	public void dibujar() 
	{
		dibujarImagen("recursos/puerto estelar (protoss).png", obtenerPosicion(),obtenerDimension(),obtenerDimension());		
	}

}
