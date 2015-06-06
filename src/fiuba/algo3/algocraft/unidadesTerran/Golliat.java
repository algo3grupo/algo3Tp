package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Golliat extends UnidadAtaqueBasico {

	public Golliat(Jugador jugador) {
		super(jugador);
		this.vida=125;
		this.rangoDeVision = 8;
		this.ataqueT = 12;
		this.suministro = 2;
		this.nombre = "Golliat";
		this.requiere  = "Fabrica";
		this.costo = new Costo(100,50);
	}

}
