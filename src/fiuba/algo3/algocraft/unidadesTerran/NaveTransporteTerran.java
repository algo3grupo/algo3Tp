package fiuba.algo3.algocraft.unidadesTerran;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class NaveTransporteTerran extends UnidadNave {

	public NaveTransporteTerran(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension,posicion, new Vida(150), 8, jugador,  new Costo(125,50),  2, 7);
		
		setNombre("NaveTransporteTerran");
	}
}
