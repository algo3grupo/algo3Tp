package fiuba.algo3.algocraft.vista;

import java.awt.Graphics;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public class VistaCeguera extends VistaEntidad 
{

	@Override
	public void dibujarApariencia(Graphics g, Entidad entidad) 
	{
		Dibujar.dibujarRectangulo(g,0,0,0, entidad.obtenerPosicion(),entidad.obtenerDimension(),entidad.obtenerDimension());
	}

}
