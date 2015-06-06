package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;

public class RecuperarCampo implements IAccion {
	
	Protegidas llamador;
	
	public RecuperarCampo(Protegidas llamador)
	{
		this.llamador = llamador;
	}
	
	public void ejecutar(IColaDeAcciones llamador)
	{
		this.llamador.recuperarCampo();
	}
}
