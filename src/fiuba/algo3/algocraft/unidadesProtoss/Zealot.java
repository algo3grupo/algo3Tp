package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Zealot extends UnidadAtaqueBasico {

	public Zealot(Jugador jugador) {
		super(jugador);
		this.vida=100;
		this.rangoDeVision=1;
		this.ataqueT=8;
		this.suministro = 2;
		this.nombre = "Zealot";
		this.requiere  = "Acceso";
		this.costo = new Costo(100,0);
	}

}