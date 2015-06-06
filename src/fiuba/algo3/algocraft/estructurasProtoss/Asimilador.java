package fiuba.algo3.algocraft.estructurasProtoss;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Asimilador extends Protegidas implements IRecolectores {
	public Asimilador(Jugador jugador) {
		super(jugador);
		this.nombre = "Asimilador";
		this.costo = new Costo(50,0);
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		getJugador().agregarMineral(10);
	}
}
