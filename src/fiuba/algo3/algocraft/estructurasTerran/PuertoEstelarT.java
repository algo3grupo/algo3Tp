package fiuba.algo3.algocraft.estructurasTerran;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class PuertoEstelarT extends Estructura {

	public PuertoEstelarT(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 1300, 0, jugador, "Puerto Estelar", new Costo(150,100), "Fabrica", 10);
	}

	
	public void dibujar(Graphics contexto) 
	{
		dibujarImagen(contexto,"recursos/puerto estelar (terran).png", obtenerPosicion(),obtenerDimension(),obtenerDimension());
		
	}

}
