package fiuba.algo3.algocraft.estructurasProtoss;

import java.util.ArrayList;

import fiuba.algo3.algocraft.Acciones.AumentarPoblacion;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Pilon extends Estructura {

	public Pilon(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, new VidaConEscudo(300,300), 0, jugador, "Pilon", new Costo(100,0), "", 5);
		this.agregarAccion(new AumentarPoblacion(this));
	}
	
	public void actualizarPoblacion(){
		
		getJugador().aumentarPoblacion(5);
		
	}

	
	public ArrayList<String> obtenerUnidadesCreables() 
	{
		ArrayList<String> unidades = new ArrayList<String>();
		
		return unidades;
	}
}
