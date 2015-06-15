package fiuba.algo3.algocraft.creadores;

import fiuba.algo3.algocraft.estructurasProtoss.Acceso;
import fiuba.algo3.algocraft.estructurasProtoss.ArchivosTemplarios;
import fiuba.algo3.algocraft.estructurasProtoss.Asimilador;
import fiuba.algo3.algocraft.estructurasProtoss.NexoMineral;
import fiuba.algo3.algocraft.estructurasProtoss.Pilon;
import fiuba.algo3.algocraft.estructurasProtoss.PuertoEstelar;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class CreadorEstructurasProtoss extends CreadorEstructuras {
	
	public CreadorEstructurasProtoss(Jugador jugador){
		super();
		entidades.add( new Asimilador(0,null, new Vector2D(), jugador) );
		entidades.add( new NexoMineral(0,null, new Vector2D(), jugador) );
		entidades.add( new Pilon(0,null, new Vector2D(), jugador) );
		entidades.add( new Acceso(0,null, new Vector2D(), jugador) );
		entidades.add( new PuertoEstelar(0,null, new Vector2D(), jugador) );
		entidades.add( new ArchivosTemplarios(0,null, new Vector2D(), jugador) );
	}

}
