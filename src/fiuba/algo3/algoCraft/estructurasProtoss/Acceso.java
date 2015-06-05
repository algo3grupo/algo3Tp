package fiuba.algo3.algoCraft.estructurasProtoss;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class Acceso extends Estructura{

	public Acceso(Jugador jugador) {
		super(jugador);
		this.nombre = "Acceso";
		this.costo = new Costo(150,0);
	}

}
