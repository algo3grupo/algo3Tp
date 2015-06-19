package fiuba.algo3.algocraft.vista;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.estructurasProtoss.PuertoEstelar;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Terran;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Vista implements Observer {
	
	private Juego juego;
	private JFrame ventana;
	private Lienzo lienzo;
	private HashMap<String,VistaEntidad> Vistas; 
	
	
	public Vista(Juego juego)
	{
		this.juego = juego;
		ventana = crearVentana(juego);
		
		this.juego.addObserver(this);
		
		Vistas = new HashMap<String,VistaEntidad>();
		
		Vistas.put("Acceso", new VistaAcceso());
		Vistas.put("ArchivosTemplarios", new VistaArchivosTemplarios());
		Vistas.put("Asimilador", new VistaAsimilador());
		Vistas.put("Barraca", new VistaBarraca());
		Vistas.put("CentroDeMineral", new VistaCentroDeMineral());
		Vistas.put("DepositoSuministro", new VistaDepositoSuministro());
		Vistas.put("Fabrica", new VistaFabrica());
		Vistas.put("NexoMineral", new VistaNexoMineral());
		Vistas.put("Pilon", new VistaPilon());
		Vistas.put("PuertoEstelar", new VistaPuertoEstelar());
		Vistas.put("PuertiEstelarT", new VistaPuertoEstelarT());
		Vistas.put("Refineria", new VistaRefineria());		
		Vistas.put("Gas", new VistaGas());	
		Vistas.put("Mineral", new VistaMineral());	
		
	}
	
	private void dibujar(Graphics g, Entidad e)
	{
		Vistas.get(e.getClass().getSimpleName()).dibujar(g,e);
	}
	
	private void dibujar(Graphics g, Mundo m)
	{
		Dibujable.dibujarImagenEnMosaico(g,"recursos/terreno.jpg",new Vector2D(0,0),m.obtenerResolucion(),m.obtenerResolucion());
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
		
		dibujar(g,juego.obtenerMundo());
		
		Iterator i;
		
		i = this.juego.obtenerMundo().obtenerMinerales().iterator();
		
		while(i.hasNext())
			dibujar(g,(Entidad)i.next());
		
		
		i = this.juego.obtenerMundo().obtenerGas().iterator();
		
		while(i.hasNext())
			dibujar(g,(Entidad)i.next());
		
		
		i = this.juego.obtenerEstructurasDeJugador1().iterator();
		
		while(i.hasNext())
			dibujar(g,(Entidad)i.next());
		
		i = this.juego.obtenerEstructurasDeJugador2().iterator();
		
		while(i.hasNext())
			dibujar(g,(Entidad)i.next());
		
		i = this.juego.obtenerUnidadesDeJugador1().iterator();
		
		while(i.hasNext())
			dibujar(g,(Entidad)i.next());
		
		i = this.juego.obtenerUnidadesDeJugador2().iterator();
		
		while(i.hasNext())
			dibujar(g,(Entidad)i.next());		
				
	}

}
