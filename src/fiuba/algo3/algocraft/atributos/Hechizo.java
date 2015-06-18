package fiuba.algo3.algocraft.atributos;

import fiuba.algo3.algocraft.excepciones.NoEsPosibleLanzarElHechizoAlli;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Hechizo {
	private int costoEnergia;
	
	public Hechizo(int costo){
		costoEnergia = costo;
	}

	public abstract void lanzarHechizoA(Jugador jugador,Vector2D posicion, Mundo mundo) throws NoEsPosibleLanzarElHechizoAlli;
	
	public int obtenerCosto(){
		
		return costoEnergia;
		
	}
}
