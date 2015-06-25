package fiuba.algo3.algocraft.estructurasTerran;

import java.util.ArrayList;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class PuertoEstelarT extends Estructura {

	public PuertoEstelarT(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, new Vida(1300), 0, jugador, "Puerto Estelar", new Costo(150,100), "Fabrica", 10);
	}


	public ArrayList<String> obtenerUnidadesCreables() 
	{
		ArrayList<String> unidades = new ArrayList<String>();
		if (estaHabilitada()){
			unidades.add("Espectro");
			unidades.add("NaveTransporteTerran");
			unidades.add("NaveCiencia");
		}
		return unidades;
	}
}
