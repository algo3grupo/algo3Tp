package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Barraca extends Estructura {

	public Barraca(Jugador jugador) {
		super(0, 1000, 0, jugador, "Barraca", new Costo(150,0), "");
	}

}
