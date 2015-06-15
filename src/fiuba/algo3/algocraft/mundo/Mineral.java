package fiuba.algo3.algocraft.mundo;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.vector2D.Vector2D;


public class Mineral extends Entidad {

	public Mineral(Mineral mineral) 
	{
		super(mineral);
	}

	public Mineral(JFrame ventana, Vector2D posicionMineral, int dimension) 
	{
		super(ventana, posicionMineral,0,0, null, null, null, null, 0);			
	}

	@Override
	public void hacerMisAcciones() {
		// TODO Auto-generated method stub
		
	}

	public void dibujar() 
	{
		dibujarImagen("cristal.png",obtenerPosicion());		
	}

}
