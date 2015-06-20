package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.Graphics;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class VistaEntidad extends Dibujable {
	
	public void dibujar(Graphics g, Entidad entidad)
	{
		dibujarApariencia(g,entidad);
		
		if(entidad.getJugador() != null)
		{
			Color color = entidad.getJugador().obtenerColor();
			Vector2D posicion = new Vector2D(entidad.obtenerPosicion());
			
			dibujarRectangulo(g, color.getRed(), color.getGreen(), color.getBlue(), posicion , entidad.verVida()/entidad.obtenerVidaMaxima()*entidad.obtenerDimension(), 3);
		}
	}
	
	public abstract void dibujarApariencia(Graphics g, Entidad entidad);

}
