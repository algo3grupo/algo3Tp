package fiuba.algo3.algocraft.unidadesProtoss;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Scout extends UnidadAtaqueBasico {

	public Scout(JFrame ventana, Vector2D posicion, Jugador jugador) {
		
		super(ventana, posicion, 150, 7, jugador, "Scout", new Costo(100,0), "Puerto Estelar", 3, 0, 9,new Ataque(8, 14, 4, 4));
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}
}
