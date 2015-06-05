package fiuba.algo3.algoCraft.estructurasProtoss;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.jugador.Jugador;

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
