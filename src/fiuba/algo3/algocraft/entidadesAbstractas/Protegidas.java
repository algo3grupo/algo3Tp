package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.Acciones.RecuperarCampo;
import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class Protegidas extends Estructura 
{
	private int campo;
	private int limiteCampo;
	
	public Protegidas(Estructura estructura)
	{
		super(estructura);
				
		this.agregarAccion(new RecuperarCampo(this));
	}

	public Protegidas(Jugador jugador) {
		super(jugador);
	}

	public void recuperarCampo() 
	{
		if (campo < limiteCampo)
		{
			campo += 10;	
		}
	}
	
	public void inicializarCampoYLimiteCampo(int limite)
	{
		this.limiteCampo = limite;
		this.campo = limite;
	}
}
