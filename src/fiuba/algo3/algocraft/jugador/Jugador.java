package fiuba.algo3.algocraft.jugador;

import java.util.ArrayList;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.creadores.CreadorEstructuras;
import fiuba.algo3.algocraft.creadores.CreadorUnidades;
import fiuba.algo3.algocraft.entidadesAbstractas.EntidadAbstracta;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.Interfaces.IEstructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTienePoblacionSuficienteException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Jugador {
	private ArrayList<Unidad> unidades;
	private ArrayList<Estructura> estructuras;
	private String nombre;
	private String color;
	private int minerales;
	private int gas;
	private int poblacionActual;
	protected CreadorEstructuras creadorEstructuras;
	protected CreadorUnidades creadorUnidades;
	private int poblacionMaxima;
	
	public Jugador(String nombreJugador, int mineralesInicial, int gasInicial) {
		this.nombre = nombreJugador;
		this.minerales = mineralesInicial;
		this.gas = gasInicial;
		this.poblacionActual = 0;
		this.unidades = new ArrayList<Unidad>();
		this.estructuras = new ArrayList<Estructura>();
		
	}

	public void agregarEstructura(String string, Vector2D posicion, Mundo mundo) throws NoEsDeSuRazaLaEstructuraException,
																				NoTieneLaEstructuraCreadaException,
																				NoTieneRecursosSuficientesException,
																				NoHayMineralEnElLugarACrear, 
																				NoHayGasEnElLugarACrear{
		
		Estructura estructura = creadorEstructuras.crearEstructura(string, posicion, mundo);
		estructuras.add( estructura);
		estructura.actualizarPoblacion();
		
	}


	public void agregarUnidad(String string) throws NoEsDeSuRazaLaUnidadException,
													NoTieneLaEstructuraCreadaException,
													NoTieneRecursosSuficientesException, 
													NoTienePoblacionSuficienteException {
		
		Unidad unidad = creadorUnidades.crearUnidad(string,estructuras);
		//se fija si hay poblacion para ponerla
		if ( poblacionActual+unidad.suministro() <= poblacionMaxima) {
				poblacionActual += unidad.suministro();
			
		}else { 
			//tiene que reintegrar porque al crear se paga por la unidad
			reintegroCosto(unidad);
			throw new NoTienePoblacionSuficienteException();
		}
		
		unidades.add(unidad);
		
	}


	public ArrayList<Unidad> ObtenerUnidades() {
		return unidades;
	}

	public void aumentarPoblacion(int i) {
		
		poblacionMaxima += i;
		
	}
	
	public void disminuirPoblacion(int i) {
		
		poblacionMaxima -= i;
		
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
	
	public void reintegroCosto(EntidadAbstracta entidad) {
		
		agregarMineral( entidad.costo().minerales() );
		agregarGas(entidad.costo().gas());
		
	}
}
