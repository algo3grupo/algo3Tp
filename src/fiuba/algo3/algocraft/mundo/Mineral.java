package fiuba.algo3.algocraft.mundo;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.vector2D.Vector2D;


public class Mineral extends Entidad {

	public Mineral(Mineral mineral) 
	{
		super(mineral);
	}

	public Mineral(Vector2D posicionMineral, int dimension) 
	{
		super(posicionMineral,dimension,dimension);			
	}

	@Override
	public void hacerMisAcciones() {
		// TODO Auto-generated method stub
		
	}

}
