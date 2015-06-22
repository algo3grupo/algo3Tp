package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.NoTienePoblacionSuficienteException;


public class CrearUnidad implements IAccion{
	private Unidad unidad;
	private Estructura estructura;
	
	public CrearUnidad(Estructura llamador, Unidad unidad){
		this.unidad = unidad;
		this.estructura = llamador;
	}

	public void lanzarAlMapa() throws  NoTienePoblacionSuficienteException {
		
		
		if (! estructura.getJugador().hayPoblacionParaUnidad(unidad)){
			throw new NoTienePoblacionSuficienteException();
		}
		
		estructura.getJugador().incorporarUnidad(unidad); 
		
	}

	
	public void ejecutar(IColaDeAcciones llamador) {
		unidad.disminuirTurno();
		
		if (unidad.estaHabilitada()){
			try {
				lanzarAlMapa();
			} catch (NoTienePoblacionSuficienteException e) {
				//mientras que no tenga poblacion para sacarla no quita esta accion
				return;				
			}
			llamador.QuitarAccion(this);
		}
		
	}
	
	

}
