package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.Interfaces.IEstructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class Estructura extends ColaDeAcciones implements IEstructura{

	public Estructura(Jugador jugador) {
		super(jugador);
	}

	public Estructura(Estructura estructura) {
		super(estructura);
	}

	public void actualizarPoblacion() {
		
	}
	
	public void eliminar(){
		
	}

}
