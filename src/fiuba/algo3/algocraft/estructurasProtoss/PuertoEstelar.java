package fiuba.algo3.algocraft.estructurasProtoss;

import java.util.ArrayList;

import fiuba.algo3.algocraft.Acciones.RecuperarCampo;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class PuertoEstelar extends Estructura {

	public PuertoEstelar(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, new VidaConEscudo(600,600), 0, jugador, "Puerto Estelar", new Costo(150,150), "Acceso", 10);
	
		agregarAccion(new RecuperarCampo(this));
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
