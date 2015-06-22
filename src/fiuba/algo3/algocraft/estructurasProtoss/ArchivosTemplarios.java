package fiuba.algo3.algocraft.estructurasProtoss;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class ArchivosTemplarios extends Protegidas {

	public ArchivosTemplarios(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 500, 0, jugador, "Archivos Templarios", new Costo(150,200), "Puerto Estelar", 9);
	}

	public ArrayList<String> obtenerUnidadesCreables() 
	{
		ArrayList<String> unidades = new ArrayList<String>();
		if (estaHabilitada()){
			unidades.add("AltoTemplario");
		}
		return unidades;
	}

}
