package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Entidad {
	private int ID;
	protected int vida;
	protected int rangoDeVision;
	protected Jugador jugador;
	protected String nombre;
	protected Costo costo;
	protected String requiere;
	private Vector2D posicion;
	private int dimensionX;
	private int dimensionY;
	
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
	
	public Entidad(Jugador jugador)
	{
		this.jugador = jugador;
		requiere = "";
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
			if( estructuras.get(i).nombre() == this.requiere() );
				return;
		}
		throw new NoTieneLaEstructuraCreadaException();
	}

	public String requiere() {
		
		return requiere;
	}
	

	public Jugador jugador() {
		
		return this.jugador;
	}
}
