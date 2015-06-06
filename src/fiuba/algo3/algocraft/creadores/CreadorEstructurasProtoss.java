package fiuba.algo3.algocraft.creadores;

import fiuba.algo3.algocraft.estructurasProtoss.Acceso;
import fiuba.algo3.algocraft.estructurasProtoss.ArchivosTemplarios;
import fiuba.algo3.algocraft.estructurasProtoss.Asimilador;
import fiuba.algo3.algocraft.estructurasProtoss.NexoMineral;
import fiuba.algo3.algocraft.estructurasProtoss.Pilon;
import fiuba.algo3.algocraft.estructurasProtoss.PuertoEstelar;
import fiuba.algo3.algocraft.jugador.Jugador;

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
