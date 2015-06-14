package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Fabrica extends Estructura {

	public Fabrica(Vector2D posicion, Jugador jugador) {
		super( posicion, 1250, 0, jugador, "Fabrica", new Costo(200,100), "Barraca", 12);
	}

}
