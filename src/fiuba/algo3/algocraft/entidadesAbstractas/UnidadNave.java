package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.excepciones.NoEsPosibleCargarEstaUnidad;
import fiuba.algo3.algocraft.excepciones.NoHayUnidadEnEsaPosicion;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class UnidadNave extends Unidad {
	private int capacidad;
	private int cargado;
	private ArrayList<Unidad> unidadesCargadas;

	public UnidadNave(int dimension, Vector2D posicion, Vida vida, int rangoDeVision, Jugador jugador,  Costo costo, int suministro, int turnos) {
		super(dimension, posicion, vida, rangoDeVision, jugador, "Nave Transporte" , costo, "Puerto Estelar", suministro, 0, turnos);
		capacidad = 8;
		cargado = 0;
		unidadesCargadas = new ArrayList<Unidad>();
	}
	
	public void cargarUnidad(Unidad unidad) throws NoEsPosibleCargarEstaUnidad{
		
		if ( (cargado + unidad.transporte() > capacidad) || (unidad.esVoladora()) || ( !esDelMismoJugador(unidad))){
			throw new NoEsPosibleCargarEstaUnidad();
		}
		else {
			cargado+= unidad.transporte();
			unidadesCargadas.add(unidad);
			unidad.sacarDelMapa();
		}
		
	}
	
	public void descargarUnidades(){
		Vector2D posicionNave = obtenerPosicion();
		while (unidadesCargadas.size() > 0){
			Unidad unidad = unidadesCargadas.get(0);
			unidadesCargadas.remove(0);
			cargado -= unidad.transporte();
			unidad.posicionarEn(new Vector2D().aleatorio(posicionNave.obtenerCoordenadaX(), posicionNave.obtenerCoordenadaX() + obtenerDimension()
					, posicionNave.obtenerCoordenadaY(), posicionNave.obtenerCoordenadaY()+obtenerDimension()));
		}
	}
	
	public void eliminar(){
		//Cuando muere mueren todas las unidades cargadas tambien
		for (int i = 0; i < unidadesCargadas.size(); i++){
			//elimina del jugador a las unidades
			unidadesCargadas.get(i).eliminar();
		}
		//se elimina a si misma
		super.eliminar();
	}
	
	public int cantidadCargado(){
		return cargado;
	}
	
	public ArrayList<String> mostrarAcciones(){
		ArrayList<String> listaAcciones = super.mostrarAcciones();
		listaAcciones.add("Cargar");
		listaAcciones.add("Descargar");
		
		return listaAcciones;
		
	}
	
	public void realizarAccion(String accion, Entidad destino) throws NoPuedeRealizarEsaAccion{
		switch (accion){
			case "Cargar": try {
								getJugador().getMundo().obtenerUnidadEn(destino.obtenerPosicion());
								cargarUnidad((Unidad) destino);
				
							}catch (NoEsPosibleCargarEstaUnidad | NoHayUnidadEnEsaPosicion e) {
								e.printStackTrace();
							}
							break;
							
			case "Descargar": descargarUnidades();
							break;
							
			default:	super.realizarAccion(accion, destino);
						break;
		}
	}
}
