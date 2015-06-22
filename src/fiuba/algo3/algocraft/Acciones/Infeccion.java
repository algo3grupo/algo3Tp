package fiuba.algo3.algocraft.Acciones;

import java.util.ArrayList;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;

public class Infeccion implements IAccion {
	private int rango;
	private int danio;
	
	public Infeccion( int rango, int danio ){
		
		this.rango = rango;
		this.danio = danio;
		
	}
	
	

	private void radiacion(Unidad unidad){
		//busca las unidades a su alrededor y las dania
		ArrayList<Unidad> unidades= (ArrayList<Unidad>)unidad.getJugador().getMundo().obtenerUnidadesEnZona(unidad.obtenerPosicion(), rango);
		for ( int i = 0; i < unidades.size() ; i++){
			unidades.get(i).herir(danio);
		}
		
	}
	
	
	public void ejecutar(IColaDeAcciones unidad) {
		
		radiacion((Unidad) unidad);

	}

}
