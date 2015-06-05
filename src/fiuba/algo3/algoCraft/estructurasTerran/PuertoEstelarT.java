package fiuba.algo3.algoCraft.estructurasTerran;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class PuertoEstelarT extends Estructura {

	public PuertoEstelarT(Jugador jugador) {
		super(jugador);
		this.nombre = "Puerto Estelar";
		this.costo = new Costo(150,100);
		this.requiere = "Fabrica";
	}

}
