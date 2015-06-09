package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.jugador.Jugador;

public class NaveCiencia extends UnidadEnergia {

	public NaveCiencia(Jugador jugador) {
		super( 200, 10, jugador, "Nave Ciencia", new Costo(125,50), "Puerto Estelar", 2);
	}

}
