package fiuba.algo3.algocraft.vista;

import java.awt.Graphics;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;

public class VistaPuertoEstelar extends VistaEntidad {
	
	public void dibujarApariencia(Graphics contexto, Entidad entidad) 
	{
		if(entidad.estaHabilitada())
			Dibujar.dibujarImagen(contexto,"recursos/puerto estelar (protoss).png", entidad.obtenerPosicion(), entidad.obtenerDimension(),entidad.obtenerDimension());
		else
		{
			Dibujar.dibujarRectanguloVacio(contexto, entidad.obtenerPosicion(), entidad.obtenerDimension(), entidad.obtenerDimension());
			Dibujar.escribirTexto(contexto,entidad.obtenerPosicion(),entidad.nombre()+" en construccion");
		}
	}

}
