package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class NaveCiencia extends UnidadEnergia {

	public NaveCiencia(Vector2D posicion, Jugador jugador) {
		super(posicion, 200, 10, jugador, "Nave Ciencia", new Costo(125,50), "Puerto Estelar", 2, 0, 10);
	}

}
