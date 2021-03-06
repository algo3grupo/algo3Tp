package fiuba.algo3.algocraft.controlador;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.FinDeLaPartida;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHaySuministroEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEntidad;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
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
	
	public ActionListener obtenerListenerCreadorEstructuras(final String nombre, final Vector2D posicion) 
	{
		class ListenerCreadorEstructuras implements ActionListener
		{

			public void actionPerformed(ActionEvent arg0)
			{
				try{
					juego.construirEstructura(nombre, posicion);
					reproducirSonido("recursos/new toy.wav");
				} catch (NoEsDeSuRazaLaEstructuraException
						| NoTieneLaEstructuraCreadaException
						| NoHayMineralEnElLugarACrear | NoHayGasEnElLugarACrear
						| ErrorAlHacerCopia | NoHaySuministroEnElLugarACrear e) {
					reproducirSonido("recursos/cant do that.wav");
					vista.mostrarCartel("Advertencia", "No se puede contruir la estructura ahi!.");
				}
				catch(NoTieneRecursosSuficientesException e)
				{
					reproducirSonido("recursos/cant do that.wav");
					vista.mostrarCartel("Advertencia", "No hay recursos suficientes para construir.");		
				}
				
			}
			
		}	
		return new ListenerCreadorEstructuras();
	}
	
	public ActionListener obtenerListenerCreadorDeUnidades(final String nombre, final Estructura estructura) 
	{
		class ListenerCreadorUnidades implements ActionListener
		{

			public void actionPerformed(ActionEvent arg0)
			{
				try{
					juego.crearUnidad(nombre,estructura);
				} catch (NoEsDeSuRazaLaUnidadException
						| NoTieneLaEstructuraCreadaException
						| NoSeEncontroLaEntidad
						| ErrorAlHacerCopia e) {
					reproducirSonido("recursos/cant do that.wav");
					vista.mostrarCartel("Advertencia", "No se puede crear la unidad solicitada.");
				}
				catch(NoTieneRecursosSuficientesException e)
				{
					reproducirSonido("recursos/cant do that.wav");
					vista.mostrarCartel("Advertencia", "No hay recursos suficientes para construir.");	
				}
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
				try
				{
					juego.finalizarTurno();
				}
				catch(FinDeLaPartida e)
				{
					vista.mostrarCartelFinJuego("El jugador "+e.obtenerGanador()+" ha ganador la partida");
				}
				
			}
			
		}	
		return new ListenerPasarTurno();
	}

	public ActionListener obtenerListenerAccionesDeUnidad(final String string, final Unidad unidad, final Vector2D posicion)
	{
		class ListenerCreadorEstructuras implements ActionListener
		{

			public void actionPerformed(ActionEvent arg0)
			{
				Entidad entidad;
				Unidad aux;
				ArrayList<Unidad> unidades;
				
				entidad = juego.obtenerEstructuraContraria(posicion);
				
				if(entidad == null)
				{
					aux = juego.obtenerUnidadContraria(posicion);
					
					if(aux == null)
					{
						
						unidades = juego.obtenerUnidad(posicion);
						
						if(unidades.size() == 0)
						{
												
							class Posicion extends Entidad
							{

								public Posicion(int dimension, Vector2D posicion,Vida vida, int rangoDeVision,Jugador jugador, String nombre,Costo costo, String requiere, int turnos) 
								{
									super(dimension, posicion, vida, rangoDeVision, jugador, nombre, costo,	requiere, turnos);
								
								}

							
								public void hacerMisAcciones() 
								{
																
								}
							
							}
							
							entidad = new Posicion(0, posicion, null, 0, null, string, null, string, 0);
							
						}
						else
							entidad = unidades.get(0);
					}
					else 
					{
						entidad = aux;
					}
				}
								
				try {
					juego.indicarAccion(string,unidad,entidad);
					reproducirSonidoDeAtaque(string);
					
				} catch (NoPuedeRealizarEsaAccion e) {
					reproducirSonido("recursos/cant do that.wav");
					vista.mostrarCartel("Advertencia", "La unidad no puede realizar la accion solicitada.");
				}
				catch(FinDeLaPartida e)
				{
					reproducirSonido("recursos/congrats.wav");
					vista.mostrarCartelFinJuego("El jugador "+e.obtenerGanador()+" ha ganador la partida");
				}
			}
			
		}	
		return new ListenerCreadorEstructuras();
	}
	
	public ActionListener obtenerListenerMusica(final JMenuItem play, final Clip clip) 
	{
		class ListenerMusica implements ActionListener
		{
			int lastFrame;
			public void actionPerformed(ActionEvent arg0)
			{
                if (clip != null) {
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
	
	public void reproducirSonidoDeAtaque(String accion){

		switch (accion){
			case "Atacar": 
				reproducirSonido("recursos/pew pew.wav");
				break;
	
			case "LanzarTormentaPsiconica": 
				reproducirSonido("recursos/storm.wav");
				break;
							
			case "LanzarAlucinacion":
				reproducirSonido("recursos/illusion.wav");
				break;
				
			case "LanzarRadiacion": 
				reproducirSonido("recursos/radiation.wav");
				break;		
				
			case "LanzarEMP": 
				reproducirSonido("recursos/emp.wav");
				break;
							
			default: break;
		}
	}
	
	public void reproducirSonido(String ruta){
			Clip clip = abrirClip(ruta);
	        clip.start();
	}
	
	public Clip reproducirClipDeSonidoContinuamente(String ruta){
		Clip clip = abrirClip(ruta);
        clip.start();
        clip.loop(Clip.LOOP_CONTINUOUSLY);
        return clip;
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
