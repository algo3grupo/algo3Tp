package fiuba.algo3.algocraft.estructurasProtoss;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Acceso extends Protegidas{

	public Acceso(int dimension, Vector2D posicion, Jugador jugador) {
		
		super(dimension, posicion, 500, 0, jugador, "Acceso",new Costo(150,0), "", 8);
		
	}

}
