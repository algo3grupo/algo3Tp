package fiuba.algo3.algoCraft.unidadesProtoss;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class Scout extends UnidadAtaqueBasico {

	public Scout(Jugador jugador) {
		super(jugador);
		this.vida= 150;
		this.rangoDeVision= 7;
		this.ataqueT= 8;
		this.suministro = 3;
		this.nombre = "Scout";
		this.requiere = "Puerto Estelar";
		this.costo = new Costo(100,0);
	}
}
