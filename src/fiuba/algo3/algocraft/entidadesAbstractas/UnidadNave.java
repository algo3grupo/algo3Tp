package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class UnidadNave extends Unidad {

	public UnidadNave(int ID, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int suministro) {
		super(ID, vida, rangoDeVision, jugador, nombre, costo, requiere, suministro);
	}

}
