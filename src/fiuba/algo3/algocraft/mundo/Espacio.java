package fiuba.algo3.algocraft.mundo;


import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Espacio extends Entidad{
	
	public Espacio(Espacio gas) 
	{
		super(gas);
	}

	public Espacio(int dimension, JFrame ventana, Vector2D posicionEspacio) 
	{
		super(dimension, posicionEspacio, 0, 0, null, null, null, null, 0);		
	}

	@Override
	public void hacerMisAcciones() {
		// TODO Auto-generated method stub
		
	}

	public void dibujar(Graphics contexto) 
	{
		dibujarRectangulo(contexto,26,18,95,obtenerPosicion(),obtenerDimension(),obtenerDimension());				
	}

	

}
