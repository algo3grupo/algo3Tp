package fiuba.algo3.algocraft.graficos;

import java.awt.Canvas;
import java.awt.Graphics;

import javax.swing.JComponent;
import javax.swing.JPanel;

import fiuba.algo3.algocraft.Juego;

public class Lienzo extends JComponent {
	
	private Juego juego;
	
	public Lienzo(Juego juego)
	{
		this.juego = juego;
	}
	
	public void paint(Graphics g)
	{
		juego.actualizarVista(g);
	}

}
