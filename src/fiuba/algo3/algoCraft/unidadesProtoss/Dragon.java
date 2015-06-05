package fiuba.algo3.algoCraft.unidadesProtoss;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algoCraft.jugador.Jugador;

public class Dragon extends UnidadAtaqueBasico {

	public Dragon(Jugador jugador) {
		super(jugador);
		this.vida= 100;
		this.rangoDeVision=1;
		this.ataqueT=8;
		this.suministro = 2;
		this.nombre = "Dragon";
		this.requiere  = "Acceso";
		this.costo = new Costo(125,50);
	}

}
