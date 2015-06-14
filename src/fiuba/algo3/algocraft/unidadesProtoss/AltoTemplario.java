package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class AltoTemplario extends UnidadEnergia {

	public AltoTemplario(Vector2D posicion, Jugador jugador) {
		super(posicion, 40, 7, jugador, "Alto Templario", new Costo(100,0), "Archivos Templarios", 2, 2, 7);
	}

}
