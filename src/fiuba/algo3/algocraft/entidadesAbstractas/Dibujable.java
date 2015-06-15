package fiuba.algo3.algocraft.entidadesAbstractas;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Dibujable 
{
	
	private JFrame ventana;
	private int origenAreaClienteX, origenAreaClienteY;
	
	public Dibujable(JFrame ventana)
	{
		this.ventana = ventana;
		origenAreaClienteX = 8;
		origenAreaClienteY = 30;
	}
	
	public JFrame obtenerVentana()
	{
		return ventana;
	}
	
	public abstract void dibujar();
	
	public void dibujarRectangulo(int r, int g, int b, Vector2D limiteSuperior, int ancho, int alto)
	{
		Graphics contexto = ventana.getGraphics();
		
		contexto.setColor(new Color(r,g,b));
		
		contexto.fillRect((int)limiteSuperior.obtenerCoordenadaX()+origenAreaClienteX, (int)limiteSuperior.obtenerCoordenadaY()+origenAreaClienteY, ancho, alto);
		
	}
	
	public void dibujarImagen(String ruta, Vector2D posicion)
	{
		Graphics contexto = ventana.getGraphics();
		BufferedImage imagen = null;
		
		try
		{
			imagen = ImageIO.read(new File(ruta));
		}
		catch(IOException e)
		{
			
		}
		
		contexto.drawImage(imagen, (int)posicion.obtenerCoordenadaX()+origenAreaClienteX, (int)posicion.obtenerCoordenadaY()+origenAreaClienteY, null);
	}
	
	public void dibujarImagenEnMosaico(String ruta, Vector2D posicion, int ancho, int alto)
	{
		Graphics contexto = ventana.getGraphics();
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
				contexto.drawImage(imagen, (int)posicion.obtenerCoordenadaX()+origenAreaClienteX+i*imagen.getWidth(), (int)posicion.obtenerCoordenadaY()+origenAreaClienteY+a*imagen.getHeight(), null);
	}
	
	
	

}
