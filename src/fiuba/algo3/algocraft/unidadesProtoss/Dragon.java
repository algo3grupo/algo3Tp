package fiuba.algo3.algocraft.unidadesProtoss;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Dragon extends UnidadAtaqueBasico {

	public Dragon(JFrame ventana, Vector2D posicion, Jugador jugador) {
		
		super(ventana, posicion, 100, 1, jugador, "Dragon", new Costo(125,50), "Acceso", 2 , 4, 6 ,new Ataque(20, 20, 4, 4));
		
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

}
