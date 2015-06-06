package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;

public abstract class colaDeAcciones implements IColaDeAcciones{
	
	ArrayList<IAccion> colaDeAcciones;
	
	public colaDeAcciones()
	{
		colaDeAcciones = new ArrayList<IAccion>();
	}
	
	public void agregarAccion(IAccion accion)
	{
		colaDeAcciones.add(accion);
	}
	
	public void QuitarAccion(IAccion accion)
	{
		for(int i=0;i<colaDeAcciones.size();i++)
			if(colaDeAcciones.get(i) == accion)
				colaDeAcciones.remove(i);		
	}
	
	public void ejecutarAcciones()
	{
		for(int i=0;i<colaDeAcciones.size();i++)
			colaDeAcciones.get(i).ejecutar(this);		
	}

}
