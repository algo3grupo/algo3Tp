package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Hechizo;
import fiuba.algo3.algocraft.excepciones.NoTieneEnergiaSuficiente;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class UnidadEnergia extends Unidad {
	private int energia;
	
	public UnidadEnergia( int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int suministro,
			int transporte) {
		super( vida, rangoDeVision, jugador, nombre, costo, requiere, suministro, transporte);
		this.energia = 50;
	}
	
	public void lanzarHechizo(Hechizo hechizo, Vector2D posicion, Mundo mundo) throws NoTieneEnergiaSuficiente{
		
		if (tieneEnergiaSuficiente(hechizo.obtenerCosto())){
			hechizo.lanzarHechizoA(posicion, mundo);
			gastarEnergia(hechizo.obtenerCosto());	
		}else{
			throw new NoTieneEnergiaSuficiente();
		}
		
	}
	
	public void cargarEnergia(int i){
		
		if (energia+i > 200){
			energia = 200;
		}
		else {
			energia += i;
		}
	}
	
	public void gastarEnergia(int i){
		
			energia-=i;
		
	}

	private boolean tieneEnergiaSuficiente(int i) {
		
		return (energia - i > 0);
		
	}
}
