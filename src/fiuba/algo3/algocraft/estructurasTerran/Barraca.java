package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Barraca extends Estructura {

	public Barraca(Jugador jugador) {
		super(jugador);
		this.nombre = "Barraca";
		this.costo = new Costo(150,0);
		this.vida = 1000;
	}

}
