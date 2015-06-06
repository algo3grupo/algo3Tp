package fiuba.algo3.algocraft.creadores;

import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEntidadException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class CreadorEstructuras extends Creador {
		
	public Estructura crearEstructura(String string,Vector2D posicion, Mundo mundo) throws NoEsDeSuRazaLaEstructuraException, 
																					NoTieneLaEstructuraCreadaException, 
																					NoTieneRecursosSuficientesException,
																					NoHayMineralEnElLugarACrear,
																					NoHayGasEnElLugarACrear{
		
		try {
			Estructura estructura = (Estructura)crearEntidad(string, posicion, null);
			if(estructura instanceof IRecolectores){
				
				if (( (estructura.nombre() == "Centro De Minerales") || (estructura.nombre()  == "Nexo Mineral") ) 
														& (! mundo.hayMineral(posicion))){
					estructura.getJugador().reintegroCosto(estructura);
					throw new NoHayMineralEnElLugarACrear();
				}
				else if (((estructura.nombre()  == "Refineria") || (estructura.nombre()  == "Asimilador") ) 	
												& (! mundo.hayGas(posicion))){
					estructura.getJugador().reintegroCosto(estructura);
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
