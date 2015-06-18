package fiuba.algo3.algocraft.recolectoresTest;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Terran;
import fiuba.algo3.algocraft.mundo.Gas;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class RefineriaTest {
	@Test
	public void crearRefineriaEnUnLugarConGas() throws NoEsDeSuRazaLaEstructuraException, 
													NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, 
													NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia{
        
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		mundo.generar();
		
        Terran jugadorTerran = new Terran(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador1(),null,null, mundo);
        
        Vector2D posicionBaseDeJugador = mundo.posicionBaseJugador1();
        
        ArrayList<Gas> lugaresConGas = mundo.gasCercano(posicionBaseDeJugador);
        jugadorTerran.agregarEstructura("Refineria", lugaresConGas.get(0).obtenerPosicion());
        
        ArrayList<Estructura> estructurasDeJugadorTerran = jugadorTerran.obtenerEstructuras();
        
        Assert.assertEquals(estructurasDeJugadorTerran.size(), 2);    
	}
	
	@Test
	public void crearRefineriaEnUnLugarSinGasNoDebeSerPosible() throws NoEsDeSuRazaLaEstructuraException, 
													NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, 
													NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia{

		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(500,10,juego);
		mundo.generar();

		Terran jugadorTerran = new Terran(mundo.obtenerDivisionDeGrilla(),new Vector2D(100,100),null,null,mundo);
        
		/*Busco una posicion que no tenga gas*/
        int i=1;
        int j=1;
        Vector2D posicionSinGas = new Vector2D();
        while (mundo.hayGas(posicionSinGas)){
        	i=i+10;
        	j=j+10;
        	posicionSinGas = new Vector2D(i,j);
        }
        try{
        jugadorTerran.agregarEstructura("Refineria", posicionSinGas);                
        
        ArrayList<Estructura> estructurasDeJugadorTerran = jugadorTerran.obtenerEstructuras();
		}catch (NoHayGasEnElLugarACrear e) {} 
            
	}
}
