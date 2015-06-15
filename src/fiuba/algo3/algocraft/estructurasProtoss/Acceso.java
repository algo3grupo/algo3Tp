package fiuba.algo3.algocraft.estructurasProtoss;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Acceso extends Protegidas{

	public Acceso(int dimension, JFrame ventana, Vector2D posicion, Jugador jugador) {
		
		super(dimension, ventana, posicion, 500, 0, jugador, "Acceso",new Costo(150,0), "", 8);
		
	}

	
	public void dibujar() 
	{
		dibujarImagen("recursos/acceso (protoss).png", obtenerPosicion(),obtenerDimension(),obtenerDimension());
	}

}
