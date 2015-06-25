package fiuba.algo3.algocraft.entidadesAbstractas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Dibujable 
{
	
	public Dibujable()
	{
		
	}
	
	public abstract void dibujar(Graphics g);
	
	public void dibujarRectangulo(Graphics contexto, int r, int g, int b, Vector2D limiteSuperior, int ancho, int alto)
	{
		
		contexto.setColor(new Color(r,g,b));
		
		contexto.fillRect((int)limiteSuperior.obtenerCoordenadaX(), (int)limiteSuperior.obtenerCoordenadaY(), ancho, alto);
		
	}
	
	public void dibujarImagen(Graphics contexto, String ruta, Vector2D posicion, int ancho, int alto)
	{
		BufferedImage imagen = null;
		
		try
		{
			imagen = ImageIO.read(new File(ruta));
		}
		catch(IOException e)
		{
			
		}
		
		contexto.drawImage(imagen, (int)posicion.obtenerCoordenadaX(), (int)posicion.obtenerCoordenadaY(), ancho, alto, null);
	}
	
	public void dibujarImagenEnMosaico(Graphics contexto,String ruta, Vector2D posicion, int ancho, int alto)
	{
		BufferedImage imagen = null;
		
		try
		{
			imagen = ImageIO.read(new File(ruta));
		}
		catch(IOException e)
		{
			
		}
		
		for(int i=0;i<(double)ancho/imagen.getWidth();i++)
			for(int a=0;a<(double)alto/imagen.getHeight();a++)
				contexto.drawImage(imagen, (int)posicion.obtenerCoordenadaX()+i*imagen.getWidth(), (int)posicion.obtenerCoordenadaY()+a*imagen.getHeight(), null);
	}
	
	
	

}
