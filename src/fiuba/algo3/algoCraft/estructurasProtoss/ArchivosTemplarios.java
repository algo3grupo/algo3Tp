package fiuba.algo3.algoCraft.estructurasProtoss;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class ArchivosTemplarios extends Estructura {

	public ArchivosTemplarios(Jugador jugador) {
		super(jugador);
		this.nombre = "Archivos Templarios";
		this.costo = new Costo(150,200);
		this.requiere ="Puerto Estelar";
	}

}
