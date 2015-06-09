package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class UnidadNave extends Unidad {

	public UnidadNave( int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int suministro) {
		super( vida, rangoDeVision, jugador, nombre, costo, requiere, suministro);
	}

}
