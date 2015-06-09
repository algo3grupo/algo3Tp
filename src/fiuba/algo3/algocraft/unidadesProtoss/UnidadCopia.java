package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.jugador.Jugador;

public class UnidadCopia extends Unidad {

	public UnidadCopia(Unidad unidad) {
		super( 0, 5, unidad.getJugador(), unidad.nombre(), new Costo(0,0), "", 0, unidad.transporte(), 0 );

	}

}
