package fiuba.algo3.algocraft.unidadesProtoss;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Interfaces.IEfectoEMP;
import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Dragon extends UnidadAtaqueBasico implements IEfectoEMP {

	public Dragon(int dimension, Vector2D posicion, Jugador jugador) {
		
		super(dimension, posicion, new VidaConEscudo(100,800), 1, jugador, "Dragon", new Costo(125,50), "Acceso", 2 , 4, 6 ,new Ataque(20, 20, 4*dimension, 4*dimension));
		
	}

	
	public void atacadoPorEMP() {
		desactivarEscudo();
	}

}
