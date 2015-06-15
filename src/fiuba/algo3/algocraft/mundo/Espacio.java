package fiuba.algo3.algocraft.mundo;


import javax.swing.JFrame;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Espacio extends Entidad{
	
	public Espacio(Espacio gas) 
	{
		super(gas);
	}

	public Espacio(JFrame ventana, Vector2D posicionEspacio, int dimension) 
	{
		super(ventana, posicionEspacio, 0, 0, null, null, null, null, 0);		
	}

	@Override
	public void hacerMisAcciones() {
		// TODO Auto-generated method stub
		
	}

	public void dibujar() 
	{
		dibujarRectangulo(26,18,95,obtenerPosicion(),obtenerDimension(),obtenerDimension());				
	}

	

}
