package fiuba.algo3.algocraft.estructurasTerran;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Acciones.AumentarPoblacion;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class DepositoSuministro extends Estructura {

	public DepositoSuministro(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 500, 0, jugador, "Deposito Suministro", new Costo(100,0), "", 6);
		this.agregarAccion(new AumentarPoblacion(this));
	}
	
	public void actualizarPoblacion(){
		
		getJugador().aumentarPoblacion(5);
	}
}
