package fiuba.algo3.algocraft.hechizos;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

import fiuba.algo3.algocraft.atributos.Hechizo;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.vector2D.Vector2D;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.excepciones.NoHayUnidadEnEsaPosicion;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.excepciones.NoLePerteneceLaEntidad;

public class Alucinacion extends Hechizo {
	// copia la unidad en la misma posicion que la copiada
	
	public Alucinacion() {
		super(100);
	}
	
	public void nuevaUnidadCopia(Unidad unidad, Vector2D posicion, Mundo mundo) throws NoSuchMethodException,
																SecurityException, InstantiationException, 
																IllegalAccessException, IllegalArgumentException, 
																InvocationTargetException, NoSuchFieldException{
		
		Constructor constructor = unidad.getClass().getConstructor(int.class, Vector2D.class, Jugador.class);
		UnidadAtaqueBasico copia = (UnidadAtaqueBasico)constructor.newInstance(mundo.obtenerDivisionDeGrilla(), posicion, unidad.getJugador());
		
		copia.obtenerAtaque().modificarAtaque(0,0);
		Field suministro = unidad.getClass().getField("suministro");
		suministro.setAccessible(true);
		suministro.set( (Object) unidad, 0);
		Field vida = unidad.getClass().getField("vida");
		suministro.setAccessible(true);
		suministro.set( (Object) unidad, new VidaConEscudo(0,100));
		copia.habilitar();
		unidad.getJugador().incorporarUnidad(copia);
		
		
	}

	@Override
	public void lanzarHechizoA(Jugador jugador,Vector2D posicion, Mundo mundo) {
		Unidad unidad;
		try {
			
			unidad = mundo.obtenerUnidadEn(posicion);
			if ( unidad.getJugador()==jugador ){
			nuevaUnidadCopia(unidad,posicion,mundo);
			}
			else throw new NoLePerteneceLaEntidad();
			
		} catch (NoHayUnidadEnEsaPosicion
				|NoSuchMethodException | SecurityException
				| InstantiationException | IllegalAccessException
				| IllegalArgumentException | InvocationTargetException
				| NoSuchFieldException | NoLePerteneceLaEntidad e) {
			
			e.printStackTrace();
		}
		
	}
	
	

}
