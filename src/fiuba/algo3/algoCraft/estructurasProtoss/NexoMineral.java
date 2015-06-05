package fiuba.algo3.algoCraft.estructurasProtoss;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.entidadesAbstractas.Recolectores;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class NexoMineral extends Estructura implements Recolectores{

	public NexoMineral(Jugador jugador) {
		super(jugador);
		this.nombre = "Nexo Mineral";
		this.costo = new Costo(50,0); 
	}
	
	public void recolectarSuministro() {
		
	}

}
