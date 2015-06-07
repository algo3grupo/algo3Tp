package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Acceso extends Protegidas{

	public Acceso(Jugador jugador) {
		super(jugador);
		this.nombre = "Acceso";
		this.costo = new Costo(150,0);
		this.vida = 500;
		inicializarCampoYLimiteCampo(500);
	}

}
