package fiuba.algo3.algocraft.estructurasTerran;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Refineria extends Estructura implements IRecolectores {

	public Refineria(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 750, 0, jugador, "Refineria", new Costo(100,0), "", 6);
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		getJugador().agregarGas(10);
	}

	
	public ArrayList<String> obtenerUnidadesCreables() 
	{
		ArrayList<String> unidades = new ArrayList<String>();
		
		return unidades;
	}

	public boolean haySuministroEn(Vector2D posicion) {
		
		return getJugador().getMundo().hayGas(posicion);
	}
}
