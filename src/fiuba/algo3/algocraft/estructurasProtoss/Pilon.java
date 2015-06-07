package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Pilon extends Protegidas {

	public Pilon(Jugador jugador) {
		super(jugador);
		this.nombre = "Pilon";
		this.costo = new Costo(100,0); 
		this.vida = 300;
		inicializarCampoYLimiteCampo(300);
	}
	
	public void actualizarPoblacion(){
		
		this.jugador.aumentarPoblacion(5);
		
	}
}
