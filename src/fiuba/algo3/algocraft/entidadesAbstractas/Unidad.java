package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Interfaces.IEfectoEMP;
import fiuba.algo3.algocraft.Interfaces.IUnidad;
import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Escudo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesAereas;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesEnTierra;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.excepciones.NoSePuedeAtacarEstaFueraDeRango;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;


public abstract class Unidad extends ColaDeAcciones implements IUnidad, IEfectoEMP {
	
	private int suministro;
	private int transporte;

	public Unidad(int dimension, Vector2D posicion, Vida vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, 
			int suministro, int transporte, int turnos) {
		super(dimension, posicion, vida, rangoDeVision, jugador, nombre, costo, requiere, turnos);
		this.suministro = suministro;
		this.transporte = transporte;

 	}


	public int suministro() {
		
		return suministro;
	}


	public int transporte() {
		
		return transporte;
	}


	public boolean esVoladora() {
		
		if( transporte == 0){
			return true;
		}
		
		return false;
	}


	public void atacado(Ataque ataque, int distancia) throws NoSePuedeAtacarEstaFueraDeRango,
																NoPuedeAtacarUnidadesEnTierra, NoPuedeAtacarUnidadesAereas{
		
		if (esVoladora()){
			
			if ( ataque.estaEnRangoAire(distancia) ){
				daniar(ataque.danioAereo());
			}
			else{
				throw new NoSePuedeAtacarEstaFueraDeRango();
			}
		}
		
		else{
			super.atacado(ataque, distancia);
		}
		
	}
	
	public void moverA(Vector2D posicion) 
	{
		ArrayList<Vector2D> camino = this.getJugador().getMundo().obtenerRutaSeguraEntre(this.obtenerPosicion(), posicion);
		
		for(int i=0;i<camino.size();i++)
		{
			posicionarEn(camino.get(i));		
			despejarZona();
			getJugador().getMundo().obtenerJuego().actualizarObservadores(this);
		}
	
	}
	
	public ArrayList<String> mostrarAcciones(){
		ArrayList<String> listaAcciones = new ArrayList<String>();
		listaAcciones.add("Mover");
		
		return listaAcciones;
		
	}
	
	public void realizarAccion(String accion, Entidad destino) throws NoPuedeRealizarEsaAccion{
		if ( accion.matches("Mover") ){
			moverA(destino.obtenerPosicion());
		}
		else{
			throw new NoPuedeRealizarEsaAccion(); 
		}
		
	}
	
	
	private void desactivarEscudo(){
		//La unidad copia muere si el escudo llega a 0 por lo que si esto le pega a una copia debe morir
		getVida().desactivarEscudo();
		if (murio()){
			eliminar();
		}
	}
	
	public void eliminar(){
		getJugador().disminuirPoblacionActual(suministro);
		super.eliminar();
	}
	
	public void cambiarSuministro(int i){
		//No pude cambiar el suministro por reflexion por lo que agregue esto
		suministro = i;
	}
	
	public void atacadoPorEMP(){
		desactivarEscudo();
	}


	public void sacarDelMapa() {
		
		posicionarEn(new Vector2D(-10000,-10000));
	}
}

