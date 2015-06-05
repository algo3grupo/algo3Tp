package fiuba.algo3.algoCraft.estructurasTerran;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.entidadesAbstractas.Recolectores;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class Refineria extends Estructura implements Recolectores {

	public Refineria(Jugador jugador) {
		super(jugador);
		this.nombre = "Refineria";
		this.costo = new Costo(100,0);
	}
	
	public void recolectarSuministro() {
		
	}

}
