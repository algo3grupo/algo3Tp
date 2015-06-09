package fiuba.algo3.algocraft.atributos;

import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class HechizoAreaDeEfecto extends Hechizo {
	private int radioDeEfecto;

	public HechizoAreaDeEfecto(int costo, int radioEfecto) {
		super(costo);
		radioDeEfecto = radioEfecto;
	}
	
	public void lanzarHechizoA(Vector2D posicion, Mundo mundo){
		//obtener unidades en el rango de donde se tiro
		// afectar unidades
		
	}
	
}
