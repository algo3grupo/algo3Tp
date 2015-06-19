package fiuba.algo3.algocraft;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vista.Vista;

public  class Aplicacion {
	
	public static void main(String [] args)
	{
		
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
		Vista vista  = new Vista(juego);
		
		juego.actualizarObservadores();

	}

}
