package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algocraft.jugador.Jugador;

public class NaveTransporteTerran extends UnidadNave {

	public NaveTransporteTerran(Jugador jugador) {
		super( 150, 8, jugador,  new Costo(125,50),  2, 7);
	}

}
