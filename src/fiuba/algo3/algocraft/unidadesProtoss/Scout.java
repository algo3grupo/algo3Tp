package fiuba.algo3.algocraft.unidadesProtoss;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Interfaces.IEfectoEMP;
import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Scout extends UnidadAtaqueBasico implements IEfectoEMP{

	public Scout(int dimension, Vector2D posicion, Jugador jugador) {
		
		super(dimension, posicion, 150, 7, jugador, "Scout", new Costo(100,0), "Puerto Estelar", 3, 0, 9,new Ataque(8, 14, 4*dimension, 4*dimension));
		construirEscudo(100);
	}

	@Override
	public void atacadoPorEMP() {
		desactivarEscudo();
		
	}
}
