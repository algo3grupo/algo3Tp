package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class ColaDeAcciones extends Entidad implements IColaDeAcciones{
	
	private ArrayList<IAccion> colaDeAcciones;
	
	public ColaDeAcciones(Entidad entidad)
	{
		super(entidad);
		
		colaDeAcciones = new ArrayList<IAccion>();
	}
	
	public ColaDeAcciones(JFrame ventana, Vector2D posicion, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int turnos) {

		super(ventana, posicion, vida, rangoDeVision, jugador, nombre, costo, requiere, turnos);
		
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
	
	public void hacerMisAcciones()
	{
		ejecutarAcciones();
	}
	
	public void ejecutarAcciones()
	{
		for(int i=0;i<colaDeAcciones.size();i++)
			colaDeAcciones.get(i).ejecutar(this);		
	}

}
