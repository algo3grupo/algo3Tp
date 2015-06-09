package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Acceso extends Protegidas{

	public Acceso(Jugador jugador) {
		
		super( 500, 0, jugador, "Acceso",new Costo(150,0), "");
		
	}

}
