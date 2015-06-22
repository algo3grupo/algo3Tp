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

public class Asimilador extends Protegidas implements IRecolectores {
	
	public Asimilador(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 450, 0, jugador, "Asimilador", new Costo(50,0), "", 8);
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		getJugador().agregarGas(10);
	}

	public ArrayList<String> obtenerUnidadesCreables() 
	{
		return new ArrayList<String>();
	}

	
	public boolean haySuministroEn(Vector2D posicion) {
		
		return getJugador().getMundo().hayGas(posicion);
	}
	
}
