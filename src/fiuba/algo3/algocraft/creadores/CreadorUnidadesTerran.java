package fiuba.algo3.algocraft.creadores;

import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.unidadesTerran.Espectro;
import fiuba.algo3.algocraft.unidadesTerran.Golliat;
import fiuba.algo3.algocraft.unidadesTerran.Marine;
import fiuba.algo3.algocraft.unidadesTerran.NaveCiencia;
import fiuba.algo3.algocraft.unidadesTerran.NaveTransporteTerran;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class CreadorUnidadesTerran extends CreadorUnidades {
	
	public CreadorUnidadesTerran(Jugador jugador){
		super();
		this.entidades.add(new Espectro(null,new Vector2D(), jugador));
		this.entidades.add(new Golliat(null,new Vector2D(), jugador));
		this.entidades.add(new Marine(null,new Vector2D(), jugador));
		this.entidades.add(new NaveCiencia(null,new Vector2D(), jugador));
		this.entidades.add(new NaveTransporteTerran(null,new Vector2D(), jugador));
	}

}
