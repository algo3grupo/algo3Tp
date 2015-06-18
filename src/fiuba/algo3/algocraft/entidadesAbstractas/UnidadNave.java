package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.excepciones.NoEsPosibleCargarEstaUnidad;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class UnidadNave extends Unidad {
	private int capacidad;
	private int cargado;
	private ArrayList<Unidad> unidadesCargadas;

	public UnidadNave(int dimension, Vector2D posicion, int vida, int rangoDeVision, Jugador jugador,  Costo costo, int suministro, int turnos) {
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
		}
		
	}
	
	public void descargarUnidad(Unidad unidad){
		int i = unidadesCargadas.indexOf(unidad);
		unidadesCargadas.remove(i);
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
								cargarUnidad((Unidad) destino);
				
							}catch (NoEsPosibleCargarEstaUnidad e) {
								e.printStackTrace();
							}
							break;
							
			case "Descargar": descargarUnidad( (Unidad) destino);
							break;
							
			default:	super.realizarAccion(accion, destino);
						break;
		}
	}
}
