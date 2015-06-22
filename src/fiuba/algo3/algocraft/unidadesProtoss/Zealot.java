package fiuba.algo3.algocraft.unidadesProtoss;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Interfaces.IEfectoEMP;
import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Zealot extends UnidadAtaqueBasico implements IEfectoEMP {

	public Zealot(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 100, 1, jugador, "Zealot", new Costo(100,0), "Acceso",2, 2, 4, new Ataque(8, 0, 1*dimension, 0));
		construirEscudo(60);
	}

	@Override
	public void atacadoPorEMP() {
		desactivarEscudo();
		
	}

}
