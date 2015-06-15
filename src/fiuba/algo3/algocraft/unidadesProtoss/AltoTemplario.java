package fiuba.algo3.algocraft.unidadesProtoss;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class AltoTemplario extends UnidadEnergia {

	public AltoTemplario(JFrame ventana, Vector2D posicion, Jugador jugador) {
		super(ventana, posicion, 40, 7, jugador, "Alto Templario", new Costo(100,0), "Archivos Templarios", 2, 2, 7);
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

}
