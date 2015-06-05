package fiuba.algo3.algoCraft.jugador;

import fiuba.algo3.algoCraft.creadores.CreadorEstructurasProtoss;
import fiuba.algo3.algoCraft.creadores.CreadorUnidadesProtoss;

public class Protoss extends Jugador {

	public Protoss(String nombreJugador, int mineralesInicial, int gasInicial) {
		super(nombreJugador, mineralesInicial, gasInicial);
		this.creadorEstructuras = new CreadorEstructurasProtoss(this);
		this.creadorUnidades =new CreadorUnidadesProtoss(this);
	}

	

}
