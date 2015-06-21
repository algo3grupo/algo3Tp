package fiuba.algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import fiuba.algo3.algocraft.Juego;

public class Lienzo extends JPanel {
	
	private Juego juego;

	public Lienzo(Juego juego, int resolucion)
	{
		this.juego = juego;
		this.setPreferredSize(new Dimension(resolucion,resolucion));
	}
	
	public void paintComponent(Graphics g)
	{
	
		juego.actualizarObservadores();
	}
}