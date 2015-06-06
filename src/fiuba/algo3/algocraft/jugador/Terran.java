package fiuba.algo3.algocraft.jugador;

import fiuba.algo3.algocraft.creadores.CreadorEstructurasTerran;
import fiuba.algo3.algocraft.creadores.CreadorUnidadesTerran;

public class Terran extends Jugador {

	public Terran(String nombreJugador, int mineralesInicial, int gasInicial) {
		super(nombreJugador, mineralesInicial, gasInicial);
		this.creadorEstructuras = new CreadorEstructurasTerran(this);
		this.creadorUnidades =new CreadorUnidadesTerran(this);
	}

}
