package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Marine extends UnidadAtaqueBasico {

	public Marine(Jugador jugador) {
		super(jugador);
		this.vida = 40;
		this.rangoDeVision = 7;
		this.ataqueT = 6;
		this.suministro = 1;
		this.nombre = "Marine";
		this.requiere  = "Barraca";
		this.costo = new Costo(50,0);
	}

}
