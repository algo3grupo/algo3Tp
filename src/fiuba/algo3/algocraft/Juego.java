package fiuba.algo3.algocraft;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.util.ArrayList;


















import java.util.Iterator;
import java.util.Observable;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.FinDeLaPartida;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesAereas;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesEnTierra;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEntidad;
import fiuba.algo3.algocraft.excepciones.NoSePuedeAtacarEstaFueraDeRango;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Protoss;
import fiuba.algo3.algocraft.jugador.Terran;
import fiuba.algo3.algocraft.mundo.Mineral;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;
import fiuba.algo3.algocraft.vista.Dibujable;
import fiuba.algo3.algocraft.vista.Lienzo;
import fiuba.algo3.excepciones.NoLePerteneceLaEntidad;

public class Juego extends Observable{
	
	private Jugador jugador1, jugador2, turno;
	private Mundo mundo;
	
	public Juego(String razaJugador1, String nombreJugador1, Color colorJugador1, String razaJugador2, String nombreJugador2, Color colorJugador2)
	{
		
		mundo = new Mundo(5000,100,this);
		mundo.generar();		
		
		if(razaJugador1=="Protoss")
			jugador1 = new Protoss(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador1(),nombreJugador1,colorJugador1,mundo);
		else
			jugador1 = new Terran(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador1(),nombreJugador1,colorJugador1, mundo);
		
		if(razaJugador2=="Protoss")
			jugador2 = new Protoss(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador2(),nombreJugador2,colorJugador2, mundo);
		else
			jugador2 = new Terran(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador2(),nombreJugador2,colorJugador2, mundo);
		
		turno = jugador1;
		
		
	
		
		
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
		
		actualizarObservadores();
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
		posicion = mundo.pixelAGrilla(posicion);
				try {
					turno.agregarEstructura(nombre, posicion);
				} catch (NoEsDeSuRazaLaEstructuraException
						| NoTieneLaEstructuraCreadaException
						| NoTieneRecursosSuficientesException
						| NoHayMineralEnElLugarACrear | NoHayGasEnElLugarACrear
						| ErrorAlHacerCopia e) {
					
					e.printStackTrace();
				}
	}
	
	public void crearUnidad(String nombre, Estructura estructura) 
	{
		try {
			turno.agregarUnidad(nombre, estructura);
		} catch (NoEsDeSuRazaLaUnidadException
				| NoTieneLaEstructuraCreadaException
				| NoTieneRecursosSuficientesException | NoSeEncontroLaEntidad
				| ErrorAlHacerCopia e) {
			e.printStackTrace();
		}
		
	}

	public ArrayList<Unidad> obtenerUnidadesTurno() {
		
		return turno.ObtenerUnidades();
	}

	public void moverUnidad(Unidad unidad, Vector2D posicion) throws NoLePerteneceLaEntidad {
		if (entidadPertenceAJugador(unidad)){
		
		unidad.moverA(posicion);
		
		}
		else throw new NoLePerteneceLaEntidad();
	}

	public void unidadAtaqueAtacaA(UnidadAtaqueBasico turno, Entidad enemiga) throws NoLePerteneceLaEntidad {
		if (entidadPertenceAJugador(turno)){
			try {
				turno.atacar(enemiga);
			} catch (NoSePuedeAtacarEstaFueraDeRango
					| NoPuedeAtacarUnidadesEnTierra | NoPuedeAtacarUnidadesAereas e) {
				e.printStackTrace();
			}
		}else throw new NoLePerteneceLaEntidad();
	}

	public Vector2D obtenerPosicion(Entidad entidad) {
		
		return entidad.obtenerPosicion();
	}

	
	private boolean entidadPertenceAJugador(Entidad entidad){
		if (entidad.getJugador()==turno){
			return true;
		}
		return false;
	}
	
	public ArrayList<String> pedirAccionesPosibles(Unidad unidad){
		return unidad.mostrarAcciones();
		
	}
	
	public ArrayList<String> verEstructurasDeLaRaza(){
		return turno.obtenerNombreEstructurasDeRaza();
	}
	
	public ArrayList<String> verUnidadesDeLaRaza(){
		return turno.obtenerNombreUnidadesDeRaza();
	}

	public void actualizarObservadores() 
	{
		setChanged();
		notifyObservers();
	}

	public int obtenerGasJugadorActual() 
	{
		return turno.obtenerGas();
	}

	public int obtenerMineralJugadorActual()
	{
		return turno.obtenerMineral();
	}

	public int obtenerPoblacionActualJugador() 
	{
		return turno.obtenerPoblacionActual();
	}

	public int obtenerPoblacionlimiteJugador() 
	{
		return turno.obtenerPoblacionLimite();
	}
	
	public String obtenerRaza()
	{
		return turno.obtenerRaza();
	}

	public Estructura obtenerEstructura(Vector2D posicion)
	{
		ArrayList<Estructura> e = turno.obtenerEstructuras();
		Estructura estructura;
		
		Iterator i = e.iterator();
		
		while(i.hasNext())
		{
			estructura = (Estructura)i.next();
			if(estructura.incluyeA(posicion))
				return estructura;
		}
		return null;
	}

	public Unidad obtenerUnidad(Vector2D posicion) 
	{
		ArrayList<Unidad> e = turno.ObtenerUnidades();
		Unidad unidad;
		
		Iterator i = e.iterator();
		
		while(i.hasNext())
		{
			unidad = (Unidad)i.next();
			if(unidad.incluyeA(posicion))
				return unidad;
		}
		return null;
	}

	public ArrayList<String> verUnidadesDeEstructura(Estructura estructura)
	{
		return estructura.obtenerUnidadesCreables();
	}

	public boolean hayEstructurasEnemigas(Vector2D posicion) 
	{
		ArrayList<Estructura> e = obtenerEstructurasContrarias();
		Estructura estructura;
		
		Iterator i = e.iterator();
		
		while(i.hasNext())
		{
			estructura = (Estructura)i.next();
			if(estructura.incluyeA(posicion))
				return true;
		}
		return false;
	}

	public void indicarAccion(String string, Unidad unidad, Entidad entidad) 
	{
		try
		{
			unidad.realizarAccion(string, entidad);		
		}
		catch(NoPuedeRealizarEsaAccion e)
		{
			
		}
	}
}
