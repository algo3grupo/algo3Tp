package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.NoTienePoblacionSuficienteException;


public class CrearUnidad implements IAccion{
	private Unidad unidad;
	private int turnos;
	
	public CrearUnidad(int turnos, Unidad unidad){
		this.turnos = turnos;
		this.unidad = unidad;
	}

	public void crearUnidad(IColaDeAcciones llamador) throws  NoTienePoblacionSuficienteException {
		
		
		Estructura estructura = (Estructura)llamador;
		if (! estructura.getJugador().hayPoblacionParaUnidad(unidad)){
			throw new NoTienePoblacionSuficienteException();
		}
		//posicionar y agregar a la poblacion a la unidad
		
	}

	
	public void ejecutar(IColaDeAcciones llamador) {
		turnos --;
		
		if (turnos == 0){
			try {
				crearUnidad(llamador);
			} catch (NoTienePoblacionSuficienteException e) {
				return;				
			}
			llamador.QuitarAccion(this);
		}
		
	}
	
	

}
