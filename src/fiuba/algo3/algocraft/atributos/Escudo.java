package fiuba.algo3.algocraft.atributos;

public class Escudo {
	//aberracion para que las unidades protoss tengan escudo
	private int campo;
	private int limiteCampo;
	
	public Escudo(int vida){
		campo = vida;
		limiteCampo = vida;
	}
	
	public void recuperarCampo() 
	{
		if (campo < limiteCampo)
		{
			campo += 10;	
		}
	}
	 

	public int herirCampo(int danio) {
		if (campo - danio < 0 ){
			campo = 0;
			return danio - campo;
		}
		campo -= danio;
		return 0;
	}

	public int valorCampo(){
		return campo;
	}
	public boolean util() {
		if (limiteCampo == 0){
			return false;
		}
		return true;
	}

	public void tomarValor(int valor) {
		campo = valor;
		limiteCampo = valor;
	}

}
