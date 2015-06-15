package fiuba.algo3.algocraft.jugador;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.creadores.CreadorEstructurasProtoss;
import fiuba.algo3.algocraft.creadores.CreadorUnidadesProtoss;

public class Protoss extends Jugador {

	public Protoss(JFrame ventana, String nombreJugador, String colorJugador) {
		super(ventana, nombreJugador, colorJugador);
		this.creadorEstructuras = new CreadorEstructurasProtoss(this);
		this.creadorUnidades =new CreadorUnidadesProtoss(this);
	}

	

}
