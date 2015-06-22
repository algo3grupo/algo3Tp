package fiuba.algo3.algocraft.estructurasProtoss;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class NexoMineral extends Protegidas implements IRecolectores{

	public NexoMineral(int dimension, Vector2D posicion, Jugador jugador) 
	{
		super(dimension, posicion, 250, 0, jugador, "Nexo Mineral", new Costo(50,0), "", 4);
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		getJugador().agregarMineral(10);
	}

	public ArrayList<String> obtenerUnidadesCreables() 
	{
		return new ArrayList<String>();
	}

	public boolean haySuministroEn(Vector2D posicion) {
		
		return getJugador().getMundo().hayMineral(posicion);
	}
}
