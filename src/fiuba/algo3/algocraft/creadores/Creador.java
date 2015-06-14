package fiuba.algo3.algocraft.creadores;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEntidadException;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Creador {
	/**Crea la entidad pedida corroborando
	 * -es de la raza del jugador
	 * -tiene la estructura que requiere
	 * -tiene los recursos necesarios
	 * -hay gas o mineral en el lugar si se trata de un recolector */
	
	protected ArrayList<Entidad> entidades;
	protected Creador(){
		this.entidades = new ArrayList<Entidad>(); 
	}
	
	public Entidad crearEntidad(String string,Vector2D posicion,Mundo mundo) throws NoEsDeSuRazaLaEntidadException, 
																					NoTieneLaEstructuraCreadaException, 
																					NoTieneRecursosSuficientesException,
																					ErrorAlHacerCopia
																					{
		
		for ( int i = 0; i < entidades.size(); i++) {
			if( (entidades.get(i).nombre() == string) ){
				Entidad entidad = entidades.get(i);
				if (! entidad.estaLaEstructuraCreada(entidad.getJugador().obtenerEstructuras())){
					throw new NoTieneLaEstructuraCreadaException();
				}
				gastar(entidad);
				try {
					//La copia es realizada por medio de reflexion
					Constructor constructor = entidad.getClass().getConstructor(Vector2D.class, Jugador.class);
					Entidad copia = (Entidad)constructor.newInstance(posicion, entidad.getJugador());
					return copia;
				} catch (NoSuchMethodException | SecurityException
						|InstantiationException 
						| IllegalAccessException
						| IllegalArgumentException
						| InvocationTargetException e) {
					throw new ErrorAlHacerCopia();
				}
				
			}
		}
		throw new NoEsDeSuRazaLaEntidadException();
	}
	
	private void gastar( Entidad entidad) throws NoTieneRecursosSuficientesException{
		
		Jugador jugador = entidad.getJugador();
		Costo costo = entidad.costo();
		if( ( costo.minerales()<=jugador.getMinerales() ) && ( costo.gas()<=jugador.gas()) ){
			jugador.pagar(costo);
			return;
		}
		
		throw new NoTieneRecursosSuficientesException();
	}
	
	
}