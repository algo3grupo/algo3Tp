package fiuba.algo3.algocraft.recolectoresTest;

import java.util.ArrayList;

import junit.framework.Assert;

import org.junit.Test;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.Interfaces.IEstructura;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Protoss;
import fiuba.algo3.algocraft.mundo.Gas;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class AsimiladorTest {
	@Test
	public void crearAsimiladorEnUnLugarConGas() throws NoEsDeSuRazaLaEstructuraException, 
												NoTieneLaEstructuraCreadaException,	NoTieneRecursosSuficientesException, 
												NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia{
		
		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(null,500,10,juego);
		mundo.generar();
		
        Protoss jugadorProtoss = new Protoss(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador1(),null,null,null);
        
        Vector2D posicionBaseDeJugador = mundo.posicionBaseJugador1();
        
        ArrayList<Gas> lugaresConGas = mundo.gasCercano(posicionBaseDeJugador);
        jugadorProtoss.agregarEstructura(null,"Asimilador", lugaresConGas.get(0).obtenerPosicion(), mundo);
        
        ArrayList<Estructura> estructurasDeJugadorProtoss = jugadorProtoss.obtenerEstructuras();
        
        Assert.assertEquals(estructurasDeJugadorProtoss.size(), 2);    
	}
	
	@Test
	public void crearAsimiladorEnUnLugarSinGasNoDebeSerPosible() throws NoEsDeSuRazaLaEstructuraException, 
																NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException,
																NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia{

		Juego juego = new Juego("Protoss","DSRKLI","#FF0000","Terran","YTREJS","#0000FF");
        
		Mundo mundo = new Mundo(null,500,10,juego);
		mundo.generar();

		Protoss jugadorProtoss = new Protoss(mundo.obtenerDivisionDeGrilla(),mundo.posicionBaseJugador1(),null,null,null);
        
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
        jugadorProtoss.agregarEstructura(null,"Asimilador", posicionSinGas, mundo);                
        
        ArrayList<Estructura> estructurasDeJugadorProtoss = jugadorProtoss.obtenerEstructuras();
        }catch (NoHayGasEnElLugarACrear e) {}
            
	}
}
