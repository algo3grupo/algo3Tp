package fiuba.algo3.algocraft.estructurasProtoss;

import java.util.ArrayList;

import fiuba.algo3.algocraft.Acciones.RecuperarCampo;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Acceso extends Estructura{

	public Acceso(int dimension, Vector2D posicion, Jugador jugador) {
		
		super(dimension, posicion, new VidaConEscudo(500,500), 0, jugador, "Acceso",new Costo(150,0), "", 8);
		
		agregarAccion(new RecuperarCampo(this));
		
	}

	public ArrayList<String> obtenerUnidadesCreables() 
	{
		ArrayList<String> unidades = new ArrayList<String>();
		if (estaHabilitada()){
			unidades.add("Zealot");
			unidades.add("Dragon");
		}
		return unidades;
	}

}
