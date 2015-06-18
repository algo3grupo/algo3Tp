package fiuba.algo3.algocraft.Interfaces;

import java.util.ArrayList;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;

public interface IUnidad {
	
	public ArrayList<String> mostrarAcciones();
	public void realizarAccion(String accion, Entidad destino) throws NoPuedeRealizarEsaAccion;

}
