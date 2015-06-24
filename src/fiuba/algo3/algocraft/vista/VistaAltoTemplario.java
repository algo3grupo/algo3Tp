package fiuba.algo3.algocraft.vista;

import java.awt.Graphics;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public class VistaAltoTemplario extends VistaEntidad
{
	
	public void dibujarApariencia(Graphics contexto, Entidad entidad) 
	{
		Dibujar.dibujarImagen(contexto,"recursos/alto templario (protoss).png", entidad.obtenerPosicion(), entidad.obtenerDimension(),entidad.obtenerDimension());
	}


}
