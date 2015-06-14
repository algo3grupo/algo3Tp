package fiuba.algo3.algocraft.mundo;


import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Espacio extends Entidad{
	
	public Espacio(Espacio gas) 
	{
		super(gas);
	}

	public Espacio(Vector2D posicionEspacio, int dimension) 
	{
		super(posicionEspacio, 0, 0, null, null, null, null, 0);		
	}

	@Override
	public void hacerMisAcciones() {
		// TODO Auto-generated method stub
		
	}

	

}
