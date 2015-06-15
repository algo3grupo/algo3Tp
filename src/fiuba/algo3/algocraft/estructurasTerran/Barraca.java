package fiuba.algo3.algocraft.estructurasTerran;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Barraca extends Estructura {

	public Barraca(int dimension, JFrame ventana, Vector2D posicion, Jugador jugador) {
		super(dimension, ventana, posicion, 1000, 0, jugador, "Barraca", new Costo(150,0), "", 12);
	}

	public void dibujar() 
	{
		dibujarImagen("recursos/barraca (terran).png", obtenerPosicion(),obtenerDimension(),obtenerDimension());
	}

}
