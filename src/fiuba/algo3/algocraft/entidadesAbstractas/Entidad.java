package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;
import fiuba.algo3.algocraft.ID;

public abstract class Entidad {
	private int turnos;
	private int ID;
	private int vida;
	private int rangoDeVision;
	private Jugador jugador;
	private String nombre;
	private Costo costo;
	private String requiere;
	private Vector2D posicion;
	private int dimensionX;
	private int dimensionY;
	
	public Entidad( int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int turnos){
		this.ID = new ID().getIdNuevo();
		this.vida = vida;
		this.rangoDeVision = rangoDeVision;
		this.jugador = jugador;
		this.nombre = nombre;
		this.costo = costo;
		this.requiere = requiere;
		this.turnos = turnos;
	}
	
	
	

	
	public boolean incluyeA(Vector2D posicion)
	{		
		
		if( this.posicion.obtenerCoordenadaX() <= posicion.obtenerCoordenadaX() && posicion.obtenerCoordenadaX() <= (this.posicion.obtenerCoordenadaX()+dimensionX))
			if( this.posicion.obtenerCoordenadaY() <= posicion.obtenerCoordenadaY() && posicion.obtenerCoordenadaY() <= (this.posicion.obtenerCoordenadaY()+dimensionY))
				return true;
		return false;
	}

	public Vector2D obtenerPosicion() {
		return new Vector2D(posicion);
	}
	
	public Entidad(Vector2D posicion, int dimensionX, int dimensionY)
	{
		this.posicion = new Vector2D(posicion);
		this.dimensionX = dimensionX;
		this.dimensionY = dimensionY;

	}

	public Entidad(Entidad entidad) 
	{
		posicion = new Vector2D(entidad.posicion);
		dimensionX = entidad.dimensionX;
		dimensionY = entidad.dimensionY;		
	}
	
	public String nombre(){
		
		return this.nombre;
	}

	public Costo costo() {
		
		return this.costo;
	}
	
	public void estaLaEstructuraCreada(ArrayList<Estructura> estructuras) throws NoTieneLaEstructuraCreadaException  {
		
		for (int i = 0; i < estructuras.size(); i++) {
			
			if( ( estructuras.get(i).nombre() == this.requiere() ) & (estructuras.get(i).turnosEnCrear() == 0)){
				return;
			}
		}
		throw new NoTieneLaEstructuraCreadaException();
		
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
	
	public void atacadoVida(int danio){
		
		if (vida - danio <= 0){
			eliminar();
		}
			this.vida -= danio;
	}

	public int turnosEnCrear(){
		return turnos;
		
	}
	
	private void eliminar() {
		
		jugador.eliminar(this);
		
		
	}

	public void disminuirTurno(){
		//los turnos no disminuyen a menos que 0
		turnos --;
		if (turnos < 0){
			turnos = 0;
		}
	}



	public int ID() {
		
		return ID;
	}
}
