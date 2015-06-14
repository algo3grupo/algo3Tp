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
		entidades.add( new Asimilador(new Vector2D(), jugador) );
		entidades.add( new NexoMineral(new Vector2D(), jugador) );
		entidades.add( new Pilon(new Vector2D(), jugador) );
		entidades.add( new Acceso(new Vector2D(), jugador) );
		entidades.add( new PuertoEstelar(new Vector2D(), jugador) );
		entidades.add( new ArchivosTemplarios(new Vector2D(), jugador) );
	}

}
