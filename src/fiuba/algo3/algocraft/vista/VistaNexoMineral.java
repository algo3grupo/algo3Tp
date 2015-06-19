package fiuba.algo3.algocraft.vista;

import java.awt.Graphics;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public class VistaNexoMineral extends VistaEntidad {
	
	public void dibujar(Graphics contexto, Entidad entidad) 
	{
		dibujarImagen(contexto,"recursos/nexo mineral (protoss).png", entidad.obtenerPosicion(), entidad.obtenerDimension(),entidad.obtenerDimension());
	}


}
