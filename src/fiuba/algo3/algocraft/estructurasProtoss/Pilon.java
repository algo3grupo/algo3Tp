package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Pilon extends Estructura {

	public Pilon(Jugador jugador) {
		super(jugador);
		this.nombre = "Pilon";
		this.costo = new Costo(100,0); 
	}
	
	public void actualizarPoblacion(){
		
		this.jugador.aumentarPoblacion(5);
		
	}
}
