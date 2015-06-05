package fiuba.algo3.algoCraft.estructurasTerran;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class DepositoSuministro extends Estructura {

	public DepositoSuministro(Jugador jugador) {
		super(jugador);
		this.nombre = "Deposito Suministro";
		this.costo = new Costo(100,0);
	}
	
	public void actualizarPoblacion(){
		
		this.jugador.aumentarPoblacion(5);
		
	}
}
