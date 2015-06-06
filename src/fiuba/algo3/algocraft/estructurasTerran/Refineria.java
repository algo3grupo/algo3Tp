package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Recolectores;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Refineria extends Estructura implements Recolectores {

	public Refineria(Jugador jugador) {
		super(jugador);
		this.nombre = "Refineria";
		this.costo = new Costo(100,0);
	}
	
	public void recolectarSuministro() {
		
	}

}
