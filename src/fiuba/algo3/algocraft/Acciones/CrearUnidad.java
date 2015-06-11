package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.NoTienePoblacionSuficienteException;


public class CrearUnidad implements IAccion{
	private Unidad unidad;
	
	public CrearUnidad( Unidad unidad){
		this.unidad = unidad;
	}

	public void crearUnidad(IColaDeAcciones llamador) throws  NoTienePoblacionSuficienteException {
		
		
		Estructura estructura = (Estructura)llamador;
		if (! estructura.getJugador().hayPoblacionParaUnidad(unidad)){
			throw new NoTienePoblacionSuficienteException();
		}
		
		estructura.getJugador().incorporarUnidad(unidad);
		//falta posicionar, incorporar podria hacerlo si unidad ya tiene posicion 
		
	}

	
	public void ejecutar(IColaDeAcciones llamador) {
		unidad.disminuirTurno();
		
		if (unidad.turnosEnCrear() == 0){
			try {
				crearUnidad(llamador);
			} catch (NoTienePoblacionSuficienteException e) {
				//mientras que no tenga poblacion para sacarla no quita esta accion
				return;				
			}
			llamador.QuitarAccion(this);
		}
		
	}
	
	

}
