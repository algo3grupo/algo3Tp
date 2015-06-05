package test.fiuba.algo3.algocraft.recolectoresTest;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.algoCraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algoCraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algoCraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algoCraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algoCraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algoCraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algoCraft.jugador.Terran;
import fiuba.algo3.algoCraft.mundo.Gas;
import fiuba.algo3.algoCraft.mundo.Mundo;
import fiuba.algo3.algoCraft.vector2D.Vector2D;

public class RefineriaTest {
	@Test
	public void crearRefineriaEnUnLugarConGas() throws NoEsDeSuRazaLaEstructuraException, 
													NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, 
													NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear{
        
		Mundo mundo = new Mundo(500,10);
		mundo.generar();
		
        Terran jugadorTerran = new Terran(null, 200, 0);
        
        Vector2D posicionBaseDeJugador = mundo.posicionBaseJugador1();
        
        ArrayList<Gas> lugaresConGas = mundo.gasCercano(posicionBaseDeJugador);
        jugadorTerran.agregarEstructura("Refineria", lugaresConGas.get(0).obtenerPosicion(), mundo);
        
        ArrayList<Estructura> estructurasDeJugadorTerran = jugadorTerran.obtenerEstructuras();
        
        Assert.assertEquals(estructurasDeJugadorTerran.size(), 1);    
	}
	
	@Test
	public void crearRefineriaEnUnLugarSinGasNoDebeSerPosible() throws NoEsDeSuRazaLaEstructuraException, 
													NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, 
													NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear{

		Mundo mundo = new Mundo(500,10);
		mundo.generar();

		Terran jugadorTerran = new Terran(null, 200, 0);
        
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
        jugadorTerran.agregarEstructura("Refineria", posicionSinGas, mundo);                
        
        ArrayList<Estructura> estructurasDeJugadorTerran = jugadorTerran.obtenerEstructuras();
		}catch (NoHayGasEnElLugarACrear e) {} 
            
	}
}
