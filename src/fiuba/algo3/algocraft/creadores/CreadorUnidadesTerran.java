package fiuba.algo3.algocraft.creadores;

import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.unidadesTerran.Espectro;
import fiuba.algo3.algocraft.unidadesTerran.Golliat;
import fiuba.algo3.algocraft.unidadesTerran.Marine;
import fiuba.algo3.algocraft.unidadesTerran.NaveCiencia;
import fiuba.algo3.algocraft.unidadesTerran.NaveTransporteTerran;

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
