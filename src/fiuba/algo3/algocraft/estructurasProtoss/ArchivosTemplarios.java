package fiuba.algo3.algocraft.estructurasProtoss;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class ArchivosTemplarios extends Protegidas {

	public ArchivosTemplarios(JFrame ventana, Vector2D posicion, Jugador jugador) {
		super(ventana, posicion, 500, 0, jugador, "Archivos Templarios", new Costo(150,200), "Puerto Estelar", 9);
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

}
