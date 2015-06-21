package fiuba.algo3.algocraft.vector2D;

import java.util.ArrayList;

public class Vector2D {
	
	private double x;
	private double y;
	private double norma;

	public Vector2D(double posicionX, double posicionY) 
	{
		if(posicionX == 0 && posicionY == 0)
		{
			x = 0;
			y = 0;
			norma = 0;
		}
		else
		{
			norma = Math.sqrt(posicionX*posicionX+posicionY*posicionY);
			x = posicionX/norma;
			y = posicionY/norma;
		}
	}

	public Vector2D(Vector2D vector) 
	{
		x = vector.x;
		y = vector.y;
		norma = vector.norma;
	}

	public Vector2D() 
	{
		x = 0;
		y = 0;
		norma = 0;
	}

	public double distanciaA(Vector2D posicion) 
	{
		return Math.sqrt(Math.pow(posicion.obtenerCoordenadaX()-x*norma, 2) + Math.pow(posicion.obtenerCoordenadaY()-y*norma,2));		
	}

	public double obtenerCoordenadaX() 
	{
		return x*norma;
	}

	public double obtenerCoordenadaY() 
	{
		return y*norma;
	}

	public Vector2D aleatorio(double limiteInferiorX, double limiteSuperiorX, double limiteInferiorY, double limiteSuperiorY) 
	{
		x = Math.random()*(limiteSuperiorX-limiteInferiorX)+limiteInferiorX;
		y = Math.random()*(limiteSuperiorY-limiteInferiorY)+limiteInferiorY;
		
		if(x==0 && y==0)
			norma = 0;
		else
		{
			norma = Math.sqrt(x*x+y*y);
			x /= norma;
			y /= norma;		
		}
		
		return this;
	}
	
	public boolean distintoA(Vector2D vector)
	{
		if(x != vector.x || y != vector.y || norma != vector.norma)
			return true;
		return false;
		
	}

	public ArrayList<Vector2D> dividirSegunLongitud(int longitud)
	{
		ArrayList<Vector2D> resultado = new ArrayList<Vector2D>();
		Vector2D aux = new Vector2D();
		int i = 1;
		
		while(aux.distintoA(this))
		{
			aux = new Vector2D(this);
			
			if(getNorma() > i*longitud)
				aux.setNorma(i++*longitud);
			
			resultado.add(aux);			
		}
		
		return resultado;
	}

	public void setNorma(double norma) 
	{
		this.norma = norma;		
	}

	public double getNorma()
	{
		return norma;
	}

	public Vector2D restarA(Vector2D vector) 
	{
		return new Vector2D(obtenerCoordenadaX()-vector.obtenerCoordenadaX(),obtenerCoordenadaY()-vector.obtenerCoordenadaY());
	}

	public Vector2D sumarA(Vector2D vector) 
	{
		return new Vector2D(vector.obtenerCoordenadaX()+obtenerCoordenadaX(),vector.obtenerCoordenadaY()+obtenerCoordenadaY()); 		
	}
	
	public boolean perteneceA(Vector2D supizq, int dimension)
	{
		if(this.obtenerCoordenadaX() > supizq.obtenerCoordenadaX() &&  this.obtenerCoordenadaX() < supizq.obtenerCoordenadaX() + dimension)
			if(this.obtenerCoordenadaY() > supizq.obtenerCoordenadaY() &&  this.obtenerCoordenadaY() < supizq.obtenerCoordenadaY() + dimension)
			return true;
		return false;
	}
}
