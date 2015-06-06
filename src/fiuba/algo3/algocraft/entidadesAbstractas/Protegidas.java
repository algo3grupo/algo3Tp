package fiuba.algo3.algocraft.entidadesAbstractas;

import fiuba.algo3.algocraft.Acciones.RecuperarCampo;
import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class Protegidas extends Estructura 
{
	private int campo;
	
	public Protegidas(Estructura estructura)
	{
		super(estructura);
		
		campo = 100;		
		this.agregarAccion(new RecuperarCampo(this));
	}

	public Protegidas(Jugador jugador) {
		super(jugador);
	}

	public void recuperarCampo() 
	{
		campo += 10;	
	}

}
