package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;

public class PuertoEstelar extends Protegidas {

	public PuertoEstelar(Jugador jugador) {
		super(0, 600, 0, jugador, "Puerto Estelar", new Costo(150,150), "Acceso");
	}

}
