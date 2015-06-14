package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class ArchivosTemplarios extends Protegidas {

	public ArchivosTemplarios(Vector2D posicion, Jugador jugador) {
		super(posicion, 500, 0, jugador, "Archivos Templarios", new Costo(150,200), "Puerto Estelar", 9);
	}

}
