package fiuba.algo3.algocraft.estructurasTerran;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Fabrica extends Estructura {

	public Fabrica(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 1250, 0, jugador, "Fabrica", new Costo(200,100), "Barraca", 12);
	}
}
