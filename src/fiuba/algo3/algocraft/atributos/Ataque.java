package fiuba.algo3.algocraft.atributos;

public class Ataque {
	private int ataqueTierra;
	private int ataqueAereo;
	private int rangoAtaqueA;
	private int rangoAtaqueT;
	
	public Ataque(int ataqueT, int ataqueA, int rangoT, int rangoA){
		ataqueTierra = ataqueT;
		ataqueAereo = ataqueA;
		rangoAtaqueT = rangoT;
		rangoAtaqueA = rangoA;
	}
	
}
