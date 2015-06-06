package fiuba.algo3.algocraft.creadores;

import java.util.ArrayList;

import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEntidadException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;

public abstract class CreadorUnidades extends Creador {
	
	public Unidad crearUnidad(String string, ArrayList<Estructura> estructuras) throws NoEsDeSuRazaLaUnidadException,
																					NoTieneLaEstructuraCreadaException,
																					NoTieneRecursosSuficientesException{
		try {
			
			return (Unidad)crearEntidad(string, null, null);
			
		} catch (NoEsDeSuRazaLaEntidadException e) {
			throw new NoEsDeSuRazaLaUnidadException();
		} catch (NoTieneLaEstructuraCreadaException
				| NoTieneRecursosSuficientesException e){
			throw e;
		}
	}
}
