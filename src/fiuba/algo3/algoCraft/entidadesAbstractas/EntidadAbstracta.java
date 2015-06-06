package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class EntidadAbstracta {
	private int ID;
	protected int vida;
	protected int rangoDeVision;
	protected Jugador jugador;
	protected String nombre;
	protected Costo costo;
	protected String requiere;
	
	public EntidadAbstracta(Jugador jugador){
		this.jugador = jugador;
		requiere = "";
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
