package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;

public class NexoMineral extends Protegidas implements IRecolectores{

	public NexoMineral(Jugador jugador) 
	{
		super(0, 250, 0, jugador, "Nexo Mineral", new Costo(50,0), "");
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		getJugador().agregarGas(10);
	}

}
