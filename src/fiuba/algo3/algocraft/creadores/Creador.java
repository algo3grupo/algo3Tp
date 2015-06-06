package fiuba.algo3.algocraft.creadores;

import java.util.ArrayList;

import fiuba.algo3.algocraft.atributosEntidades.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEntidadException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
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
																					NoTieneRecursosSuficientesException
																					{
		
		for ( int i = 0; i < entidades.size(); i++) {
			if( (entidades.get(i).nombre() == string) ){
				Entidad entidad = entidades.get(i);
				if (entidad.requiere()!=""){
					entidad.estaLaEstructuraCreada(entidad.jugador().obtenerEstructuras());
				}
				gastar(entidad);
				return entidad;
			}
		}
		throw new NoEsDeSuRazaLaEntidadException();
	}
	
	private void gastar( Entidad entidad) throws NoTieneRecursosSuficientesException{
		
		Jugador jugador = entidad.jugador();
		Costo costo = entidad.costo();
		if( ( costo.minerales()<=jugador.getMinerales() ) && ( costo.gas()<=jugador.gas()) ){
			jugador.pagar(costo);
			return;
		}
		
		throw new NoTieneRecursosSuficientesException();
	}
	
}