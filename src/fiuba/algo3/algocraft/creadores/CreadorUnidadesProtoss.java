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
		this.entidades.add(new Zealot(0,null,new Vector2D(), jugador));
		this.entidades.add(new Dragon(0,null,new Vector2D(), jugador));
		this.entidades.add(new Scout(0,null,new Vector2D(), jugador));
		this.entidades.add(new AltoTemplario(0,null,new Vector2D(), jugador));
		this.entidades.add(new NaveTransporteProtoss(0,null,new Vector2D(), jugador));
	}
	
}
