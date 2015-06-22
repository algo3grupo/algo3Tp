package fiuba.algo3.algocraft.creadores;


import javax.swing.JFrame;

import fiuba.algo3.algocraft.Acciones.AumentarPoblacion;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEntidadException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHaySuministroEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class CreadorEstructuras extends Creador {
		
	public Estructura crearEstructura(String string,Vector2D posicion, Mundo mundo) throws NoEsDeSuRazaLaEstructuraException, 
																					NoTieneLaEstructuraCreadaException, 
																					NoTieneRecursosSuficientesException,
																					ErrorAlHacerCopia, NoHaySuministroEnElLugarACrear{
		
		try {
			Estructura estructura = (Estructura)crearEntidad(string, posicion, mundo) ;
			
			if (estructura instanceof IRecolectores){
				if ( ! ((IRecolectores) estructura).haySuministroEn(posicion) ){
					throw new NoHaySuministroEnElLugarACrear();
				}
			}
			return estructura;
			
		} catch (NoEsDeSuRazaLaEntidadException e) {
			throw new NoEsDeSuRazaLaEstructuraException() ;
		} 
	}

}


