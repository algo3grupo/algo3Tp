package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.jugador.Jugador;

public class NaveCiencia extends UnidadEnergia {

	public NaveCiencia(Jugador jugador) {
		super(jugador);
		this.vida= 200;
		this.rangoDeVision= 10;
		this.suministro = 2;
		this.nombre = "Nave Ciencia";
		this.requiere  = "Puerto Estelar";
		this.costo = new Costo(125,50);
	}

}
