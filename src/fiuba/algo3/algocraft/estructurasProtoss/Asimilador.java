package fiuba.algo3.algocraft.estructurasProtoss;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Protegidas;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Asimilador extends Protegidas implements IRecolectores {
	
	public Asimilador(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 450, 0, jugador, "Asimilador", new Costo(50,0), "", 8);
		
		agregarAccion(new RecogerSuministro(this));
	}
	
	public void recolectarSuministro()
	{
		
		getJugador().agregarMineral(10);
	}


	public void dibujar(Graphics contexto) 
	{
		dibujarImagen(contexto,"recursos/asimilador (protoss).png", obtenerPosicion(),obtenerDimension(),obtenerDimension());		
	}

	
	
}
