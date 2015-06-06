package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.jugador.Jugador;

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
