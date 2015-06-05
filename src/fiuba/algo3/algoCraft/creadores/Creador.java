package fiuba.algo3.algoCraft.creadores;

import java.util.ArrayList;

import fiuba.algo3.algoCraft.atributosEntidades.Costo;
import fiuba.algo3.algoCraft.entidadesAbstractas.EntidadAbstracta;
import fiuba.algo3.algoCraft.excepciones.NoEsDeSuRazaLaEntidadException;
import fiuba.algo3.algoCraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algoCraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algoCraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algoCraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algoCraft.jugador.Jugador;
import fiuba.algo3.algoCraft.mundo.Mundo;
import fiuba.algo3.algoCraft.vector2D.Vector2D;

public abstract class Creador {
	/**Crea la entidad pedida corroborando
	 * -es de la raza del jugador
	 * -tiene la estructura que requiere
	 * -tiene los recursos necesarios
	 * -hay gas o mineral en el lugar si se trata de un recolector */
	
	protected ArrayList<EntidadAbstracta> entidades;
	protected Creador(){
		this.entidades = new ArrayList<EntidadAbstracta>(); 
	}
	
	public EntidadAbstracta crearEntidad(String string,Vector2D posicion,Mundo mundo) throws NoEsDeSuRazaLaEntidadException, 
																					NoTieneLaEstructuraCreadaException, 
																					NoTieneRecursosSuficientesException
																					{
		
		for ( int i = 0; i < entidades.size(); i++) {
			if( (entidades.get(i).nombre() == string) ){
				EntidadAbstracta entidad = entidades.get(i);
				if (entidad.requiere()!=""){
					entidad.estaLaEstructuraCreada(entidad.jugador().obtenerEstructuras());
				}
				gastar(entidad);
				return entidad;
			}
		}
		throw new NoEsDeSuRazaLaEntidadException();
	}
	
	private void gastar( EntidadAbstracta entidad) throws NoTieneRecursosSuficientesException{
		
		Jugador jugador = entidad.jugador();
		Costo costo = entidad.costo();
		if( ( costo.minerales()<=jugador.getMinerales() ) && ( costo.gas()<=jugador.gas()) ){
			jugador.pagar(costo);
			return;
		}
		
		throw new NoTieneRecursosSuficientesException();
	}
	
}