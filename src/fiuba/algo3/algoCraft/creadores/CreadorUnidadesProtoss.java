package fiuba.algo3.algocraft.creadores;

import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.unidadesProtoss.AltoTemplario;
import fiuba.algo3.algocraft.unidadesProtoss.Dragon;
import fiuba.algo3.algocraft.unidadesProtoss.NaveTransporteProtoss;
import fiuba.algo3.algocraft.unidadesProtoss.Scout;
import fiuba.algo3.algocraft.unidadesProtoss.Zealot;

public class CreadorUnidadesProtoss extends CreadorUnidades {
	
	public CreadorUnidadesProtoss(Jugador jugador){
		super();
		this.entidades.add(new Zealot(jugador));
		this.entidades.add(new Dragon(jugador));
		this.entidades.add(new Scout(jugador));
		this.entidades.add(new AltoTemplario(jugador));
		this.entidades.add(new NaveTransporteProtoss(jugador));
	}
	
}
