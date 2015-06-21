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
		agregarEntidad(new Espectro(0,new Vector2D(), jugador));
		agregarEntidad(new Golliat(0,new Vector2D(), jugador));
		agregarEntidad(new Marine(0,new Vector2D(), jugador));
		agregarEntidad(new NaveCiencia(0,new Vector2D(), jugador));
		agregarEntidad(new NaveTransporteTerran(0,new Vector2D(), jugador));
	}

}
