package fiuba.algo3.algocraft.atributos;

import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.NoEsPosibleLanzarElHechizoAlli;
import fiuba.algo3.algocraft.excepciones.NoHayUnidadEnEsaPosicion;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class HechizoSingular extends Hechizo {

	public HechizoSingular(int costo) {
		super(costo);
	}
	

	public void lanzarHechizoA(Jugador jugador,Vector2D posicion, Mundo mundo) throws NoEsPosibleLanzarElHechizoAlli{
		Unidad unidad;
		try {
			unidad = mundo.obtenerUnidadEn(posicion);
		} catch (NoHayUnidadEnEsaPosicion e) {
			throw new NoEsPosibleLanzarElHechizoAlli();
		}
		if (unidad.getJugador()!=jugador){
			lanzarHechizoA(unidad);
		}
	}
	public void lanzarHechizoA(Unidad unidad){
		hechizar(unidad);
				
	}
	
	public abstract void hechizar(Unidad unidad);
	
}
