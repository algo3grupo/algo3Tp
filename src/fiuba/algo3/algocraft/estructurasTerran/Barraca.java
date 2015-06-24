package fiuba.algo3.algocraft.estructurasTerran;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Barraca extends Estructura {

	public Barraca(int dimension,  Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, new Vida(1000), 0, jugador, "Barraca", new Costo(150,0), "", 12);
	}

	public ArrayList<String> obtenerUnidadesCreables() 
	{
		ArrayList<String> unidades = new ArrayList<String>();
		if (estaHabilitada()){
			unidades.add("Marine");
		}
		return unidades;
	}
}
