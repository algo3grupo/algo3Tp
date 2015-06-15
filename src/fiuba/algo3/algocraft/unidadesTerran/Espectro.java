package fiuba.algo3.algocraft.unidadesTerran;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Espectro extends UnidadAtaqueBasico {

	public Espectro(int dimension, JFrame ventana, Vector2D posicion, Jugador jugador) {
		
		super(dimension, ventana, posicion, 120, 7, jugador, "Espectro", new Costo(150,100), "Puerto Estelar", 2, 0, 8,new Ataque( 8, 20, 5, 5));
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

}
