package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;

public class RecogerSuministro implements IAccion
{

		IRecolectores llamador;
		
		public RecogerSuministro(IRecolectores llamador)
		{
			this.llamador = llamador;
		}
		
		public void ejecutar(IColaDeAcciones ejecutor)
		{
			this.llamador.recolectarSuminstro();
		}
}

