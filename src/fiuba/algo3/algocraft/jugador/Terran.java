package fiuba.algo3.algocraft.jugador;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.creadores.CreadorEstructurasTerran;
import fiuba.algo3.algocraft.creadores.CreadorUnidadesTerran;
import fiuba.algo3.algocraft.estructurasTerran.DepositoSuministro;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Terran extends Jugador {

	public Terran(int dimension, Vector2D base, String nombreJugador, String colorJugador) {
		super(dimension, base, nombreJugador,colorJugador);
		this.creadorEstructuras = new CreadorEstructurasTerran(this);
		this.creadorUnidades =new CreadorUnidadesTerran(this);
		
		incorporarEstructura(new DepositoSuministro(dimension, base, this));
	}

}
