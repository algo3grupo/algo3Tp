package fiuba.algo3.algoCraft.estructurasProtoss;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.entidadesAbstractas.Recolectores;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class Asimilador extends Estructura implements Recolectores {
	public Asimilador(Jugador jugador) {
		super(jugador);
		this.nombre = "Asimilador";
		this.costo = new Costo(50,0);	
	}
	
	public void recolectarSuministro() {
		
	}
}
