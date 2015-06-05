package fiuba.algo3.algoCraft.estructurasTerran;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class Fabrica extends Estructura {

	public Fabrica(Jugador jugador) {
		super(jugador);
		this.nombre = "Fabrica";
		this.costo = new Costo(200,100);
		this.requiere = "Barraca";
	}

}
