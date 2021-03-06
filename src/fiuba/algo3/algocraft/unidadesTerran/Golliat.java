package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Golliat extends UnidadAtaqueBasico {

	public Golliat(int dimension, Vector2D posicion, Jugador jugador) {
		
		super(dimension, posicion, new Vida(125), 8, jugador, "Golliat", new Costo(100,50), "Fabrica", 2, 2, 6,new Ataque(12, 10, 6*dimension, 5*dimension));
		
	}

}
