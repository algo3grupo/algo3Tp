package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class DepositoSuministro extends Estructura {

	public DepositoSuministro(Jugador jugador) {
		super( 500, 0, jugador, "Deposito Suministro", new Costo(100,0), "");
	}
	
	public void actualizarPoblacion(){
		
		getJugador().aumentarPoblacion(5);
	}
}
