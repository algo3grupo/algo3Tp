package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algocraft.jugador.Jugador;

public class NaveTransporteTerran extends UnidadNave {

	public NaveTransporteTerran(Jugador jugador) {
		super(0, 150, 8, jugador, "Nave Transporte", new Costo(125,50), "Puerto Estelar", 2);
	}

}
