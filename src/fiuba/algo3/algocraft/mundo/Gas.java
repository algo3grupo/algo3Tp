package fiuba.algo3.algocraft.mundo;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.vector2D.Vector2D;


public class Gas extends Entidad{

	public Gas(Gas gas) 
	{
		super(gas);
	}

	public Gas(Vector2D posicionGas, int dimension) 
	{
		super(posicionGas,dimension,dimension);			
	}

	@Override
	public void hacerMisAcciones() {
		// TODO Auto-generated method stub
		
	}	

}
