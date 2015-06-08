package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Golliat extends UnidadAtaqueBasico {

	public Golliat(Jugador jugador) {
		
		super(0, 125, 8, jugador, "Golliat", new Costo(100,50), "Fabrica", 2, new Ataque(12, 10, 6, 5));
		
	}

}
