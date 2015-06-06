package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;

public class CrearUnidad implements IAccion
{
	
	private char turnos;
	
	public CrearUnidad()
	{
		
	}
	
	public void ejecutar(IColaDeAcciones ejecutor)
	{
		turnos--;
		
		if(turnos == 0)
		{
			//se crea la unidad
			ejecutor.QuitarAccion(this);
		}
	}

}
