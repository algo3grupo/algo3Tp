package fiuba.algo3.algocraft.recolectoresTest;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Protoss;
import fiuba.algo3.algocraft.mundo.Mineral;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class NexoMineralTest {
	@Test
	public void crearNexoMineralEnUnLugarConMinerales() throws NoEsDeSuRazaLaEstructuraException, 
															NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, 
															NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia{
        
		Mundo mundo = new Mundo(500,10);
		mundo.generar();
		
        Protoss jugadorProtoss = new Protoss(null, 200, 0);
        
        Vector2D posicionBaseDeJugador = mundo.posicionBaseJugador1();
        
        ArrayList<Mineral> lugaresConMinerales = mundo.mineralesCercanos(posicionBaseDeJugador);
        jugadorProtoss.agregarEstructura("Nexo Mineral", lugaresConMinerales.get(0).obtenerPosicion(), mundo);
        
        ArrayList<Estructura> estructurasDeJugadorProtoss = jugadorProtoss.obtenerEstructuras();
        
        Assert.assertEquals(estructurasDeJugadorProtoss.size(), 1);    
	}
	
	@Test
	public void crearNexoMineralEnUnLugarSinMineralesNoDebeSerPosible() throws NoEsDeSuRazaLaEstructuraException,
															NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, 
															NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia{

		Mundo mundo = new Mundo(500,10);
		mundo.generar();

		Protoss jugadorProtoss = new Protoss(null, 200, 0);
        
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
        jugadorProtoss.agregarEstructura("Nexo Mineral", posicionSinMinerales, mundo);                
        
        ArrayList<Estructura> estructurasDeJugadorProtoss = jugadorProtoss.obtenerEstructuras();
        } catch (NoHayMineralEnElLugarACrear e) {}    
	}

}
