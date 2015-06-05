package fiuba.algo3.algoCraft.entidadesAbstractas;

import fiuba.algo3.algoCraft.jugador.Jugador;


public abstract class Unidad extends EntidadAbstracta {
	protected int suministro;

	public Unidad(Jugador jugador) {
		super(jugador);
	}


	public int suministro() {
		
		return suministro;
	}


	
}
