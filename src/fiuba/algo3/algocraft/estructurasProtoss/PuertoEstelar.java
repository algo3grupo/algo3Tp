package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;

public class PuertoEstelar extends Protegidas {

	public PuertoEstelar(Jugador jugador) {
		super(jugador);
		this.nombre = "Puerto Estelar";
		this.costo = new Costo(150,150);
		this.requiere = "Acceso";
		this.vida = 600;
		inicializarCampoYLimiteCampo(600);
	}

}
