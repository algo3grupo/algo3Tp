package fiuba.algo3.algocraft.jugador;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.creadores.CreadorEstructurasProtoss;
import fiuba.algo3.algocraft.creadores.CreadorUnidadesProtoss;
import fiuba.algo3.algocraft.estructurasProtoss.Pilon;
import fiuba.algo3.algocraft.estructurasTerran.DepositoSuministro;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Protoss extends Jugador {

	public Protoss(int dimension, Vector2D base, String nombreJugador, String colorJugador) {
		super(dimension, base, nombreJugador, colorJugador);
		this.creadorEstructuras = new CreadorEstructurasProtoss(this);
		this.creadorUnidades =new CreadorUnidadesProtoss(this);
		
		incorporarEstructura(new Pilon(dimension, base, this));
	}

	

}
