package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algocraft.jugador.Jugador;

public class NaveTransporteProtoss extends UnidadNave {

	public NaveTransporteProtoss(Jugador jugador) {
		super( 80, 8, jugador, new Costo(100,0), 2, 8);
	}

}
