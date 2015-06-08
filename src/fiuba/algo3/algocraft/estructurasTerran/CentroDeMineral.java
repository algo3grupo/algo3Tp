package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class CentroDeMineral extends Estructura implements IRecolectores {

	public CentroDeMineral(Jugador jugador) {
		super(0, 500, 0, jugador, "Centro De Minerales", new Costo(50,0), "");
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		getJugador().agregarMineral(10);
	}
}
