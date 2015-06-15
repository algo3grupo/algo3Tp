package fiuba.algo3.algocraft.estructurasProtoss;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class PuertoEstelar extends Protegidas {

	public PuertoEstelar(JFrame ventana, Vector2D posicion, Jugador jugador) {
		super(ventana, posicion, 600, 0, jugador, "Puerto Estelar", new Costo(150,150), "Acceso", 10);
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

}
