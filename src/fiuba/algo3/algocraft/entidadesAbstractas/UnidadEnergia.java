package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;

public class UnidadEnergia extends Unidad {

	public UnidadEnergia(int ID, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int suministro) {
		super(ID, vida, rangoDeVision, jugador, nombre, costo, requiere, suministro);
	}

}
