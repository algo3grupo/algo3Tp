package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class DepositoSuministro extends Estructura {

	public DepositoSuministro(Vector2D posicion, Jugador jugador) {
		super(posicion, 500, 0, jugador, "Deposito Suministro", new Costo(100,0), "", 6);
	}
	
	public void actualizarPoblacion(){
		
		getJugador().aumentarPoblacion(5);
	}
}
