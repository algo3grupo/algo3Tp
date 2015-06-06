package fiuba.algo3.algocraft.mundo;

import fiuba.algo3.algocraft.vector2D.Entidad;
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

}