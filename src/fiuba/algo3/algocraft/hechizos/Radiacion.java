package fiuba.algo3.algocraft.hechizos;

import fiuba.algo3.algocraft.Acciones.Infeccion;
import fiuba.algo3.algocraft.atributos.HechizoSingular;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.NoEsPosibleLanzarElHechizoAlli;
import fiuba.algo3.algocraft.excepciones.NoHayUnidadEnEsaPosicion;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Radiacion extends HechizoSingular {

	public Radiacion() {
		super(75);
	}
	
	public void lanzarHechizoA(Vector2D posicion, Mundo mundo) throws NoEsPosibleLanzarElHechizoAlli{
		
		try {
			hechizar( mundo.obtenerUnidadEn(posicion) );
		} catch (NoHayUnidadEnEsaPosicion e) {
			throw new NoEsPosibleLanzarElHechizoAlli();
		}
		
	}
	
	 public void hechizar(Unidad unidad){
		 unidad.agregarAccion(new Infeccion(1, 20));
	 }
}
