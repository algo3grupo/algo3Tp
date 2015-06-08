package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.jugador.Jugador;

public class AltoTemplario extends UnidadEnergia {

	public AltoTemplario(Jugador jugador) {
		super(0, 40, 7, jugador, "Alto Templario", new Costo(100,0), "Archivos Templarios", 2);
	}

}
