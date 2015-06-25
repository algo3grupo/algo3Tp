package fiuba.algo3.algocraft.atributos;

import java.util.ArrayList;

import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class HechizoAreaDeEfecto extends Hechizo {
	private int radioDeEfecto;

	public HechizoAreaDeEfecto(int costo, int radioEfecto) {
		super(costo);
		radioDeEfecto = radioEfecto;
	}
	
	public void lanzarHechizoA(Jugador jugador,Vector2D centro, Mundo mundo){
		
		Unidad afectada;
		ArrayList<Unidad> unidades = mundo.obtenerUnidadesEnZona(centro, radioDeEfecto);
		for (int i= 0; i< unidades.size(); i++){
			afectada = unidades.get(i);
			if (!soloAfectaEnemigas()){
				afectar(afectada);
				
			}else if (afectada.getJugador()!=jugador){
				afectar(unidades.get(i));
			}
		}
		
	}

	private boolean soloAfectaEnemigas() {
		
		return false;
	}

	public abstract void afectar(Unidad unidad);
	
	public int obtenerRadioEfecto()
	{
		return radioDeEfecto;
	}
}
