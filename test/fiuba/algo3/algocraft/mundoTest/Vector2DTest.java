package fiuba.algo3.algocraft.mundoTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Vector2DTest {

	@Test
	public void crearVectorNulo() 
	{
		new Vector2D(0,0);		
	}
	
	@Test
	public void crearVectorAleatorioEntreValores() 
	{
		Vector2D vector = new Vector2D().aleatorio(0, 100, 0, 712);
		
		Assert.assertTrue(vector.obtenerCoordenadaX() >= 0 && vector.obtenerCoordenadaX() <= 100);
		Assert.assertTrue(vector.obtenerCoordenadaY() >= 0 && vector.obtenerCoordenadaY() <= 712);
		
	}
	
	@Test
	public void distanciaEntreVectores() 
	{
		Vector2D origen = new Vector2D(0,0), destino = new Vector2D(321,718);
		
		Assert.assertTrue(origen.distanciaA(destino) == Math.sqrt(321*321+718*718));		
	}
	
	@Test
	public void dividirEnSubVectores() 
	{
		Vector2D destino = new Vector2D(2,2);
		
		ArrayList<Vector2D> subVectores = destino.dividirSegunLongitud(10);
		
		Assert.assertEquals(1,subVectores.size());
		Assert.assertTrue(subVectores.get(0).obtenerCoordenadaX() == 2 && subVectores.get(0).obtenerCoordenadaY() == 2);		
	}

}
