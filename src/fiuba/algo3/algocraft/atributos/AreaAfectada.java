package fiuba.algo3.algocraft.atributos;

import fiuba.algo3.algocraft.vector2D.Vector2D;

public class AreaAfectada {
	
	private int radio;
	private Vector2D centro;
	private int turnos;
	
	public boolean actualizar()
	{
		if(--turnos == 0)
			return true;
		return false;
		
	}

	public AreaAfectada(Vector2D centro, int radio, int turnos)
	{
		this.centro = centro;
		this.radio = radio;
		this.turnos = turnos;
	}
	
	public int obtenerRadio()
	{
		return radio;
	}
	
	public Vector2D obtenerCentro()
	{
		return centro;
	}
}
