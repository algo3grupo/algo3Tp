package fiuba.algo3.algoCraft.unidadesTerran;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class NaveTransporteTerran extends UnidadNave {

	public NaveTransporteTerran(Jugador jugador) {
		super(jugador);
		this.vida= 150;
		this.rangoDeVision= 8;
		this.suministro = 2;
		this.nombre = "Nave Transporte";
		this.requiere  = "Puerto Estelar";
		this.costo = new Costo(125,50);
	}

}
