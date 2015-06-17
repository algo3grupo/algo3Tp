package fiuba.algo3.algocraft.mundoTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Assert;
import org.junit.Test;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.excepciones.posicionDeJugadorIndefinida;
import fiuba.algo3.algocraft.excepciones.ParametroNegativo;
import fiuba.algo3.algocraft.excepciones.ParametroNulo;
import fiuba.algo3.algocraft.excepciones.DivisionDeGrillaNoEsMultiploDeResolucion;
import fiuba.algo3.algocraft.mundo.Gas;
import fiuba.algo3.algocraft.mundo.Mineral;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class MundoTest {
	
	@Test
	public void crearMundo() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);

	}
	
	@Test
	public void generarMundo() 
	{
		
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");        
	
		new Mundo(500,10,juego).generar();
	}
	
	@Test(expected = ParametroNegativo.class)
	public void resolucionNegativa() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(-500,10,juego);	
	}
	
	@Test(expected = ParametroNegativo.class)
	public void divisionDeGrillaNegativa() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,-10,juego);
	}
	
	@Test(expected = ParametroNulo.class)
	public void divisionDeGrillaCero()
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,0,juego);
	}
	
	@Test(expected = ParametroNulo.class)
	public void resolucionCero() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(0,10,juego);	
	}
	
	@Test(expected = DivisionDeGrillaNoEsMultiploDeResolucion.class)
	public void divisionDeGrillaDistintoAMultiploDeResolucion() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,3,juego);
	}


	@Test
	public void posicionValidaBaseJugadores() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		Vector2D posicionBaseJugador1 = mundo.posicionBaseJugador1(), posicionBaseJugador2 = mundo.posicionBaseJugador2();
		
		Assert.assertTrue( 0 < posicionBaseJugador1.obtenerCoordenadaX() && posicionBaseJugador1.obtenerCoordenadaX() < mundo.obtenerResolucion());
		Assert.assertTrue( 0 < posicionBaseJugador1.obtenerCoordenadaY() && posicionBaseJugador1.obtenerCoordenadaY() < mundo.obtenerResolucion());
		
		Assert.assertTrue( 0 < posicionBaseJugador2.obtenerCoordenadaX() && posicionBaseJugador2.obtenerCoordenadaX() < mundo.obtenerResolucion());
		Assert.assertTrue( 0 < posicionBaseJugador2.obtenerCoordenadaY() && posicionBaseJugador2.obtenerCoordenadaY() < mundo.obtenerResolucion());
		
	}
	
	@Test
	public void distanciaEntreBasesDeJugadoresGrande() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		Vector2D posicionBaseJugador1 = mundo.posicionBaseJugador1(), posicionBaseJugador2 = mundo.posicionBaseJugador2();
		
		Assert.assertTrue(posicionBaseJugador1.distanciaA(posicionBaseJugador2) >= mundo.obtenerResolucion()*0.75);
	}
	
	@Test
	public void recursosCercanosALasBasesDeLosJugares() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		Vector2D posicionBaseJugador1 = mundo.posicionBaseJugador1(), posicionBaseJugador2 = mundo.posicionBaseJugador2();
		
		Assert.assertTrue( mundo.hayMineralesCercanos(posicionBaseJugador1));
		Assert.assertTrue( mundo.hayGasCercano(posicionBaseJugador1));
		
		Assert.assertTrue( mundo.hayMineralesCercanos(posicionBaseJugador2));
		Assert.assertTrue( mundo.hayGasCercano(posicionBaseJugador2));
		
	}
	
	@Test
	public void listaDeMineralesCercanos() 
	{

		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		Assert.assertTrue(mundo.mineralesCercanos(new Vector2D().aleatorio(0, mundo.obtenerResolucion(),0,mundo.obtenerResolucion())).size() > 0);
	}
	
	@Test
	public void listaDeGasesCercanos() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		Assert.assertTrue(mundo.gasCercano(new Vector2D().aleatorio(0, mundo.obtenerResolucion(),0,mundo.obtenerResolucion())).size() > 0);
	}
	
	@Test
	public void obtenerResolucion() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		Assert.assertEquals(500, mundo.obtenerResolucion());
	}
	
	@Test(expected = posicionDeJugadorIndefinida.class)
	public void posicionBaseJugador1Vacia() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.posicionBaseJugador1();
	}
	
	@Test(expected = posicionDeJugadorIndefinida.class)
	public void posicionBaseJugador2Vacia()
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.posicionBaseJugador2();
	}
	
	@Test
	public void posicionBaseJugador1NoVacia() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		mundo.posicionBaseJugador1();
	}
	
	@Test
	public void posicionBaseJugador2NoVacia() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		mundo.posicionBaseJugador2();
	}
	
	@Test
	public void posicionDondeNoHayMineral() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		Assert.assertFalse(mundo.hayMineral(mundo.posicionBaseJugador1()));
		
	}
	
	@Test
	public void posicionDondeSiHayMineral() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		ArrayList<Mineral> minerales = mundo.mineralesCercanos(new Vector2D().aleatorio(0, mundo.obtenerResolucion(),0,mundo.obtenerResolucion()));
		
		Assert.assertTrue(mundo.hayMineral(minerales.get(0).obtenerPosicion()));
	}
	
	@Test
	public void posicionDondeNoHayGas() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		Assert.assertFalse(mundo.hayGas(mundo.posicionBaseJugador2()));
	}
	
	@Test
	public void posicionDondeSiHayGas() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		ArrayList<Gas> gas = mundo.gasCercano(new Vector2D().aleatorio(0, mundo.obtenerResolucion(),0,mundo.obtenerResolucion()));
		
		Assert.assertTrue(mundo.hayGas(gas.get(0).obtenerPosicion()));
	}
	
	@Test
	public void posicionDondeNoHayEspacio() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		mundo.generar();
		
		Assert.assertFalse(mundo.hayEspacio(mundo.posicionBaseJugador1()));
	}
	
	@Test
	public void pixelAGrilla() 
	{
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		
		Vector2D grilla = mundo.pixelAGrilla(new Vector2D(1,1));
		
		Assert.assertTrue(grilla.obtenerCoordenadaX() == 0);
		Assert.assertTrue(grilla.obtenerCoordenadaY() == 0);
	}
	
	
}
