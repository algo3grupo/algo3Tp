package fiuba.algo3.algocraft.graficos;

import java.awt.Canvas;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;

import javax.swing.JPanel;

import fiuba.algo3.algocraft.Juego;

public class Lienzo extends JPanel {
	
	private Juego juego;
	private BufferStrategy bs;
	
	public Lienzo(Juego juego, int resolucion)
	{
		this.juego = juego;
		this.setPreferredSize(new Dimension(resolucion,resolucion));
	}
	
	public void paintComponent(Graphics g)
	{
		juego.actualizarVista(g);
	}

}
