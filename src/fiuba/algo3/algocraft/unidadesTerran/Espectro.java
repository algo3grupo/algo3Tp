package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Espectro extends UnidadAtaqueBasico {

	public Espectro(Jugador jugador) {
		super(jugador);
		this.vida = 120;
		this.rangoDeVision = 7;
		this.ataqueT= 8;
		this.suministro = 2;
		this.nombre = "Espectro";
		this.requiere  = "Puerto Estelar";
		this.costo = new Costo(150,100);
	}

}
