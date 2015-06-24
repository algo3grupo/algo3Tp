package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public class RecuperarCampo implements IAccion 
{
	
	private Entidad llamador;
	
	public RecuperarCampo(Entidad llamador)
	{
		this.llamador = llamador;
	}
	
	public void ejecutar(IColaDeAcciones ejecutor)
	{
		( (VidaConEscudo)this.llamador.getVida()).recuperarCampo();
	}
}
