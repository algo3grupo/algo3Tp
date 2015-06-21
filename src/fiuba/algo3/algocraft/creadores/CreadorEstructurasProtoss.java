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
		agregarEntidad( new Asimilador(0, new Vector2D(), jugador) );
		agregarEntidad( new NexoMineral(0, new Vector2D(), jugador) );
		agregarEntidad( new Pilon(0, new Vector2D(), jugador) );
		agregarEntidad( new Acceso(0, new Vector2D(), jugador) );
		agregarEntidad( new PuertoEstelar(0, new Vector2D(), jugador) );
		agregarEntidad( new ArchivosTemplarios(0, new Vector2D(), jugador) );
	}

}
