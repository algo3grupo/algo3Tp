package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Marine extends UnidadAtaqueBasico {

	public Marine(Vector2D posicion, Jugador jugador) {
		super(posicion, 40, 7, jugador, "Marine", new Costo(50,0), "Barraca", 1, 1, 3,new Ataque( 6, 6, 4, 4));
	}

}
