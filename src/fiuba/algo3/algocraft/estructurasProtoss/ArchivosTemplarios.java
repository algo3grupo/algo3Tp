package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;

public class ArchivosTemplarios extends Protegidas {

	public ArchivosTemplarios(Jugador jugador) {
		super(jugador);
		this.nombre = "Archivos Templarios";
		this.costo = new Costo(150,200);
		this.requiere ="Puerto Estelar";
		this.vida = 500;
		inicializarCampoYLimiteCampo(500);
	}

}
