package fiuba.algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Lienzo extends JPanel {
	
	private Vista vista;

	public Lienzo(Vista vista, int resolucion)
	{
		this.vista = vista;
		this.setPreferredSize(new Dimension(resolucion,resolucion));
	}
	
	public void paintComponent(Graphics g)
	{
		vista.dibujarFrontBuffer(g);
	}
}