package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class PuertoEstelarT extends Estructura {

	public PuertoEstelarT(Jugador jugador) {
		super(jugador);
		this.nombre = "Puerto Estelar";
		this.costo = new Costo(150,100);
		this.requiere = "Fabrica";
		this.vida = 1300;
	}

}
