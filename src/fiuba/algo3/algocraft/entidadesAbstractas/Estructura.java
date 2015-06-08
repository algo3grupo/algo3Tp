package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.Interfaces.IEstructura;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class Estructura extends ColaDeAcciones implements IEstructura{

	public Estructura(int ID, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere) {
		super(ID, vida, rangoDeVision, jugador, nombre, costo, requiere);
	}
	
	
	public Estructura(Estructura estructura) {
		super(estructura);
	}

	public void actualizarPoblacion() {
		
	}
	
	public void eliminar(){
		
	}

}
