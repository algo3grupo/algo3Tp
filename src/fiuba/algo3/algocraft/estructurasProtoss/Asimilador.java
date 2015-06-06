package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Recolectores;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Asimilador extends Estructura implements Recolectores {
	public Asimilador(Jugador jugador) {
		super(jugador);
		this.nombre = "Asimilador";
		this.costo = new Costo(50,0);	
	}
	
	public void recolectarSuministro() {
		
	}
}
