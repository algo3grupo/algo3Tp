package fiuba.algo3.algocraft.mundo;



import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.vector2D.Vector2D;


public class Gas extends Entidad{

	public Gas(Gas gas) 
	{
		super(gas);
	}

	public Gas(int dimension, Vector2D posicionGas) 
	{
		super(dimension, posicionGas,null,0, null, null, null, null, 0);			
	}

	@Override
	public void hacerMisAcciones() {
		// TODO Auto-generated method stub
		
	}

}
