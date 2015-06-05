package fiuba.algo3.algoCraft.estructurasTerran;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class Barraca extends Estructura {

	public Barraca(Jugador jugador) {
		super(jugador);
		this.nombre = "Barraca";
		this.costo = new Costo(150,0);
	}

}
