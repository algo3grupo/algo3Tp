package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class PuertoEstelar extends Protegidas {

	public PuertoEstelar(Vector2D posicion, Jugador jugador) {
		super(posicion, 600, 0, jugador, "Puerto Estelar", new Costo(150,150), "Acceso", 10);
	}

}
