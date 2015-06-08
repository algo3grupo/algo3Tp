package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Scout extends UnidadAtaqueBasico {

	public Scout(Jugador jugador) {
		super(0, 150, 7, jugador, "Scout", new Costo(100,0), "Puerto Estelar", 3, 8);
	}
}
