package fiuba.algo3.algocraft.mundo;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.vector2D.Vector2D;


public class Gas extends Entidad{

	public Gas(Gas gas) 
	{
		super(gas);
	}

	public Gas(JFrame ventana, Vector2D posicionGas, int dimension) 
	{
		super(ventana, posicionGas,0,0, null, null, null, null, 0);			
	}

	@Override
	public void hacerMisAcciones() {
		// TODO Auto-generated method stub
		
	}

	
	public void dibujar() 
	{
		dibujarImagen("gas.png",obtenerPosicion());		
	}	

}
