package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class DepositoSuministro extends Estructura {

	public DepositoSuministro(Jugador jugador) {
		super(jugador);
		this.nombre = "Deposito Suministro";
		this.costo = new Costo(100,0);
		this.vida = 500;
	}
	
	public void actualizarPoblacion(){
		
		this.jugador.aumentarPoblacion(5);
		
	}
}
