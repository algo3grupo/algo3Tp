package fiuba.algo3.algocraft.atributos;

import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Hechizo {
	private int costoEnergia;
	private int rangoAlcance;
	
	public Hechizo(int costo){
		costoEnergia = costo;
		this.rangoAlcance = 20;
	}

	public void lanzarHechizoA(Vector2D posicion, Mundo mundo){
		
	}
	
	public int obtenerCosto(){
		
		return costoEnergia;
		
	}
}
