package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;

import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Dibujar 
{
	
	private static HashMap<String,BufferedImage> cacheImagenes = new HashMap<String,BufferedImage>();
	
	public Dibujar()
	{
		
	}
	
	public static void dibujarRectangulo(Graphics contexto, int r, int g, int b, Vector2D limiteSuperior, int ancho, int alto)
	{
		
		contexto.setColor(new Color(r,g,b));
		
		contexto.fillRect((int)limiteSuperior.obtenerCoordenadaX(), (int)limiteSuperior.obtenerCoordenadaY(), ancho, alto);
		
	}
	
	public static void dibujarRectanguloVacio(Graphics contexto, Vector2D limiteSuperior, int ancho, int alto)
	{
		
		contexto.setColor(new Color(90,90,90));
		
		contexto.drawRect((int)limiteSuperior.obtenerCoordenadaX(), (int)limiteSuperior.obtenerCoordenadaY(), ancho, alto);
		
	}
	
	public static void dibujarImagen(Graphics contexto, String ruta, Vector2D posicion, int ancho, int alto)
	{
		BufferedImage imagen = cacheImagenes.get(ruta);		
		
		if(imagen == null)
		{
			try
			{
				imagen = ImageIO.read(new File(ruta));
				
			}
			catch(IOException e)
			{
			
			}
			
			cacheImagenes.put(ruta,imagen);
		}
		
		contexto.drawImage(imagen, (int)posicion.obtenerCoordenadaX(), (int)posicion.obtenerCoordenadaY(), ancho, alto, null);
	}
	
	static void dibujarImagenEnMosaico(Graphics contexto,String ruta, Vector2D posicion, int ancho, int alto, int dimension)
	{
		BufferedImage imagen = null;
		
		try
		{
			imagen = ImageIO.read(new File(ruta));
		}
		catch(IOException e)
		{
			
		}
		
		for(int i=0;i<(double)ancho/dimension;i++)
			for(int a=0;a<(double)alto/dimension;a++)
				contexto.drawImage(imagen, (int)posicion.obtenerCoordenadaX()+i*dimension, (int)posicion.obtenerCoordenadaY()+a*dimension, dimension ,dimension, null);
	}
	
	public static void escribirTexto(Graphics contexto, Vector2D posicion, String texto) 
	{
		contexto.setColor(new Color(255,255,255));
		contexto.drawString(texto, (int)posicion.obtenerCoordenadaX(), (int)posicion.obtenerCoordenadaY());			
	}
	
	public static void dibujarCirculo(Graphics contexto, Vector2D centro, int radio)
	{
		contexto.setColor(new Color(90,90,90,60));
		
		contexto.fillArc((int)(centro.obtenerCoordenadaX()-radio), (int)(centro.obtenerCoordenadaY()-radio), 2*radio, 2*radio, 0, 360);
		
	}
	

}
