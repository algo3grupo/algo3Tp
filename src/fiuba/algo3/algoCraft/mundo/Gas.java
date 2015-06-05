package fiuba.algo3.algoCraft.mundo;

import fiuba.algo3.algoCraft.vector2D.Entidad;
import fiuba.algo3.algoCraft.vector2D.Vector2D;


public class Gas extends Entidad{

	public Gas(Gas gas) 
	{
		super(gas);
	}

	public Gas(Vector2D posicionGas, int dimension) 
	{
		super(posicionGas,dimension,dimension);			
	}	

}
