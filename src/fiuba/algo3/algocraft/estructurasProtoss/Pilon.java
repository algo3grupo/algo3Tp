package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Pilon extends Protegidas {

	public Pilon(Vector2D posicion, Jugador jugador) {
		super(posicion, 300, 0, jugador, "Pilon", new Costo(100,0), "", 5);
	}
	
	public void actualizarPoblacion(){
		
		getJugador().aumentarPoblacion(5);
		
	}
}
