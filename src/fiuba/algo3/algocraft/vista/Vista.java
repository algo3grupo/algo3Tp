package fiuba.algo3.algocraft.vista;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JScrollPane;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.controlador.Controlador;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.mundo.Ceguera;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Vista implements Observer {
	
	private Juego juego;
	private JFrame ventana;
	private Lienzo lienzo;
	private HashMap<String,VistaEntidad> Vistas; 
	private Controlador controlador;
	private JPopupMenu menuContextual;
	private JLabel datosJugador;
	private Unidad seleccion;
	private BufferedImage backBuffer;
	
	public Vista(Juego juego)
	{
		
		backBuffer = new BufferedImage(juego.obtenerMundo().obtenerResolucion(),juego.obtenerMundo().obtenerResolucion(),BufferedImage.TYPE_INT_ARGB);
		menuContextual = new JPopupMenu();
		seleccion = null;
		this.juego = juego;
		this.controlador = new Controlador(juego, this);
		
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
		Vistas.put("PuertoEstelarT", new VistaPuertoEstelarT());
		Vistas.put("Refineria", new VistaRefineria());		
		Vistas.put("Gas", new VistaGas());	
		Vistas.put("Mineral", new VistaMineral());	
		
		Vistas.put("AltoTemplario", new VistaAltoTemplario());
		Vistas.put("Dragon", new VistaDragon());
		Vistas.put("NaveTransporteProtoss", new VistaNaveTransporteProtoss());
		Vistas.put("Scout", new VistaScout());
		Vistas.put("Zealot", new VistaZealot());
		Vistas.put("Espectro", new VistaEspectro());
		Vistas.put("Golliat", new VistaGolliat());
		Vistas.put("Marine", new VistaMarine());
		Vistas.put("NaveCiencia", new VistaNaveCiencia());
		Vistas.put("NaveTransporteTerran", new VistaNaveTransporteTerran());
		Vistas.put("Ceguera", new VistaCeguera());		
		
	}
	
	private void dibujar(Graphics g, Entidad e)
	{
		Vistas.get(e.getClass().getSimpleName()).dibujar(g,e);
	}
	
	private void dibujar(Graphics g, Mundo m)
	{
		Dibujable.dibujarImagenEnMosaico(g,"recursos/terreno.jpg",new Vector2D(0,0),m.obtenerResolucion(),m.obtenerResolucion(),m.obtenerDivisionDeGrilla());
	}
	
	private void dibujar(Graphics g, ArrayList<Ceguera> c)
	{
		for(int i=0; i<c.size();i++)
			Vistas.get("Ceguera").dibujar(g, c.get(i));
	}
	
	private JFrame crearVentana(Juego juego) 
	{
		JFrame ventana = new JFrame("Algocraft"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800,800);
		ventana.setVisible(true);
		
		JMenuBar menu = new JMenuBar();
		JMenuItem pasarTurno = new JMenuItem("Pasar Turno");
		JMenuItem playMusica = new JMenuItem(">");
		datosJugador = new JLabel();
		menu.add(pasarTurno);
		menu.add(playMusica);
		menu.add(datosJugador);
		
		pasarTurno.addActionListener(controlador.obtenerListenerPasarTurno());
		playMusica.addActionListener(controlador.obtenerListenerMusica(playMusica));
		
		ventana.setJMenuBar(menu);
		
		lienzo = new Lienzo(this,juego.obtenerMundo().obtenerResolucion());
		lienzo.addMouseListener(controlador.obtenerListenerMouse(menuContextual));
		
		
		JScrollPane camara = new JScrollPane(lienzo);
		camara.setPreferredSize(new Dimension(400,400));

		ventana.add(camara);				
		
		return ventana;
	}
	
	public void dibujarFrontBuffer()
	{
		dibujarFrontBuffer(lienzo.getGraphics());
	}
	
	public void dibujarFrontBuffer(Graphics g)
	{				
		
		g.drawImage(backBuffer.getSubimage(-lienzo.getX(), -lienzo.getY(), ventana.getWidth(), ventana.getHeight()),-lienzo.getX(),-lienzo.getY(),null);
		
		if(menuContextual != null)
			menuContextual.updateUI();
		
	}
	
	public void update(Observable arg0, Object objeto) 
	{
		
		Graphics g = backBuffer.getGraphics();
		
		if(objeto == null)
		{
		
			datosJugador.setText(juego.obtenerNombreJugador()+" Raza: "+juego.obtenerRaza()+" Gas: "+juego.obtenerGasJugadorActual()+" Mineral "+juego.obtenerMineralJugadorActual()+" Poblacion: "+juego.obtenerPoblacionActualJugador()+"/"+juego.obtenerPoblacionlimiteJugador());
			datosJugador.setForeground(juego.obtenerColorJugador());
		
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
		
			dibujar(g,juego.obtenerCegueras());
		
		}
		else
		{
			Entidad e = (Entidad)objeto;
			ArrayList<Entidad> entidades;
			Vector2D posicion;
			
			for(int i=0;i<5;i++)
				for(int a=0;a<5;a++)
				{
					
					posicion = new Vector2D((e.obtenerPosicion().obtenerCoordenadaX()-e.obtenerDimension()*2)+(i*e.obtenerDimension()),(e.obtenerPosicion().obtenerCoordenadaY()-e.obtenerDimension()*2)+(a*e.obtenerDimension()));
					
					entidades = juego.entidadesEnRectangulo(posicion,e.obtenerDimension());
					
					Dibujable.dibujarImagen(g,"recursos/terreno.jpg", juego.obtenerMundo().pixelAGrilla(posicion), e.obtenerDimension(), e.obtenerDimension());			
										
					for(int b=0;b<entidades.size();b++)
						dibujar(g,entidades.get(b));	
					
					dibujar(g,e);
				}
			
				
		}
		
		dibujarFrontBuffer();
	}
	
	public void dibujarMenuCreadorEstructuras(Vector2D posicion, ArrayList<String> estructuras)
	{
		menuContextual.removeAll();
		
		JLabel rotulo = new JLabel("Crear estructura aca");
		rotulo.setBackground(new Color(255,0,0));
		rotulo.setOpaque(true);
		
		menuContextual.add(rotulo);
		
		for(int i=0; i<estructuras.size();i++)
		{
			JMenuItem item = new JMenuItem(estructuras.get(i));
			item.addActionListener(controlador.obtenerListenerCreadorEstructuras(estructuras.get(i),posicion));
			menuContextual.add(item);
		}
		
		menuContextual.show(lienzo, (int)posicion.obtenerCoordenadaX(), (int)posicion.obtenerCoordenadaY());	
	}

	public boolean noHaySeleccion() 
	{
		if(seleccion == null)
			return true;
		return false;
	}

	public void dibujarMenuCreadorDeUnidades(Vector2D posicion,	ArrayList<String> unidades, Estructura estructura) 
	{
		menuContextual.removeAll();
		
		JLabel rotulo = new JLabel("Crear unidad");
		rotulo.setBackground(new Color(255,0,0));
		rotulo.setOpaque(true);
		
		menuContextual.add(rotulo);
		
		for(int i=0; i<unidades.size();i++)
		{
			JMenuItem item = new JMenuItem(unidades.get(i));
			item.addActionListener(controlador.obtenerListenerCreadorDeUnidades(unidades.get(i),estructura));
			menuContextual.add(item);
		}
		
		menuContextual.show(lienzo, (int)posicion.obtenerCoordenadaX(), (int)posicion.obtenerCoordenadaY());	
		menuContextual.setVisible(true);		
	}

	public void seleccionarUnidad(Unidad unidad) 
	{
		seleccion = unidad;		
	}

	public void deseleccionarUnidad() 
	{
		seleccion = null;		
	}

	public void dibujarMenuAccionesUnidad(Vector2D posicion) 
	{
		menuContextual.removeAll();
		
		JLabel rotulo = new JLabel("Accion");
		rotulo.setBackground(new Color(255,0,0));
		rotulo.setOpaque(true);
		
		ArrayList<String> acciones = seleccion.mostrarAcciones();
		
		menuContextual.add(rotulo);
		
		for(int i=0; i<acciones.size();i++)
		{
			JMenuItem item = new JMenuItem(acciones.get(i));
			item.addActionListener(controlador.obtenerListenerAccionesDeUnidad(acciones.get(i),seleccion,posicion));
			menuContextual.add(item);
		}
		
		menuContextual.show(lienzo, (int)posicion.obtenerCoordenadaX(), (int)posicion.obtenerCoordenadaY());	
		menuContextual.setVisible(true);		
	}

}
