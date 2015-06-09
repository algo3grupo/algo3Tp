package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public class ModoNombre implements IModo {
	private String nombre;
	
	public ModoNombre(String nombre){
		this.nombre = nombre;
	}
	
	public boolean compara(Entidad entidad) {
	
		return (entidad.nombre() == nombre);
	}

}
