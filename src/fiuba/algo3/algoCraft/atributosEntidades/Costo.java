package fiuba.algo3.algoCraft.atributosEntidades;

public class Costo {
	private int mineral;
	private int gas;
	
	public Costo(int mineral, int gas) {
		this.mineral = mineral;
		this.gas = gas;
	}

	public int minerales() {
		return mineral;
	}
	
	public int gas(){
		return gas;
	}
	

}
