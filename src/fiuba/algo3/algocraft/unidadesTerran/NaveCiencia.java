package fiuba.algo3.algocraft.unidadesTerran;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class NaveCiencia extends UnidadEnergia {

	public NaveCiencia(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 200, 10, jugador, "Nave Ciencia", new Costo(125,50), "Puerto Estelar", 2, 0, 10);
	}

	@Override
	public void dibujar(Graphics contexto) {
		// TODO Auto-generated method stub
		
	}

}
