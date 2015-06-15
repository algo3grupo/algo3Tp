package fiuba.algo3.algocraft;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Protoss;
import fiuba.algo3.algocraft.jugador.Terran;
import fiuba.algo3.algocraft.mundo.Mineral;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Juego{
	
	private Jugador jugador1, jugador2, turno;
	private Mundo mundo;
	private JFrame ventana;
	
	public Juego(String razaJugador1, String nombreJugador1, String colorJugador1, String razaJugador2, String nombreJugador2, String colorJugador2)
	{
		ventana = crearVentana();
		
		mundo = new Mundo(ventana,ventana.getSize().height,50,this);
		mundo.generar();
		
		if(razaJugador1=="Protoss")
			jugador1 = new Protoss(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador1(),ventana,nombreJugador1,colorJugador1);
		else
			jugador1 = new Terran(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador1(),ventana,nombreJugador1,colorJugador1);
		
		if(razaJugador2=="Protoss")
			jugador2 = new Protoss(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador2(),ventana,nombreJugador2,colorJugador2);
		else
			jugador2 = new Terran(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador2(),ventana,nombreJugador2,colorJugador2);
		
		turno = jugador1;
		
		
		
		
		
	}

	private JFrame crearVentana() 
	{
		JFrame ventana = new JFrame("Algocraft");
		
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		ventana.setSize(1000,1000);
		
		ventana.setVisible(true);
		
		return ventana;
	}

	public ArrayList<Unidad> obtenerUnidadesDeJugador1() {
		return jugador1.ObtenerUnidades();
	}

	public ArrayList<Unidad> obtenerUnidadesDeJugador2() {
		return jugador2.ObtenerUnidades();
	}
	
	public ArrayList<Estructura> obtenerEstructurasDeJugador1() {
		return jugador1.obtenerEstructuras();
	}

	public ArrayList<Estructura> obtenerEstructurasDeJugador2() {
		return jugador2.obtenerEstructuras();
	}
	
	public void finalizarTurno()
	{
		if(turno == jugador1)
			turno = jugador2;
		else
			turno = jugador1;
		
		jugador1.terminarTurno();
		jugador2.terminarTurno();
	}
	
	public ArrayList<Unidad> obtenerUnidadesContrarias()
	{
		if(turno == jugador1)
			return obtenerUnidadesDeJugador2();
		else
			return obtenerUnidadesDeJugador1();
	}

	public Mundo obtenerMundo() {
		return mundo;
	}

	public void construirEstructura(String string, Vector2D vector2d) {
		// TODO Auto-generated method stub
		
	}
	
	public void actualizarVista()
	{
		mundo.dibujar();
		jugador1.actualizarVista();
		jugador2.actualizarVista();
	}

}
