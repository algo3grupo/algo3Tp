package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.excepciones.NoTieneEnergiaSuficiente;
import fiuba.algo3.algocraft.jugador.Jugador;

public class UnidadEnergia extends Unidad {
	private int energia;
	
	public UnidadEnergia( int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int suministro,
			int transporte) {
		super( vida, rangoDeVision, jugador, nombre, costo, requiere, suministro, transporte);
		this.energia = 50;
	}
	
	public void cargarEnergia(int i){
		
		if (energia+i > 200){
			energia = 200;
		}
		else {
			energia += i;
		}
	}
	
	public void gastarEnergia(int i) throws NoTieneEnergiaSuficiente{
		if (tieneEnergiaSuficiente(i)){
			energia-=i;
		}
		else{
			throw new NoTieneEnergiaSuficiente();
		}
	}

	private boolean tieneEnergiaSuficiente(int i) {
		
		return (energia - i > 0);
		
	}
}
