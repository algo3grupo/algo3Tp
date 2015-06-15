package fiuba.algo3.algocraft.unidadesProtoss;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class UnidadCopia extends Unidad{

	public UnidadCopia(Vector2D posicion, Unidad unidad) {
		
		super(unidad.obtenerVentana(), posicion, 0, 5, unidad.getJugador(), unidad.nombre(), new Costo(0,0), "", 0, unidad.transporte(), 0 );

	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

}
