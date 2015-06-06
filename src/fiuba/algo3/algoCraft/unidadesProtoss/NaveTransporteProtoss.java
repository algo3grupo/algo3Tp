package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algocraft.jugador.Jugador;

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
