package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.Interfaces.IEstructura;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class Estructura extends ColaDeAcciones implements IEstructura{

	public Estructura( int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int turnos) {
		super( vida, rangoDeVision, jugador, nombre, costo, requiere, turnos);
	}
	
	
	public Estructura(Estructura estructura) {
		super(estructura);
	}

	public void actualizarPoblacion() {
		
	}
	
	public void eliminar(){
		
	}

}
