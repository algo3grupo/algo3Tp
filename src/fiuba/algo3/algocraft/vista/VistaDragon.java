package fiuba.algo3.algocraft.vista;

import java.awt.Graphics;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public class VistaDragon extends VistaEntidad
{
	
	public void dibujarApariencia(Graphics contexto, Entidad entidad) 
	{
		Dibujar.dibujarImagen(contexto,"recursos/dragon (protoss).png", entidad.obtenerPosicion(), entidad.obtenerDimension(),entidad.obtenerDimension());
	}


}
