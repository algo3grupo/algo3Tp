package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;


public abstract class Unidad extends ColaDeAcciones {
	private int suministro;

	public Unidad(int ID, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int suministro) {
		super(ID, vida, rangoDeVision, jugador, nombre, costo, requiere);
		this.suministro = suministro;
	}


	public int suministro() {
		
		return suministro;
	}


	
}
