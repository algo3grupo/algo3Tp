package fiuba.algo3.algoCraft.creadores;

import fiuba.algo3.algoCraft.estructurasProtoss.Acceso;
import fiuba.algo3.algoCraft.estructurasProtoss.ArchivosTemplarios;
import fiuba.algo3.algoCraft.estructurasProtoss.Asimilador;
import fiuba.algo3.algoCraft.estructurasProtoss.NexoMineral;
import fiuba.algo3.algoCraft.estructurasProtoss.Pilon;
import fiuba.algo3.algoCraft.estructurasProtoss.PuertoEstelar;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class CreadorEstructurasProtoss extends CreadorEstructuras {
	
	public CreadorEstructurasProtoss(Jugador jugador){
		super();
		entidades.add( new Asimilador(jugador) );
		entidades.add( new NexoMineral(jugador) );
		entidades.add( new Pilon(jugador) );
		entidades.add( new Acceso(jugador) );
		entidades.add( new PuertoEstelar(jugador) );
		entidades.add( new ArchivosTemplarios(jugador) );
	}

}
