package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class UnidadAtaqueBasico extends Unidad {
	
	private int ataqueT;

	public UnidadAtaqueBasico(int ID, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int suministro, int ataqueT) 
	{
		super(ID, vida, rangoDeVision, jugador, nombre, costo, requiere, suministro);
		this.ataqueT = ataqueT;
	}

}
