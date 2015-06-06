package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;

public class CrearUnidad implements IAccion
{
	
	char turnos;
	
	public CrearUnidad()
	{
		
	}
	
	public void ejecutar(IColaDeAcciones llamador)
	{
		turnos--;
		
		if(turnos == 0)
		{
			//se crea la unidad
			llamador.QuitarAccion(this);
		}
	}

}
