package fiuba.algo3.algocraft.atributos;

import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.unidadesProtoss.Zealot;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class HechizoSingular extends Hechizo {

	public HechizoSingular(int costo) {
		super(costo);
	}
	

	public void lanzarHechizoA(Unidad unidad){
		hechizar(unidad);
				
	}
	
	public abstract void hechizar(Unidad unidad);
	
}
