package fiuba.algo3.algocraft.creadores;

import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEntidadException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class CreadorUnidades extends Creador {
	
	public Unidad crearUnidad(JFrame ventana, String string) throws NoEsDeSuRazaLaUnidadException,
																					NoTieneLaEstructuraCreadaException,
																					NoTieneRecursosSuficientesException,
																					ErrorAlHacerCopia{
		try {
			
			return (Unidad)crearEntidad(ventana, string, new Vector2D(), null);
			
		} catch (NoEsDeSuRazaLaEntidadException e) {
			throw new NoEsDeSuRazaLaUnidadException();
		} catch (NoTieneLaEstructuraCreadaException
				| NoTieneRecursosSuficientesException e){
			throw e;
		}
	}
}
