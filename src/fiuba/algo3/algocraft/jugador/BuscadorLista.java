package fiuba.algo3.algocraft.jugador;

import java.util.ArrayList;

import fiuba.algo3.algocraft.IModo;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEstructura;

public abstract class BuscadorLista {
	
	public static Entidad obtenerEntidad(ArrayList entidades, IModo modo) throws NoSeEncontroLaEstructura{
		for (int i=0; i < entidades.size(); i++){
			//devuelve la entidad si esta existe y esta habilitada(turnos=0)
			if (modo.compara((Entidad)entidades.get(i)) && (((Entidad) entidades.get(i)).estaHabilitada())){
				
				return (Entidad) entidades.get(i);
			}
		}
		throw new NoSeEncontroLaEstructura();
	}
}
