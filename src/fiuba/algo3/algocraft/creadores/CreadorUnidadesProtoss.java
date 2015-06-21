package fiuba.algo3.algocraft.creadores;

import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.unidadesProtoss.AltoTemplario;
import fiuba.algo3.algocraft.unidadesProtoss.Dragon;
import fiuba.algo3.algocraft.unidadesProtoss.NaveTransporteProtoss;
import fiuba.algo3.algocraft.unidadesProtoss.Scout;
import fiuba.algo3.algocraft.unidadesProtoss.Zealot;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class CreadorUnidadesProtoss extends CreadorUnidades {
	
	public CreadorUnidadesProtoss(Jugador jugador){
		super();
		agregarEntidad(new Zealot(0,new Vector2D(), jugador));
		agregarEntidad(new Dragon(0,new Vector2D(), jugador));
		agregarEntidad(new Scout(0,new Vector2D(), jugador));
		agregarEntidad(new AltoTemplario(0,new Vector2D(), jugador));
		agregarEntidad(new NaveTransporteProtoss(0,new Vector2D(), jugador));
	}
	
}
