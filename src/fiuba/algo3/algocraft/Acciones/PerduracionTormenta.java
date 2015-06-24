package fiuba.algo3.algocraft.Acciones;

import fiuba.algo3.algocraft.Interfaces.IAccion;
import fiuba.algo3.algocraft.Interfaces.IColaDeAcciones;
import fiuba.algo3.algocraft.hechizos.TormentaPsiconica;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class PerduracionTormenta implements IAccion {
	private int turnos = 0;
	private TormentaPsiconica tormenta;
	private Mundo mundo;
	private Vector2D centro;
	
	public PerduracionTormenta(Vector2D centro,Mundo mundo, TormentaPsiconica tormenta){
		
		this.centro = centro;
		this.mundo = mundo;
		this.tormenta = tormenta;
		
	}
	
	@Override
	public void ejecutar(IColaDeAcciones llamador) {
		turnos ++;

		tormenta.lanzarHechizoA(null,centro, mundo);
		if (turnos == 2){
			llamador.QuitarAccion(this);
		}
	}

}
