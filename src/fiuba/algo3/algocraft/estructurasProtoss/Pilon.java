package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Pilon extends Protegidas {

	public Pilon(Jugador jugador) {
		super( 300, 0, jugador, "Pilon", new Costo(100,0), "");
	}
	
	public void actualizarPoblacion(){
		
		getJugador().aumentarPoblacion(5);
		
	}
}
