package fiuba.algo3.algocraft.jugador;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.IModo;
import fiuba.algo3.algocraft.ModoID;
import fiuba.algo3.algocraft.ModoNombre;
import fiuba.algo3.algocraft.Acciones.CrearUnidad;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.creadores.CreadorEstructuras;
import fiuba.algo3.algocraft.creadores.CreadorUnidades;
import fiuba.algo3.algocraft.entidadesAbstractas.ColaDeAcciones;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHaySuministroEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEntidad;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTienePoblacionSuficienteException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.mundo.Ceguera;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Jugador {
	private ArrayList<Unidad> unidades;
	private ArrayList<Estructura> estructuras;
	
	private Mundo mundo;
	private String nombre;
	private Color color;
	private int minerales;
	private int gas;
	private int poblacionActual;
	private CreadorEstructuras creadorEstructuras;
	private CreadorUnidades creadorUnidades;
	private int poblacionMaxima;
	private int dimension;
	private ArrayList<Ceguera> puntosCiegos; 
	
	public Jugador(int dimension, Vector2D base, String nombreJugador, Color colorJugador, Mundo mundo) {
		
		color = colorJugador;
		this.nombre = nombreJugador;
		this.minerales = 200;
		this.gas = 0;
		this.poblacionActual = 0;
		this.unidades = new ArrayList<Unidad>();
		this.estructuras = new ArrayList<Estructura>();
		poblacionMaxima = 0;
		this.dimension = dimension;
		this.mundo = mundo;
		
		puntosCiegos = new ArrayList<Ceguera>();
		
		for(int i=0;i<mundo.obtenerResolucion()/dimension;i++)
			for(int a=0;a<mundo.obtenerResolucion()/dimension;a++)
				puntosCiegos.add(new Ceguera(new Vector2D(i*dimension,a*dimension),dimension));
		
	}
	
	public ArrayList<Ceguera> obtenerCegueras()
	{
		return puntosCiegos;
	}
	
	public void verZona(Vector2D posicion)
	{
		
		for(int i=0;i<puntosCiegos.size();i++)
			if(puntosCiegos.get(i).incluyeA(posicion))
				puntosCiegos.remove(i);				
	}

	public void agregarEstructura(String string, Vector2D posicion) throws NoEsDeSuRazaLaEstructuraException,
																				NoTieneLaEstructuraCreadaException,
																				NoTieneRecursosSuficientesException,
																				NoHayMineralEnElLugarACrear, 
																				NoHayGasEnElLugarACrear, ErrorAlHacerCopia, NoHaySuministroEnElLugarACrear{
		
		Estructura estructura = creadorEstructuras.crearEstructura(string, posicion, mundo);
		incorporarEstructura(estructura);
		
		
	}


	public void agregarUnidad(String string, Estructura estructura) throws NoEsDeSuRazaLaUnidadException,
													NoTieneLaEstructuraCreadaException,
													NoTieneRecursosSuficientesException,  
													NoSeEncontroLaEntidad, ErrorAlHacerCopia {
		//una estructura ha habiliada comienza a crear la unidad
		estructuraEmpiezaACrearUnidad(string, estructura);
		
		
	}
	
	public void estructuraEmpiezaACrearUnidad( String nombre, Estructura estructura) throws NoEsDeSuRazaLaUnidadException, 
								NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException,
								ErrorAlHacerCopia, NoSeEncontroLaEntidad{
		//crea la unidad
		Unidad unidad = creadorUnidades.crearUnidad(nombre, mundo, estructura);
		//si puede crearla la agrega a la cola de acciones de la estructura que la crea
		estructura.agregarAccion(new CrearUnidad( estructura, unidad ));
		
	}


	
	public ArrayList<Unidad> ObtenerUnidades() {
		return unidades;
	}

	public boolean hayPoblacionParaUnidad(Unidad unidad){
		
		return (poblacionActual + unidad.suministro() <= poblacionMaxima);
	}
	
	private void sumarSuministroUnidad(Unidad unidad){
		
		poblacionActual += unidad.suministro();
		
	}
	
	public void aumentarPoblacion(int i) {
		if (poblacionMaxima+i > 200){
			poblacionMaxima = 200;
			
		}
		else{
			poblacionMaxima += i;
			
		}
	}
	
	public void disminuirPoblacion(int i) {
		
		poblacionMaxima -= i;
		
	}
	
	public void disminuirPoblacionActual(int i){
		
		poblacionActual -= i;
	}

	public ArrayList<Estructura> obtenerEstructuras() {
		
		return estructuras;
		
	}

	public int getMinerales() {
		return minerales;
	}
	
	public int gas() {
		
		return gas;
	}

	
	public void agregarMineral(int cantidad){
		minerales = minerales + cantidad;
	}

	public void agregarGas(int cantidad){
		gas = gas + cantidad;
	}

	public void quitarMineral(int cantidad){
		minerales = minerales - cantidad;
	}

	public void quitarGas(int cantidad){
		gas = gas - cantidad;
	}
	
	public void pagar(Costo costo) {
		
		quitarMineral(costo.minerales());
		quitarGas(costo.gas());
		
	}
	
	public void reintegroCosto(Entidad entidad) {
		
		agregarMineral( entidad.costo().minerales() );
		agregarGas(entidad.costo().gas());
		
	}
	
	public void incorporarEstructura(Estructura estructura){
		estructuras.add(estructura);
		estructura.despejarZona();
	}
	
	public void incorporarUnidad(Unidad unidad){
		// a ser usada cuando se sabe que se puede sumar la unidad
		unidades.add(unidad);
		sumarSuministroUnidad(unidad);
	
	}
	
	private void ejecutarAccionesDeLista(ArrayList lista){
		for (int i = 0; i < lista.size(); i++){
			((Entidad) lista.get(i)).ejecutarAccionesDeTurno();
			
		}
		
	}
	public void terminarTurno(){
		ejecutarAccionesDeLista((ArrayList) estructuras);
		ejecutarAccionesDeLista((ArrayList) unidades);
		
		
	}

	public void eliminar(Entidad entidad) {
		//sacar de la lista
		estructuras.remove((Object) entidad);
		unidades.remove((Object) entidad);
		
	}
	
	public boolean estaVivo() {
		if (estructuras.size()==0 & unidades.size()==0){
			return false;
		}
		else{
			return true;
		}
	}
	
	public ArrayList<String> obtenerNombreUnidadesDeRaza(){
		
		return creadorUnidades.obtenerNombres();
	}
	
	public ArrayList<String> obtenerNombreEstructurasDeRaza(){
		
		return creadorEstructuras.obtenerNombres();
	}
	
	public Mundo getMundo(){
		return mundo;
	}

	public int obtenerGas() 
	{
		return gas;
	}

	public int obtenerMineral() 
	{
		return minerales;
	}

	public int obtenerPoblacionActual() 
	{
		return poblacionActual;
	}

	public int obtenerPoblacionLimite() 
	{
		return poblacionMaxima;
	}
	
	public abstract String obtenerRaza();

	public Color obtenerColor() 
	{
		return color;
	}

	public String obtenerNombre() 
	{
		return nombre;
	}
	
	public void setCreadores(CreadorEstructuras creadorEstructuras, CreadorUnidades creadorUnidades){
		this.creadorEstructuras = creadorEstructuras;
		this.creadorUnidades = creadorUnidades;
	}
	
}
