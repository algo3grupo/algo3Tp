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
		entidades.add( new Asimilador(null, new Vector2D(), jugador) );
		entidades.add( new NexoMineral(null, new Vector2D(), jugador) );
		entidades.add( new Pilon(null, new Vector2D(), jugador) );
		entidades.add( new Acceso(null, new Vector2D(), jugador) );
		entidades.add( new PuertoEstelar(null, new Vector2D(), jugador) );
		entidades.add( new ArchivosTemplarios(null, new Vector2D(), jugador) );
	}

}
