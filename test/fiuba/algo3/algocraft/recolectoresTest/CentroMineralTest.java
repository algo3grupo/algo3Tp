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
import fiuba.algo3.algocraft.mundo.Mineral;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class CentroMineralTest {	
	@Test
	public void crearCentroMineralesEnUnLugarConMinerales() throws NoEsDeSuRazaLaEstructuraException,
														NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, 
														NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia{
        
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(null,500,10,juego);	
		mundo.generar();
		
        Terran jugadorTerran = new Terran(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador1(),null,null,null);
        
        Vector2D posicionBaseDeJugador = mundo.posicionBaseJugador1();
        
        ArrayList<Mineral> lugaresConMinerales = mundo.mineralesCercanos(posicionBaseDeJugador);
        jugadorTerran.agregarEstructura(null,"Centro De Minerales", lugaresConMinerales.get(0).obtenerPosicion(), mundo);
        
        ArrayList<Estructura> estructurasDeJugadorTerran = jugadorTerran.obtenerEstructuras();
        
        Assert.assertEquals(estructurasDeJugadorTerran.size(), 2);    
	}
	
	@Test
	public void crearCentroMineralesEnUnLugarSinMineralesNoDebeSerPosible() throws NoEsDeSuRazaLaEstructuraException, 
															NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, 
															NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia{

		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(null,500,10,juego);
		mundo.generar();

		Terran jugadorTerran = new Terran(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador1(),null,null,null);
        
		/*Busco una posicion que no tenga minerales*/
        int i=1;
        int j=1;
        Vector2D posicionSinMinerales = new Vector2D();
        while (mundo.hayMineral(posicionSinMinerales)){
        	i=i+10;
        	j=j+10;
        	posicionSinMinerales = new Vector2D(i,j);
        }
        try{
        jugadorTerran.agregarEstructura(null,"Centro De Minerales", posicionSinMinerales, mundo);                
        
        ArrayList<Estructura> estructurasDeJugadorTerran = jugadorTerran.obtenerEstructuras();
        } catch (NoHayMineralEnElLugarACrear e) {} 
            
	}
}
