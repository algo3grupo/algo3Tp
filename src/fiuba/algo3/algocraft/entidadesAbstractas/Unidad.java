package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.jugador.Jugador;


public abstract class Unidad extends EntidadAbstracta {
	protected int suministro;

	public Unidad(Jugador jugador) {
		super(jugador);
	}


	public int suministro() {
		
		return suministro;
	}


	
}
