package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class PuertoEstelar extends Estructura {

	public PuertoEstelar(Jugador jugador) {
		super(jugador);
		this.nombre = "Puerto Estelar";
		this.costo = new Costo(150,150);
		this.requiere = "Acceso";
	}

}
