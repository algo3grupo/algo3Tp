package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Recolectores;
import fiuba.algo3.algocraft.jugador.Jugador;

public class CentroDeMineral extends Estructura implements Recolectores {

	public CentroDeMineral(Jugador jugador) {
		super(jugador);
		this.nombre = "Centro De Minerales";
		this.costo = new Costo(50,0);
	}
	
	public void recolectarSuministro() {
		
	}
}
