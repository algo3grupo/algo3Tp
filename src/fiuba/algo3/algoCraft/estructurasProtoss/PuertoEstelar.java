package fiuba.algo3.algoCraft.estructurasProtoss;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class PuertoEstelar extends Estructura {

	public PuertoEstelar(Jugador jugador) {
		super(jugador);
		this.nombre = "Puerto Estelar";
		this.costo = new Costo(150,150);
		this.requiere = "Acceso";
	}

}
