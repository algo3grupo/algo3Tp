package fiuba.algo3.algocraft.mundo;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.vector2D.Vector2D;


public class Mineral extends Entidad {

	public Mineral(Mineral mineral) 
	{
		super(mineral);
	}

	public Mineral(int dimension, Vector2D posicionMineral) 
	{
		super(dimension, posicionMineral,null,0, null, null, null, null, 0);			
	}

	@Override
	public void hacerMisAcciones() {
		// TODO Auto-generated method stub
		
	}

}
