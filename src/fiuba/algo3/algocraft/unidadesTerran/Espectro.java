package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Espectro extends UnidadAtaqueBasico {

	public Espectro(Jugador jugador) {
		
		super( 120, 7, jugador, "Espectro", new Costo(150,100), "Puerto Estelar", 2, 0, 8,new Ataque( 8, 20, 5, 5));
	}

}
