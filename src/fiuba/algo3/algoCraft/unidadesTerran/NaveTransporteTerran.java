package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algocraft.jugador.Jugador;

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
