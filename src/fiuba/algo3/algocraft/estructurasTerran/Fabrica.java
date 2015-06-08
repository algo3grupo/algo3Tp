package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Fabrica extends Estructura {

	public Fabrica(Jugador jugador) {
		super(0, 1250, 0, jugador, "Fabrica", new Costo(200,100), "Barraca");
	}

}
