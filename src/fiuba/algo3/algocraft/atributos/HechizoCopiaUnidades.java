package fiuba.algo3.algocraft.atributos;

import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class HechizoCopiaUnidades extends Hechizo {

	public HechizoCopiaUnidades(int costo) {
		super(costo);
	}
	
	public void copiarAlMapa(Unidad unidad){
		
		Unidad copia = nuevaUnidadCopia(unidad);
		unidad.getJugador().ObtenerUnidades().add(copia);
		
	}
	
	public void lanzarHechizoA(Vector2D posicion, Mundo mundo){
		
		
	}
	
	private Unidad nuevaUnidadCopia(Unidad unidad) {
		return null;
	}
}
