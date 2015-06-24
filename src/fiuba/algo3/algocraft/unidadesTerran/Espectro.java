package fiuba.algo3.algocraft.unidadesTerran;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Espectro extends UnidadAtaqueBasico {

	public Espectro(int dimension, Vector2D posicion, Jugador jugador) {
		
		super(dimension, posicion, new Vida(120), 7, jugador, "Espectro", new Costo(150,100), "Puerto Estelar", 2, 0, 8,new Ataque( 8, 20, 5*dimension, 5*dimension));
	}

}
