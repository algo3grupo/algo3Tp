package fiuba.algo3.algoCraft.creadores;

import java.util.ArrayList;

import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algoCraft.excepciones.NoEsDeSuRazaLaEntidadException;
import fiuba.algo3.algoCraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algoCraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algoCraft.excepciones.NoTieneRecursosSuficientesException;

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
