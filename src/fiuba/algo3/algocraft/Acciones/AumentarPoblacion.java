package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;

public class AumentarPoblacion implements IAccion {
	private Estructura estructura;
	
	public AumentarPoblacion(Estructura estructura){
		this.estructura = estructura;
	}
	public void ejecutar(IColaDeAcciones llamador) {
		estructura.actualizarPoblacion();
		llamador.QuitarAccion(this);

	}

}
