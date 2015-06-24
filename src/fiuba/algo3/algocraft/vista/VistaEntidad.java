package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.Graphics;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class VistaEntidad {
	
	public void dibujar(Graphics g, Entidad entidad, Vista vista)
	{
		Vector2D posicion = new Vector2D(entidad.obtenerPosicion());
		
		dibujarApariencia(g,entidad);
		
		if(entidad == vista.obtenerSeleccion())
		{
			Dibujar.dibujarRectanguloVacio(g,posicion,entidad.obtenerDimension(),entidad.obtenerDimension());
		}
		
		if(entidad.estaHabilitada() && entidad.getJugador() != null)
		{
			Color color = entidad.getJugador().obtenerColor();
			
			Dibujar.dibujarRectangulo(g, color.getRed(), color.getGreen(), color.getBlue(), posicion , (int)(((double)entidad.getVida().vidaActual()/entidad.getVida().VidaMaxima()) * entidad.obtenerDimension()), 3);
		
			if(entidad.getVida().tieneEscudo())
			{
				color = new Color(128,128,128);
				
				Dibujar.dibujarRectangulo(g, color.getRed(), color.getGreen(), color.getBlue(), posicion.sumarA(new Vector2D(0,5)) , (int)(((double)entidad.getVida().obtenerEscudoActual()/entidad.getVida().obtenerEscudoMaximo())*entidad.obtenerDimension()), 3);
			}
		
		}
		
	}

	public abstract void dibujarApariencia(Graphics g, Entidad entidad);

}
