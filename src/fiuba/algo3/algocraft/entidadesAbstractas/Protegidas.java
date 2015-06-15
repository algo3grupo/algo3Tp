package fiuba.algo3.algocraft.entidadesAbstractas;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Acciones.RecuperarCampo;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class Protegidas extends Estructura
{
	private int campo;
	private int limiteCampo;
	
	public Protegidas(Estructura estructura)
	{
		super(estructura);
				
		this.agregarAccion(new RecuperarCampo(this));
	}

	public Protegidas(int dimension, JFrame ventana,  Vector2D posicion, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int turnos) {
		super(dimension, ventana, posicion, vida, rangoDeVision, jugador, nombre, costo, requiere, turnos);
		this.campo = vida;
		this.limiteCampo = vida;
	}

	public void recuperarCampo() 
	{
		if (campo < limiteCampo)
		{
			campo += 10;	
		}
	}
	
	
}
