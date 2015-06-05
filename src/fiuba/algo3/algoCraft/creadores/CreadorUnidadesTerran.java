package fiuba.algo3.algoCraft.creadores;

import fiuba.algo3.algoCraft.jugador.Jugador;
import fiuba.algo3.algoCraft.unidadesTerran.Espectro;
import fiuba.algo3.algoCraft.unidadesTerran.Golliat;
import fiuba.algo3.algoCraft.unidadesTerran.Marine;
import fiuba.algo3.algoCraft.unidadesTerran.NaveCiencia;
import fiuba.algo3.algoCraft.unidadesTerran.NaveTransporteTerran;

public class CreadorUnidadesTerran extends CreadorUnidades {
	
	public CreadorUnidadesTerran(Jugador jugador){
		super();
		this.entidades.add(new Espectro(jugador));
		this.entidades.add(new Golliat(jugador));
		this.entidades.add(new Marine(jugador));
		this.entidades.add(new NaveCiencia(jugador));
		this.entidades.add(new NaveTransporteTerran(jugador));
	}

}
