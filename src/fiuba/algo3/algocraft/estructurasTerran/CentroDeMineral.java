package fiuba.algo3.algocraft.estructurasTerran;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;

public class CentroDeMineral extends Estructura implements IRecolectores {

	public CentroDeMineral(Jugador jugador) {
		super(jugador);
		this.nombre = "Centro De Minerales";
		this.costo = new Costo(50,0);
		this.vida = 500;
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		getJugador().agregarMineral(10);
	}
}
