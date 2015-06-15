package fiuba.algo3.algocraft.estructurasTerran;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Refineria extends Estructura implements IRecolectores {

	public Refineria(JFrame ventana, Vector2D posicion, Jugador jugador) {
		super(ventana, posicion, 750, 0, jugador, "Refineria", new Costo(100,0), "", 6);
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		getJugador().agregarGas(10);
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

}
