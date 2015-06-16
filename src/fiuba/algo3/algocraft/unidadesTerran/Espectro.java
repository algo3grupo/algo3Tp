package fiuba.algo3.algocraft.unidadesTerran;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Espectro extends UnidadAtaqueBasico {

	public Espectro(int dimension, Vector2D posicion, Jugador jugador) {
		
		super(dimension, posicion, 120, 7, jugador, "Espectro", new Costo(150,100), "Puerto Estelar", 2, 0, 8,new Ataque( 8, 20, 5, 5));
	}

	@Override
	public void dibujar(Graphics contexto) {
		// TODO Auto-generated method stub
		
	}

}
