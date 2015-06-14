package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Barraca extends Estructura {

	public Barraca(Vector2D posicion, Jugador jugador) {
		super(posicion, 1000, 0, jugador, "Barraca", new Costo(150,0), "", 12);
	}

}
