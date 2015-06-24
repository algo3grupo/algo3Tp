package fiuba.algo3.algocraft.atributos;

public class VidaConEscudo extends Vida {
	private int escudo;
	private int valorMaximo;

	public VidaConEscudo(int valor, int escudo) {
		super(valor);
		this.escudo = escudo;
		this.valorMaximo= escudo;
	}
	
	public void recuperarCampo() 
	{
		if (escudo < valorMaximo)
		{
			escudo += 10;	
		}
	}
	
	private int herirCampo(int danio) {

		if(escudo - danio < 0)
		{
			int sobrante = -(escudo-danio);
			escudo = 0;
			return  sobrante;
		}
		else
		{
			escudo -= danio;
			return 0;
		}
	}
	
	public void herir(int danio){
		
		int danioSobrante = herirCampo(danio);
		super.herir(danioSobrante);
	}
	
	public void desactivarEscudo(){
		escudo = 0;
	}
	
	public boolean tieneEscudo() {
		
		return true;
	}
	
	
	public int obtenerEscudoActual()
	{
		return escudo;
	}
	
	public int obtenerEscudoMaximo()
	{
		return valorMaximo;
	}
	
	public void modificarVida(int vida, int escudo){
		
	}
	
	public boolean estaMuerta(){
		if ( (vidaMaxima()== 0) & (escudo == 0)){
			//caso copia
			return true;
		}
		return super.estaMuerta();
	}
}
