package fiuba.algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public class Vista implements Observer {
	
	private Juego juego;
	private JFrame ventana;
	private Lienzo lienzo;
	
	
	public Vista(Juego juego)
	{
		this.juego = juego;
		ventana = crearVentana(juego);
		
		this.juego.addObserver(this);
	}
	
	private JFrame crearVentana(Juego juego) 
	{
		JFrame ventana = new JFrame("Algocraft"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800,800);
		ventana.setVisible(true);
		
		lienzo = new Lienzo(juego,juego.obtenerMundo().obtenerResolucion());
		
		JScrollPane camara = new JScrollPane(lienzo);
		camara.setPreferredSize(new Dimension(400,400));

		ventana.add(camara);		
		
		
		
		return ventana;
	}
	
	public void update(Observable arg0, Object arg1) 
	{
		
		Entidad e;
		Graphics g = lienzo.getGraphics();
		
		this.juego.obtenerMundo().dibujar(g);
		 
		Iterator i;
		
		i = this.juego.obtenerEstructurasDeJugador1().iterator();
		
		while(i.hasNext())
			((Entidad)i.next()).dibujar(g);
		
		i = this.juego.obtenerEstructurasDeJugador2().iterator();
		
		while(i.hasNext())
			((Entidad)i.next()).dibujar(g);
		
		i = this.juego.obtenerUnidadesDeJugador1().iterator();
		
		while(i.hasNext())
			((Entidad)i.next()).dibujar(g);
		
		i = this.juego.obtenerUnidadesDeJugador2().iterator();
		
		while(i.hasNext())
			((Entidad)i.next()).dibujar(g);
		
		
				
	}

}
