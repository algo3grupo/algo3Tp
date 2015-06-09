package fiuba.algo3.algocraft.hechizos;

import fiuba.algo3.algocraft.Acciones.Infeccion;
import fiuba.algo3.algocraft.atributos.HechizoSingular;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;

public class Radiacion extends HechizoSingular {

	public Radiacion() {
		super(75);
	}
	 public void hechizar(Unidad unidad){
		 unidad.agregarAccion(new Infeccion(1, 20));
	 }
}
