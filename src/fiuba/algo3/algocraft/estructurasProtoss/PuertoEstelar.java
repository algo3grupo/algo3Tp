package fiuba.algo3.algocraft.estructurasProtoss;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class PuertoEstelar extends Protegidas {

	public PuertoEstelar(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 600, 0, jugador, "Puerto Estelar", new Costo(150,150), "Acceso", 10);
	}

	
	public ArrayList<String> obtenerUnidadesCreables() 
	{
		ArrayList<String> unidades = new ArrayList<String>();
		if (estaHabilitada()){
			unidades.add("Scout");
			unidades.add("NaveTransporteProtoss");
		}
		return unidades;
	}
}
