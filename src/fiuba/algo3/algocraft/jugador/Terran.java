package fiuba.algo3.algocraft.jugador;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.creadores.CreadorEstructurasTerran;
import fiuba.algo3.algocraft.creadores.CreadorUnidadesTerran;

public class Terran extends Jugador {

	public Terran(JFrame ventana, String nombreJugador, String colorJugador) {
		super(ventana, nombreJugador,colorJugador);
		this.creadorEstructuras = new CreadorEstructurasTerran(this);
		this.creadorUnidades =new CreadorUnidadesTerran(this);
	}

}
