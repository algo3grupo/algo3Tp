package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Fabrica extends Estructura {

	public Fabrica(Jugador jugador) {
		super(jugador);
		this.nombre = "Fabrica";
		this.costo = new Costo(200,100);
		this.requiere = "Barraca";
		this.vida = 1250;
	}

}
