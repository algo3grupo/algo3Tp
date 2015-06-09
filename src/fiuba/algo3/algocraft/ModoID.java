package fiuba.algo3.algocraft;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public class ModoID implements IModo {
	private int ID;
	
	public ModoID(int id){
		ID = id;
	}
	
	public boolean compara(Entidad entidad) {
		
		return (entidad.ID()==ID);
	}

}
