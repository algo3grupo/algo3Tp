package fiuba.algo3.algocraft.jugador;

import java.awt.Color;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.creadores.CreadorEstructurasProtoss;
import fiuba.algo3.algocraft.creadores.CreadorUnidadesProtoss;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.estructurasProtoss.Pilon;
import fiuba.algo3.algocraft.estructurasTerran.DepositoSuministro;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Protoss extends Jugador {

	public Protoss(int dimension, Vector2D base, String nombreJugador, Color colorJugador, Mundo mundo) {
		super(dimension, base, nombreJugador, colorJugador, mundo);
		setCreadores(new CreadorEstructurasProtoss(this), new CreadorUnidadesProtoss(this));
		
		Estructura casa = new Pilon(dimension, base, this);
		casa.habilitar();
		incorporarEstructura(casa);
		
	}

	public String obtenerRaza() 
	{
		return "Protoss";
	}
}
