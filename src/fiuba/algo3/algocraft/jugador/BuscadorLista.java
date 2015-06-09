package fiuba.algo3.algocraft.jugador;

import java.util.ArrayList;

import fiuba.algo3.algocraft.IModo;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEstructura;

public abstract class BuscadorLista {
	
	public static Entidad obtenerEntidad(ArrayList entidades, IModo modo) throws NoSeEncontroLaEstructura{
		for (int i=0; i < entidades.size(); i++)
		{
			if (modo.compara((Entidad)entidades.get(i))){
				
				return (Entidad) entidades.get(i);
			}
		}
		throw new NoSeEncontroLaEstructura();
	}
}
