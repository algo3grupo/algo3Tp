package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class PuertoEstelarT extends Estructura {

	public PuertoEstelarT(Jugador jugador) {
		super( 1300, 0, jugador, "Puerto Estelar", new Costo(150,100), "Fabrica");
	}

}
