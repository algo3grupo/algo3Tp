package fiuba.algo3.algocraft.controlador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.vista.Vista;
import fiuba.algo3.algocraft.vista.VistaMenu;

public class ControladorMenu
{
	private VistaMenu vista;
	
	public ControladorMenu(VistaMenu vista) 
	{
		this.vista = vista;
	}	
	

	public ActionListener obtenerListenerBotonComenzar()
	{
		class ListenerComenzarPartida implements ActionListener
		{

			public void actionPerformed(ActionEvent arg0)
			{
				if(vista.obtenerNombreJugador1() == vista.obtenerNombreJugador2() || vista.obtenerNombreJugador1().length() < 5 && vista.obtenerNombreJugador2().length() < 5)
					vista.mostrarMenu();
				else
				{
					
					Juego juego = new Juego(vista.obtenerClaseJugador1(), vista.obtenerNombreJugador1(), new Color(255,0,0), vista.obtenerClaseJugador2(), vista.obtenerNombreJugador2(), new Color(0,255,0));
					vista.destruirVentana();
					
					Vista vistaJuego = new Vista(juego);
					juego.actualizarObservadores();
					vistaJuego.dibujarFrontBuffer();
				
				}
					
			}
			
		}	
		return new ListenerComenzarPartida();
	}
	

}
