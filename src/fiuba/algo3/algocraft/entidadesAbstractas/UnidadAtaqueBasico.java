package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class UnidadAtaqueBasico extends Unidad {
	
	private Ataque ataque;

	public UnidadAtaqueBasico( int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int suministro, 
			int transporte, int turnos, Ataque ataque) 
	{
		super( vida, rangoDeVision, jugador, nombre, costo, requiere, suministro, transporte, turnos);
		this.ataque = ataque;
	}

}
