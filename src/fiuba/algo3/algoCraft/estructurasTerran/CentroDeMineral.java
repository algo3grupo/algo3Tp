package fiuba.algo3.algoCraft.estructurasTerran;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.entidadesAbstractas.Recolectores;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class CentroDeMineral extends Estructura implements Recolectores {

	public CentroDeMineral(Jugador jugador) {
		super(jugador);
		this.nombre = "Centro De Minerales";
		this.costo = new Costo(50,0);
	}
	
	public void recolectarSuministro() {
		
	}
}
