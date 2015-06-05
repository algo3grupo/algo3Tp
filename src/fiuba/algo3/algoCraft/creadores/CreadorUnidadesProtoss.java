package fiuba.algo3.algoCraft.creadores;

import fiuba.algo3.algoCraft.jugador.Jugador;
import fiuba.algo3.algoCraft.unidadesProtoss.AltoTemplario;
import fiuba.algo3.algoCraft.unidadesProtoss.Dragon;
import fiuba.algo3.algoCraft.unidadesProtoss.NaveTransporteProtoss;
import fiuba.algo3.algoCraft.unidadesProtoss.Scout;
import fiuba.algo3.algoCraft.unidadesProtoss.Zealot;

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
