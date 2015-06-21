package fiuba.algo3.algocraft.vista;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.controlador.ControladorMenu;

public class VistaMenu 
{	
	private ControladorMenu controlador;
	private JFrame ventana;
	private JComboBox claseJugador1, claseJugador2;
	private JTextField nombreJugador1, nombreJugador2;
	
	public VistaMenu()
	{
		controlador = new ControladorMenu(this);
		ventana = new JFrame("Algocraft");
		mostrarMenu();
	}
	
	public void mostrarMenu()
	{	
		destruirVentana();
		ventana = new JFrame("Algocraft");
		
		JPanel panelJugador1;
		JLabel labelClaseJugador1, labelNombreJugador1;
		JButton aceptar;
		
		panelJugador1 = new JPanel();
		nombreJugador1 = new JTextField();		
		labelClaseJugador1 = new JLabel();
		labelNombreJugador1 = new JLabel();
		
		String[] clases = {"Protoss","Terran"};
		
		claseJugador1 = new JComboBox<String>(clases);
		claseJugador1.setSelectedIndex(0);
		labelClaseJugador1.setText("Raza del jugador 1: ");
		labelNombreJugador1.setText("Nombre del jugador1: ");
		nombreJugador1.setColumns(30);
		nombreJugador1.setText("Jugador 1");
		
		
		panelJugador1.add(labelClaseJugador1);
		panelJugador1.add(claseJugador1);
		panelJugador1.add(labelNombreJugador1);
		panelJugador1.add(nombreJugador1);
		
		
		
		JPanel panelJugador2;
		JLabel labelClaseJugador2, labelNombreJugador2;
		
		panelJugador2 = new JPanel();
		nombreJugador2 = new JTextField();		
		labelClaseJugador2 = new JLabel();
		labelNombreJugador2 = new JLabel();
		
		claseJugador2 = new JComboBox<String>(clases);
		claseJugador2.setSelectedIndex(1);
		labelClaseJugador2.setText("Raza del jugador 2: ");
		labelNombreJugador2.setText("Nombre del jugador2: ");
		nombreJugador2.setColumns(30);
		nombreJugador2.setText("Jugador 2");
		
		
		panelJugador2.add(labelClaseJugador2);
		panelJugador2.add(claseJugador2);
		panelJugador2.add(labelNombreJugador2);
		panelJugador2.add(nombreJugador2);
		
		
		aceptar = new JButton("Comenzar");
		aceptar.addActionListener(controlador.obtenerListenerBotonComenzar());
		
		
		ventana.add(panelJugador1, BorderLayout.PAGE_START);
		ventana.add(panelJugador2);
		ventana.add(aceptar, BorderLayout.PAGE_END);
	

		ventana.pack();
		ventana.setVisible(true);
		
	}
	
	public void destruirVentana()
	{
		ventana.dispose();
	}
	
	public String obtenerNombreJugador1()
	{
		return nombreJugador1.getText();
	}
	
	public String obtenerNombreJugador2()
	{
		return nombreJugador2.getText();
	}
	
	public String obtenerClaseJugador1()
	{
		return (String)claseJugador1.getSelectedItem();
	}
	
	public String obtenerClaseJugador2()
	{
		return (String)claseJugador2.getSelectedItem();
	}

}
