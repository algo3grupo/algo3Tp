package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;

public class CargarEnergia implements IAccion {
	private UnidadEnergia mago;
	
	public CargarEnergia(UnidadEnergia mago){
		this.mago = mago;
	}
	
	@Override
	public void ejecutar(IColaDeAcciones llamador) {
		
		mago.cargarEnergia(10);

	}

}
