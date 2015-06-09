package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;

public class ArchivosTemplarios extends Protegidas {

	public ArchivosTemplarios(Jugador jugador) {
		super( 500, 0, jugador, "Archivos Templarios", new Costo(150,200), "Puerto Estelar");
	}

}
