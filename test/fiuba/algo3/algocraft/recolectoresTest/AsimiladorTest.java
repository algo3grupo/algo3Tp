package test.fiuba.algo3.algocraft.recolectoresTest;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.entidadesAbstractas.IEstructura;
import fiuba.algo3.algoCraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algoCraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algoCraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algoCraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algoCraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algoCraft.jugador.Protoss;
import fiuba.algo3.algoCraft.mundo.Gas;
import fiuba.algo3.algoCraft.mundo.Mundo;
import fiuba.algo3.algoCraft.vector2D.Vector2D;

public class AsimiladorTest {
	@Test
	public void crearAsimiladorEnUnLugarConGas() throws NoEsDeSuRazaLaEstructuraException, 
												NoTieneLaEstructuraCreadaException,	NoTieneRecursosSuficientesException, 
												NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear{
        
		Mundo mundo = new Mundo(500,10);
		mundo.generar();
		
        Protoss jugadorProtoss = new Protoss(null, 200, 0);
        
        Vector2D posicionBaseDeJugador = mundo.posicionBaseJugador1();
        
        ArrayList<Gas> lugaresConGas = mundo.gasCercano(posicionBaseDeJugador);
        jugadorProtoss.agregarEstructura("Asimilador", lugaresConGas.get(0).obtenerPosicion(), mundo);
        
        ArrayList<Estructura> estructurasDeJugadorProtoss = jugadorProtoss.obtenerEstructuras();
        
        Assert.assertEquals(estructurasDeJugadorProtoss.size(), 1);    
	}
	
	@Test
	public void crearAsimiladorEnUnLugarSinGasNoDebeSerPosible() throws NoEsDeSuRazaLaEstructuraException, 
																NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException,
																NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear{

		Mundo mundo = new Mundo(500,10);
		mundo.generar();

		Protoss jugadorProtoss = new Protoss(null, 200, 0);
        
		/*Busco una posicion que no tenga gas*/
        int i=1;
        int j=1;
        Vector2D posicionSinGas = new Vector2D();
        while (mundo.hayMineral(posicionSinGas)){
        	i=i+10;
        	j=j+10;
        	posicionSinGas = new Vector2D(i,j);
        }
        try{
        jugadorProtoss.agregarEstructura("Asimilador", posicionSinGas, mundo);                
        
        ArrayList<Estructura> estructurasDeJugadorProtoss = jugadorProtoss.obtenerEstructuras();
        }catch (NoHayGasEnElLugarACrear e) {}
            
	}
}
