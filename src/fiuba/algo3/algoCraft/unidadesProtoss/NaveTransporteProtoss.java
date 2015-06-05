package fiuba.algo3.algoCraft.unidadesProtoss;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class NaveTransporteProtoss extends UnidadNave {

	public NaveTransporteProtoss(Jugador jugador) {
		super(jugador);
		this.vida= 80;
		this.rangoDeVision= 8;
		this.suministro = 2;
		this.nombre = "Nave Transporte";
		this.requiere  = "Puerto Estelar";
		this.costo = new Costo(100,0);
	}

}
