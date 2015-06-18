package fiuba.algo3.algocraft;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;














import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fiuba.algo3.algocraft.entidadesAbstractas.Dibujable;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.FinDeLaPartida;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesAereas;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesEnTierra;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEntidad;
import fiuba.algo3.algocraft.excepciones.NoSePuedeAtacarEstaFueraDeRango;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.graficos.Lienzo;
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
		
		mundo = new Mundo(5000,100,this);
		mundo.generar();
		
		ventana = crearVentana();
		
		
		if(razaJugador1=="Protoss")
			jugador1 = new Protoss(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador1(),nombreJugador1,colorJugador1);
		else
			jugador1 = new Terran(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador1(),nombreJugador1,colorJugador1);
		
		if(razaJugador2=="Protoss")
			jugador2 = new Protoss(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador2(),nombreJugador2,colorJugador2);
		else
			jugador2 = new Terran(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador2(),nombreJugador2,colorJugador2);
		
		turno = jugador1;
		
		
	
		
		
	}

	private JFrame crearVentana() 
	{
		JFrame ventana = new JFrame("Algocraft"); 
		ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		ventana.setSize(800,800);
		ventana.setVisible(true);
		
		Lienzo lienzo = new Lienzo(this,mundo.obtenerResolucion());
		
		JScrollPane camara = new JScrollPane(lienzo);
		camara.setPreferredSize(new Dimension(400,400));

		
		ventana.add(camara);		

		
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
		if ( alguienPerdio()){
			throw new FinDeLaPartida();
		}
		
		if(turno == jugador1)
			turno = jugador2;
		else
			turno = jugador1;
		
		jugador1.terminarTurno();
		jugador2.terminarTurno();
	}
	
	private boolean alguienPerdio() {
		if (( jugador1.estaVivo() ) & ( jugador2.estaVivo() )){
			return false;
		}
		return true;
	}

	public ArrayList<Unidad> obtenerUnidadesContrarias()
	{
		if(turno == jugador1)
			return obtenerUnidadesDeJugador2();
		else
			return obtenerUnidadesDeJugador1();
	}
	
	public ArrayList<Estructura> obtenerEstructurasContrarias(){
		if(turno == jugador1)
			return obtenerEstructurasDeJugador2();
		else
			return obtenerEstructurasDeJugador1();
	}
	
	public Mundo obtenerMundo() {
		return mundo;
	}

	public void construirEstructura(String nombre, Vector2D posicion) 
	{
				try {
					turno.agregarEstructura(nombre, posicion, mundo);
				} catch (NoEsDeSuRazaLaEstructuraException
						| NoTieneLaEstructuraCreadaException
						| NoTieneRecursosSuficientesException
						| NoHayMineralEnElLugarACrear | NoHayGasEnElLugarACrear
						| ErrorAlHacerCopia e) {
					
					e.printStackTrace();
				}
	}
	
	public void crearUnidad( String nombre) 
	{
		try {
			turno.agregarUnidad(nombre, mundo);
		} catch (NoEsDeSuRazaLaUnidadException
				| NoTieneLaEstructuraCreadaException
				| NoTieneRecursosSuficientesException | NoSeEncontroLaEntidad
				| ErrorAlHacerCopia e) {
			e.printStackTrace();
		}
		
	}
	
	public void actualizarVista(Graphics contexto)
	{		
		
		 mundo.dibujar(contexto);
		 
		jugador1.actualizarVista(contexto);
		jugador2.actualizarVista(contexto);
		
		
		
		
	}

	public ArrayList<Unidad> obtenerUnidadesTurno() {
		
		return turno.ObtenerUnidades();
	}

	public void moverUnidad(Unidad unidad, Vector2D posicion) {
		
		unidad.moverA(posicion);
		
	}

	public void unidadAtaqueAtacaA(UnidadAtaqueBasico turno, Entidad enemiga) {
		
		try {
			turno.atacar(enemiga);
		} catch (NoSePuedeAtacarEstaFueraDeRango
				| NoPuedeAtacarUnidadesEnTierra | NoPuedeAtacarUnidadesAereas e) {
			e.printStackTrace();
		}
	}

	public Vector2D obtenerPosicion(Entidad entidad) {
		
		return entidad.obtenerPosicion();
	}

}
