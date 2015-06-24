package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;

public class RecuperarEscudo implements IAccion {

	
	private Unidad protegida;
	
	public RecuperarEscudo(Unidad llamador)
	{
		this.protegida = llamador;
	}
	
	
	@Override
	public void ejecutar(IColaDeAcciones llamador) {
		
		protegida.recuperarEscudo();

	}

}
