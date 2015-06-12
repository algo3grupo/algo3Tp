package fiuba.algo3.algocraft.atributos;

import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.unidadesProtoss.Zealot;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class HechizoSingular extends Hechizo {

	public HechizoSingular(int costo) {
		super(costo);
	}
	

	public void lanzarHechizoA(Vector2D posicion, Mundo mundo){
		//si hay una unidad en el lugar
		//la unidad q se hechiza es la q estaba en esa posicion
		//sino no tira el hechizo
				
	}
	
	public void hechizar(Unidad unidad){
		
	}
}
