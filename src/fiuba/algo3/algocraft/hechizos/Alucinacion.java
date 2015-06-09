package fiuba.algo3.algocraft.hechizos;

import fiuba.algo3.algocraft.atributos.HechizoCopiaUnidades;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.unidadesProtoss.UnidadCopia;

public class Alucinacion extends HechizoCopiaUnidades {

	public Alucinacion() {
		super(100);
		}
	
	public Unidad nuevaUnidadCopia(Unidad unidad){
		Unidad copia = new UnidadCopia( unidad );
		return copia;
	}
	

}
