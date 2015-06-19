package fiuba.algo3.algocraft.vista;

import java.awt.Graphics;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public class VistaFabrica extends VistaEntidad {
	
	public void dibujar(Graphics contexto, Entidad entidad) 
	{
		dibujarImagen(contexto,"recursos/fabrica (terran).png", entidad.obtenerPosicion(), entidad.obtenerDimension(),entidad.obtenerDimension());
	}

}
