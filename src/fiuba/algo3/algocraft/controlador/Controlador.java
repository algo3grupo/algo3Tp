package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.unidadesProtoss.Zealot;
import fiuba.algo3.algocraft.vector2D.Vector2D;
import fiuba.algo3.algocraft.vista.Vista;

public class Controlador {
	
	private Vista vista;
	private Juego juego;
	
	public Controlador(Juego juego, Vista vista)
	{
		this.juego = juego;
		this.vista = vista;
	}
	
	public ActionListener obtenerListenerCreadorEstructuras(String nombre, Vector2D posicion) 
	{
		class ListenerCreadorEstructuras implements ActionListener
		{

			public void actionPerformed(ActionEvent arg0)
			{
				try{
					juego.construirEstructura(nombre, posicion);
					reproducirSonido("recursos/new toy.wav");
				} catch (NoPuedeRealizarEsaAccion e) {
					reproducirSonido("recursos/cant do that.wav");
				}
			}
			
		}	
		return new ListenerCreadorEstructuras();
	}
	
	public ActionListener obtenerListenerCreadorDeUnidades(String nombre, Estructura estructura) 
	{
		class ListenerCreadorUnidades implements ActionListener
		{

			public void actionPerformed(ActionEvent arg0)
			{
				juego.crearUnidad(nombre,estructura);
			}
			
		}	
		return new ListenerCreadorUnidades();
	}

	public MouseListener obtenerListenerMouse(JPopupMenu menuContextual) 
	{
		class ListenerMouse implements MouseListener
		{

			
			public void mouseClicked(MouseEvent e) 
			{

			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			public void mouseReleased(MouseEvent e) 
			{
				Vector2D posicion = new Vector2D(e.getPoint().getX(),e.getPoint().getY());
				Estructura estructura;
				Unidad unidad;
				ArrayList<Unidad> aux;				
				
				if(e.getButton() == e.BUTTON3)
					if(vista.noHaySeleccion())
					{
						if((estructura = juego.obtenerEstructura(posicion)) == null)
						{
							if(!juego.hayEstructurasEnemigas(posicion))
								vista.dibujarMenuCreadorEstructuras(posicion, juego.verEstructurasDeLaRaza());
						}
						else
							vista.dibujarMenuCreadorDeUnidades(posicion, juego.verUnidadesDeEstructura(estructura),estructura);
					}
					else
					{
						vista.dibujarMenuAccionesUnidad(posicion);
					}
						
				else if(e.getButton() == e.BUTTON1)
				{
					aux = juego.obtenerUnidad(posicion);
					if(aux.size() == 0)
						vista.deseleccionarUnidad();
					else
						vista.seleccionarUnidad(aux.get(0));
				}
			}

		}	
		return new ListenerMouse();
	}
		

	public ActionListener obtenerListenerPasarTurno() 
	{
		class ListenerPasarTurno implements ActionListener
		{

			public void actionPerformed(ActionEvent arg0)
			{
				vista.deseleccionarUnidad();
				juego.finalizarTurno();
			}
			
		}	
		return new ListenerPasarTurno();
	}

	public ActionListener obtenerListenerAccionesDeUnidad(String string, Unidad unidad, Vector2D posicion)
	{
		class ListenerCreadorEstructuras implements ActionListener
		{

			public void actionPerformed(ActionEvent arg0)
			{
				Entidad entidad;
				ArrayList<Unidad> aux;
				
				entidad = juego.obtenerEstructura(posicion);
				
				if(entidad == null)
				{
					aux = juego.obtenerUnidad(posicion);
					
					if(aux.size() == 0)
					{
						class Posicion extends Entidad
						{

							public Posicion(int dimension, Vector2D posicion,int vida, int rangoDeVision,Jugador jugador, String nombre,Costo costo, String requiere, int turnos) 
							{
								super(dimension, posicion, vida, rangoDeVision, jugador, nombre, costo,
										requiere, turnos);
								
							}

							
							public void hacerMisAcciones() 
							{
																
							}
							
						}
						entidad = new Posicion(0, posicion, 0, 0, null, string, null, string, 0);
					}
				}
								
				try {
					juego.indicarAccion(string,unidad,entidad);
					if (string == "Atacar"){
						reproducirSonido("recursos/pew pew.wav");
					}
				} catch (NoPuedeRealizarEsaAccion e) {
					reproducirSonido("recursos/cant do that.wav");
				}
			}
			
		}	
		return new ListenerCreadorEstructuras();
	}
	
	public ActionListener obtenerListenerMusica(JMenuItem play) 
	{
		class ListenerMusica implements ActionListener
		{
			Clip clip;
			int lastFrame;
			public void actionPerformed(ActionEvent arg0)
			{
                if (clip == null) {
                    	clip = abrirClip("recursos/algocraft theme.wav");
                		clip.start();
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                        play.setText("||");
                } else {

                    if (clip.isRunning()) {
                        lastFrame = clip.getFramePosition();
                        clip.stop();
                        play.setText(">");
                    } else {
                        if (lastFrame < clip.getFrameLength()) {
                            clip.setFramePosition(lastFrame);
                        } else {
                            clip.setFramePosition(0);
                        }
                        clip.start();
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                        play.setText("||");
                    }

                }
			}
			
		}	
		return new ListenerMusica();
	}
	
	public void reproducirSonido(String ruta){
			Clip clip = abrirClip(ruta);
	        clip.start();
	}
	
	public Clip abrirClip(String ruta){
		Clip clip = null;
		try{
			File file = new File(ruta);

	        AudioInputStream audioInputStream = AudioSystem.getAudioInputStream(file.getAbsoluteFile());
	        clip = AudioSystem.getClip();
	        clip.open(audioInputStream);
	    } catch(Exception ex) {
	        ex.printStackTrace();
	    }
		return clip;
	}
}
