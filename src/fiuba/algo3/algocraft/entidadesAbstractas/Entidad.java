package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesAereas;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesEnTierra;
import fiuba.algo3.algocraft.excepciones.NoSePuedeAtacarEstaFueraDeRango;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;
import fiuba.algo3.algocraft.ID;

public abstract class Entidad {
	private int turnos;
	private int ID;
	private int vida;
	private int vidaMaxima;
	private int rangoDeVision;
	private Jugador jugador;
	private String nombre;
	private Costo costo;
	private String requiere;
	private Vector2D posicion;
	private int dimension;
	
	public void despejarZona()
	{
		for(int i=0;i<rangoDeVision*2;i++)
			for(int a=0;a<rangoDeVision*2;a++)
			{
				jugador.verZona(new Vector2D((i*dimension)+(posicion.obtenerCoordenadaX()-(rangoDeVision*dimension)),(a*dimension)+(posicion.obtenerCoordenadaY()-(rangoDeVision*dimension))));	
			}
	}
	
	public Entidad(int dimension, Vector2D posicion, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int turnos){
		this.ID = new ID().getIdNuevo();
		this.vida = vida;
		this.vidaMaxima = vida;
		this.rangoDeVision = rangoDeVision;
		this.jugador = jugador;
		this.nombre = nombre;
		this.costo = costo;
		this.requiere = requiere;
		this.turnos = turnos;
		this.posicion = new Vector2D(posicion);
		this.dimension = dimension;
	}
	
	public int obtenerVidaMaxima()
	{
		return vidaMaxima;
	}
	
	
	public void setNombre(String nombre)
	{
		this.nombre = nombre;
	}
	
	public boolean incluyeA(Vector2D posicion)
	{		
		
		if(!this.posicion.distintoA(posicion))
			return true;
		
		if( this.posicion.obtenerCoordenadaX() < posicion.obtenerCoordenadaX() && posicion.obtenerCoordenadaX() < (this.posicion.obtenerCoordenadaX()+dimension))
			if( this.posicion.obtenerCoordenadaY() < posicion.obtenerCoordenadaY() && posicion.obtenerCoordenadaY() < (this.posicion.obtenerCoordenadaY()+dimension))
				return true;
		return false;
	}

	
	public Vector2D obtenerPosicion() {
		return new Vector2D(posicion);
	}
	
	public Entidad(Entidad entidad) 
	{
		posicion = new Vector2D(entidad.posicion);
		dimension = entidad.dimension;		
	}

	public String nombre(){
		
		return this.nombre;
	}

	public Costo costo() {
		
		return this.costo;
	}
	
	public boolean estaLaEstructuraCreada(ArrayList<Estructura> estructuras) throws NoTieneLaEstructuraCreadaException  {
		
		if (this.requiere == ""){
			return true;
		}
		else{
			for (int i = 0; i < estructuras.size(); i++) {
			
				if( ( estructuras.get(i).nombre() == this.requiere() ) & (estructuras.get(i).estaHabilitada())){
					return true;
				}
			}
		}
		return false;
		
	}
	public String requiere() {
		
		return requiere;
		
	}
	
	public int verVida(){
		
		return vida;
		
	}
	
	public int verRangoVision(){
		
		return rangoDeVision;
		
	}
	
	public Jugador getJugador() {
		
		return this.jugador;
	}
	
	

	public int turnosEnCrear(){
		return turnos;
		
	}
	
	protected void eliminar() {
		
		jugador.eliminar(this);
		
		
	}

	public void disminuirTurno(){
		//los turnos no disminuyen a menos que 0
		turnos --;
		if (turnos < 0){
			turnos = 0;
		}
	}
	
	public boolean estaHabilitada(){
		
		return (turnos == 0);
	}


	public int ID() {
		
		return ID;
	}
	
	public abstract void hacerMisAcciones();
	
	public void ejecutarAccionesDeTurno()
	{
		disminuirTurno();
		
		if(!estaHabilitada())
			return;
		hacerMisAcciones();
		
	}
	
	public int obtenerDimension()
	{
		return dimension;
	}



	public void atacado(Ataque ataque, int distancia) throws NoSePuedeAtacarEstaFueraDeRango, NoPuedeAtacarUnidadesEnTierra, NoPuedeAtacarUnidadesAereas {
		//en principio las entidades son terrenas salvo q se el caso de una unidad voladora
		if (ataque.estaEnRangoTierra(distancia)){
			herir(ataque.danioTierra());
		}
		else{
			throw new NoSePuedeAtacarEstaFueraDeRango();
		}
		
		
		
	}


	public void herir(int danio) {
		
		if (loMata(danio)){
			eliminar();
		}
		else{
			this.vida -= danio;
		}
	}
	
	public void posicionarEn(Vector2D posicion){
		
		this.posicion = posicion;
	}
	
	public boolean esDelMismoJugador(Entidad entidad){
		
		if (entidad.getJugador()== jugador){
			return true;
		}
		return false;
	}
	public boolean equals(Object comparado){
		//compara por ID, q es unico en cada entidad
		return ( ID() == ( ( (Entidad) comparado ).ID()) );
	}
	
	public boolean loMata(int danio){
		
		return (vida - danio <= 0);
		
	}
	
	public boolean estaEn(Vector2D supizq, int dimension)
	{
		Vector2D vertice = new Vector2D(this.posicion);
		
		if(vertice.perteneceA(supizq, dimension))
			return true;
		
		vertice = new Vector2D(this.posicion.obtenerCoordenadaX()+dimension,this.posicion.obtenerCoordenadaY());
		
		if(vertice.perteneceA(supizq, dimension))
			return true;
		
		vertice = new Vector2D(this.posicion.obtenerCoordenadaX(),this.posicion.obtenerCoordenadaY()+dimension);
		
		if(vertice.perteneceA(supizq, dimension))
			return true;
		
		vertice = new Vector2D(this.posicion.obtenerCoordenadaX()+dimension,this.posicion.obtenerCoordenadaY()+dimension);
		
		if(vertice.perteneceA(supizq, dimension))
			return true;
		
		return false;
		
		
	}
}
