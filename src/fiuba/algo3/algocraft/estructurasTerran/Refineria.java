package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Refineria extends Estructura implements IRecolectores {

	public Refineria(Jugador jugador) {
		super(0, 750, 0, jugador, "Refineria", new Costo(100,0), "");
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		getJugador().agregarGas(10);
	}

}
