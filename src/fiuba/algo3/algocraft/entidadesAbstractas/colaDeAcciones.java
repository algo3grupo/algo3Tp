package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class ColaDeAcciones extends Entidad implements IColaDeAcciones{
	
	ArrayList<IAccion> colaDeAcciones;
	
	public ColaDeAcciones(Entidad entidad)
	{
		super(entidad);
		
		colaDeAcciones = new ArrayList<IAccion>();
	}
	
	public ColaDeAcciones(Jugador jugador) {
		super(jugador);
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
