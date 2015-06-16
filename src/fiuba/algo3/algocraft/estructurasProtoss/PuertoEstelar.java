package fiuba.algo3.algocraft.estructurasProtoss;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class PuertoEstelar extends Protegidas {

	public PuertoEstelar(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 600, 0, jugador, "Puerto Estelar", new Costo(150,150), "Acceso", 10);
	}

	
	public void dibujar(Graphics contexto) 
	{
		dibujarImagen(contexto,"recursos/puerto estelar (protoss).png", obtenerPosicion(),obtenerDimension(),obtenerDimension());		
	}

}
