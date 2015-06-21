package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.IOException;

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
					reproducirSonido("/sonidos/new toy.wav");
				} catch (NoPuedeRealizarEsaAccion e) {
					reproducirSonido("/sonidos/cant do that.wav");
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
					if((unidad = juego.obtenerUnidad(posicion)) == null)
						vista.deseleccionarUnidad();
					else
						vista.seleccionarUnidad(unidad);
				
				
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
				
				entidad = juego.obtenerEstructura(posicion);
				
				if(entidad == null)
				{
					entidad = juego.obtenerUnidad(posicion);
					if(entidad == null)
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
						reproducirSonido("/sonidos/pew pew.wav");
					}
				} catch (NoPuedeRealizarEsaAccion e) {
					reproducirSonido("/sonidos/cant do that.wav");
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
                    try {
                    	clip = AudioSystem.getClip();
                		clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream("/sonidos/algocraft theme.wav")));
                		clip.start();
                        clip.loop(Clip.LOOP_CONTINUOUSLY);
                        play.setText("||");
                    } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
                        e.printStackTrace();
                    }
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
		Clip clip = null;
        if (clip == null) {
            try {
            	clip = AudioSystem.getClip();
        		clip.open(AudioSystem.getAudioInputStream(getClass().getResourceAsStream(ruta)));
            } catch (LineUnavailableException | IOException | UnsupportedAudioFileException e) {
                e.printStackTrace();
            }
        }
        clip.start();
	}
}
