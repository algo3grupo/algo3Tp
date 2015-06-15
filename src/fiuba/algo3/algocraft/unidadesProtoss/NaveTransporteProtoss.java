package fiuba.algo3.algocraft.unidadesProtoss;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class NaveTransporteProtoss extends UnidadNave {

	public NaveTransporteProtoss(JFrame ventana, Vector2D posicion, Jugador jugador) {
		super(ventana, posicion, 80, 8, jugador, new Costo(100,0), 2, 8);
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

}
