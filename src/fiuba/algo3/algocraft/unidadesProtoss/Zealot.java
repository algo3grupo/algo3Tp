package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Zealot extends UnidadAtaqueBasico {

	public Zealot(Jugador jugador) {
		super(0, 100, 1, jugador, "Zealot", new Costo(100,0), "Acceso",2, 8);
	}

}
