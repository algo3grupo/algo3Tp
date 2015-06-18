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

	public Protegidas(int dimension, Vector2D posicion, int vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int turnos) {
		super(dimension, posicion, vida, rangoDeVision, jugador, nombre, costo, requiere, turnos);
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
	 public void herir(int danio){
		 int danioSobrante = herirCampo(danio);
		 super.herir(danioSobrante);
		 
	 }

	private int herirCampo(int danio) {
		if (campo - danio < 0 ){
			return danio-campo;
		}
		return 0;
	}
	
}
