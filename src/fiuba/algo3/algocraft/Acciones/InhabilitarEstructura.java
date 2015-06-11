package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;

public class InhabilitarEstructura implements IAccion {


	public void ejecutar(IColaDeAcciones llamador) {
		
		Estructura estructura = (Estructura) llamador;
		estructura.disminuirTurno();
		
		if (estructura.turnosEnCrear() == 0){
			estructura.QuitarAccion(this);
		}

	}

}
