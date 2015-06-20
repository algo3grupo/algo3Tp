package fiuba.algo3.algocraft.vista;

import java.awt.Graphics;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public class VistaCentroDeMineral extends VistaEntidad {
	
	
	public void dibujarApariencia(Graphics contexto, Entidad entidad) 
	{
		dibujarImagen(contexto,"recursos/centro de minerales (terran).png", entidad.obtenerPosicion(), entidad.obtenerDimension(),entidad.obtenerDimension());
	}


}
