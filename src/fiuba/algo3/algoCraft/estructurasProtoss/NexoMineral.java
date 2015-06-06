package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Recolectores;
import fiuba.algo3.algocraft.jugador.Jugador;

public class NexoMineral extends Estructura implements Recolectores{

	public NexoMineral(Jugador jugador) {
		super(jugador);
		this.nombre = "Nexo Mineral";
		this.costo = new Costo(50,0); 
	}
	
	public void recolectarSuministro() {
		
	}

}
