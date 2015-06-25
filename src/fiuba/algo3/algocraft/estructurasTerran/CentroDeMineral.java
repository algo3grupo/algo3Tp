package fiuba.algo3.algocraft.estructurasTerran;


import java.util.ArrayList;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class CentroDeMineral extends Estructura implements IRecolectores {

	public CentroDeMineral(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, new Vida(500), 0, jugador, "Centro De Minerales", new Costo(50,0), "", 4);
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		getJugador().agregarMineral(10);
	}

	
	public ArrayList<String> obtenerUnidadesCreables() 
	{
		ArrayList<String> unidades = new ArrayList<String>();
		
		return unidades;
	}

	public boolean haySuministroEn(Vector2D posicion) {
		
		return getJugador().getMundo().hayMineral(posicion);
	}
}
