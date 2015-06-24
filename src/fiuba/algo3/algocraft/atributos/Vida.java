package fiuba.algo3.algocraft.atributos;

public class Vida {
	private int vida;
	private int vidaMaxima;
	
	public Vida(int valor){
		vida=valor;	
		vidaMaxima=valor;
	}

	public int VidaMaxima() {
		
		return vidaMaxima;
	}

	public int vidaActual() {
		
		return vida;
	}
	
	public void herir(int danio){
		vida-=danio;
		if (vida < 0){
			vida = 0;
		}
	}
	
	public boolean estaMuerta(){
		
		return (vida == 0);
	}

	public boolean tieneEscudo() {
		
		return false;
	}

	public void desactivarEscudo() {
	}
	
	public int obtenerEscudoMaximo()
	{
		return 0;
	}
	
	public int obtenerEscudoActual()
	{
		return 0;
	}
}
