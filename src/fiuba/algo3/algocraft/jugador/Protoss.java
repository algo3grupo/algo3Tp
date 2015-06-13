package fiuba.algo3.algocraft.jugador;

import fiuba.algo3.algocraft.creadores.CreadorEstructurasProtoss;
import fiuba.algo3.algocraft.creadores.CreadorUnidadesProtoss;

public class Protoss extends Jugador {

	public Protoss(String nombreJugador, String colorJugador) {
		super(nombreJugador, colorJugador);
		this.creadorEstructuras = new CreadorEstructurasProtoss(this);
		this.creadorUnidades =new CreadorUnidadesProtoss(this);
	}

	

}
