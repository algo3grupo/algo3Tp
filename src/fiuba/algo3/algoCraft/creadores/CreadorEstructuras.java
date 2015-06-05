package fiuba.algo3.algoCraft.creadores;

import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.entidadesAbstractas.Recolectores;
import fiuba.algo3.algoCraft.excepciones.NoEsDeSuRazaLaEntidadException;
import fiuba.algo3.algoCraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algoCraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algoCraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algoCraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algoCraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algoCraft.mundo.Mundo;
import fiuba.algo3.algoCraft.vector2D.Vector2D;

public abstract class CreadorEstructuras extends Creador {
		
	public Estructura crearEstructura(String string,Vector2D posicion, Mundo mundo) throws NoEsDeSuRazaLaEstructuraException, 
																					NoTieneLaEstructuraCreadaException, 
																					NoTieneRecursosSuficientesException,
																					NoHayMineralEnElLugarACrear,
																					NoHayGasEnElLugarACrear{
		
		try {
			Estructura estructura = (Estructura)crearEntidad(string, posicion, null);
			if(estructura instanceof Recolectores){
				
				if (( (estructura.nombre() == "Centro De Minerales") || (estructura.nombre()  == "Nexo Mineral") ) 
														& (! mundo.hayMineral(posicion))){
					estructura.jugador().reintegroCosto(estructura);
					throw new NoHayMineralEnElLugarACrear();
				}
				else if (((estructura.nombre()  == "Refineria") || (estructura.nombre()  == "Asimilador") ) 	
												& (! mundo.hayGas(posicion))){
					estructura.jugador().reintegroCosto(estructura);
					throw new NoHayGasEnElLugarACrear();
				}
			}
			return estructura;
		} catch (NoEsDeSuRazaLaEntidadException e) {
			throw new NoEsDeSuRazaLaEstructuraException() ;
		} catch (NoTieneLaEstructuraCreadaException
				| NoTieneRecursosSuficientesException e){
			throw e;
		}
		
	}

}
