package fiuba.algo3.algoCraft.unidadesProtoss;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class AltoTemplario extends UnidadEnergia {

	public AltoTemplario(Jugador jugador) {
		super(jugador);
		this.vida= 40;
		this.rangoDeVision= 7;
		this.suministro = 2;
		this.nombre = "Alto Templario";
		this.requiere = "Archivos Templarios";
		this.costo = new Costo(100,0);
	}

}
