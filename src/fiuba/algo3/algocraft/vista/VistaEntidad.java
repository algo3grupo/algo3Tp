package fiuba.algo3.algocraft.vista;

import java.awt.Graphics;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public abstract class VistaEntidad extends Dibujable {
	
	public abstract void dibujar(Graphics g, Entidad entidad);

}
