package fiuba.algo3.algocraft.estructurasProtoss;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Asimilador extends Protegidas implements IRecolectores {
	
	public Asimilador(JFrame ventana, Vector2D posicion, Jugador jugador) {
		super(ventana, posicion, 450, 0, jugador, "Asimilador", new Costo(50,0), "", 8);
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		
		getJugador().agregarMineral(10);
	}

	@Override
	public void dibujar() {
		// TODO Auto-generated method stub
		
	}

	
	
}
