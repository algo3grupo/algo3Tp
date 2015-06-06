package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;

public class RecuperarCampo implements IAccion 
{
	
	private Protegidas llamador;
	
	public RecuperarCampo(Protegidas llamador)
	{
		this.llamador = llamador;
	}
	
	public void ejecutar(IColaDeAcciones ejecutor)
	{
		this.llamador.recuperarCampo();
	}
}
