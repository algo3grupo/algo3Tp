package fiuba.algo3.algocraft.hechizos;

import fiuba.algo3.algocraft.atributos.HechizoAreaDeEfecto;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;

public class TormentaPsiconica extends HechizoAreaDeEfecto {
	
	// deberia quedarse en el mundo y afectar por dos turnos
	
	public TormentaPsiconica() {
		
		super(75, 5);

	}

	@Override
	public void afectar(Unidad unidad) {
		
		unidad.daniar(50);
		
	}

}
