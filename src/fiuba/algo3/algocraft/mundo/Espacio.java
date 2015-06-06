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
		super(posicionEspacio,dimension,dimension);			
	}	

}
