package fiuba.algo3.algocraft.unidadesTerran;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class NaveTransporteTerran extends UnidadNave {

	public NaveTransporteTerran(int dimension, JFrame ventana, Vector2D posicion, Jugador jugador) {
		super(dimension, ventana,posicion, 150, 8, jugador,  new Costo(125,50),  2, 7);
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

}
