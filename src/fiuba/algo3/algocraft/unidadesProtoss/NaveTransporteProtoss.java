package fiuba.algo3.algocraft.unidadesProtoss;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Interfaces.IEfectoEMP;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class NaveTransporteProtoss extends UnidadNave implements IEfectoEMP {

	public NaveTransporteProtoss(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 80, 8, jugador, new Costo(100,0), 2, 8);
		construirEscudo(60);
	}

	@Override
	public void dibujar(Graphics contexto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void atacadoPorEMP() {
		desactivarEscudo();
	}
	

}
