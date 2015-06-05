package fiuba.algo3.algoCraft.unidadesTerran;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algoCraft.jugador.Jugador;

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
