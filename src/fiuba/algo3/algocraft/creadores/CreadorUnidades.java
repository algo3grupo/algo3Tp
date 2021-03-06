package fiuba.algo3.algocraft.creadores;

import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEntidadException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.mundo.Mundo;

public abstract class CreadorUnidades extends Creador {
	
	public Unidad crearUnidad(String string, Mundo mundo, Estructura estructura) throws NoEsDeSuRazaLaUnidadException,
																					NoTieneLaEstructuraCreadaException,
																					NoTieneRecursosSuficientesException,
																					ErrorAlHacerCopia{
		try {
			
			return (Unidad)crearEntidad(string, estructura.obtenerPuntoDeCreacion(), mundo);
			
		} catch (NoEsDeSuRazaLaEntidadException e) {
			throw new NoEsDeSuRazaLaUnidadException();
		} catch (NoTieneLaEstructuraCreadaException
				| NoTieneRecursosSuficientesException e){
			throw e;
		}
	}
}
