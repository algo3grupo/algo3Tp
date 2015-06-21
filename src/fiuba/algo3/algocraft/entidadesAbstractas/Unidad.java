package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Acciones.RecuperarEscudo;
import fiuba.algo3.algocraft.Interfaces.IUnidad;
import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Escudo;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesAereas;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesEnTierra;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.excepciones.NoSePuedeAtacarEstaFueraDeRango;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;


public abstract class Unidad extends ColaDeAcciones implements IUnidad {
	
	private int suministro;
	private int transporte;
	private Escudo escudo;

	public Unidad(int dimension, Vector2D posicion, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, 
			int suministro, int transporte, int turnos) {
		super(dimension, posicion, vida, rangoDeVision, jugador, nombre, costo, requiere, turnos);
		this.suministro = suministro;
		this.transporte = transporte;
		this.escudo = new Escudo(0);
		//
		this.agregarAccion(new RecuperarEscudo(this));
 	}


	public int suministro() {
		
		return suministro;
	}


	public ArrayList<Unidad> obtenerUnidadesAliadasEnRango(int rango) {
		//devuelve tmb a la unidad q llama lafuncion
		ArrayList<Unidad> unidadesTodas = getJugador().ObtenerUnidades();
		ArrayList<Unidad> unidadesCercanas = new ArrayList<Unidad>();
		
		for ( int i= 0; i < unidadesTodas.size(); i++ ){
			
			if ( this.obtenerPosicion().distanciaA(unidadesTodas.get(i).obtenerPosicion()) < rango){
				
				unidadesCercanas.add(unidadesTodas.get(i));
			}
		}
		return null;
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
				herir(ataque.danioAereo());
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
		Timer timer = new Timer();
		
		class Movimiento extends TimerTask
		{
			public void run() 
			{
				if(camino.size() > 0)
				{
					posicionarEn(camino.remove(0));		
					despejarZona();
					getJugador().getMundo().obtenerJuego().actualizarObservadores();
				}
				else
					timer.cancel();
			}
		}
		
		timer.schedule(new Movimiento(), 0, 1000/60);	
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
	
	public void herir(int danio){
		
		int danioSobrante = herirEscudo(danio);
		
		if ( this.suministro() != 0 ){
			super.herir(danioSobrante);
			
		 }
		//en Caso de Que sea Una unidadCopia
		else if (escudo.valorCampo() == 0){
			eliminar();
		}
	 }


	private int herirEscudo(int danio) {
		return escudo.herirCampo(danio);
	}


	public void recuperarEscudo() {
		
		if (escudo.util()){
			escudo.recuperarCampo();
		}
	}
	
	public void construirEscudo(int valor){
		escudo.tomarValor(valor);
	}
	
	public void desactivarEscudo(){
		escudo.herirCampo(escudo.valorCampo());
	}
	
}
