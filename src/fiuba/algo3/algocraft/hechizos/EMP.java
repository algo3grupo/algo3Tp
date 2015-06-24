package fiuba.algo3.algocraft.hechizos;

import fiuba.algo3.algocraft.Interfaces.IEfectoEMP;
import fiuba.algo3.algocraft.atributos.HechizoAreaDeEfecto;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;

public class EMP extends HechizoAreaDeEfecto {

	public EMP() {
		
		super(100, 15);
		
	}

	@Override
	public void afectar(Unidad unidad) {
		
		if (unidad instanceof IEfectoEMP){
			((IEfectoEMP) unidad).atacadoPorEMP();
		}
		
	}
	

}
