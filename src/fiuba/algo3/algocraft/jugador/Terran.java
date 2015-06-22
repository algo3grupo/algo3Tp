package fiuba.algo3.algocraft.jugador;

import java.awt.Color;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.creadores.CreadorEstructurasProtoss;
import fiuba.algo3.algocraft.creadores.CreadorEstructurasTerran;
import fiuba.algo3.algocraft.creadores.CreadorUnidadesProtoss;
import fiuba.algo3.algocraft.creadores.CreadorUnidadesTerran;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.estructurasTerran.DepositoSuministro;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Terran extends Jugador {

	public Terran(int dimension, Vector2D base, String nombreJugador, Color colorJugador, Mundo mundo) {
		super(dimension, base, nombreJugador,colorJugador, mundo);
		setCreadores(new CreadorEstructurasTerran(this), new CreadorUnidadesTerran(this));
		
		Estructura casa = new DepositoSuministro(dimension, base, this);
		casa.habilitar();
		incorporarEstructura(casa);

	}

	public String obtenerRaza() 
	{
		return "Terran";
	}
	
}
