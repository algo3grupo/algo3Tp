package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class PuertoEstelarT extends Estructura {

	public PuertoEstelarT(Vector2D posicion, Jugador jugador) {
		super( posicion, 1300, 0, jugador, "Puerto Estelar", new Costo(150,100), "Fabrica", 10);
	}

}
