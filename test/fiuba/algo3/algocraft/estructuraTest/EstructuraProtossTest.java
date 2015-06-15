package fiuba.algo3.algocraft.estructuraTest;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Protoss;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.pasaTurnos.PasaTurnos;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class EstructuraProtossTest {

	@Test
	public void correlacionPuertoEstelarNecesitaAcceso() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Protoss(0,new Vector2D(100,100),null,"Pepe","#FF0000");
		jugador.agregarMineral(100);
		jugador.agregarGas(300);
		try {
	
				jugador.agregarEstructura(null,"Puerto Estelar", new Vector2D(), new Mundo(null, 1000, 1000, null));
		
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		} catch ( NoTieneLaEstructuraCreadaException e){}
		
	}
	
	@Test
	public void correlacionArchivosTemplariosNecesitaPuertoEstelarYNoLaTiene() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Protoss(0,new Vector2D(100,100),null,"Pepe","#FF0000");
		jugador.agregarMineral(250);
		jugador.agregarGas(350);
		try {
			jugador.agregarEstructura(null,"Acceso", new Vector2D(), new Mundo(null, 1000, 1000, null));
			jugador.agregarEstructura(null,"Archivos Templarios", new Vector2D(), new Mundo(null, 1000, 1000, null));
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				|NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		}  catch ( NoTieneLaEstructuraCreadaException e){}
		
	}
	
	@Test
	public void correlacionArchivosTemplariosNecesitaPuertoEstelarQueNoSeTerminoDeConstruir() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Protoss(0,new Vector2D(100,100),null,"Pepe","#FF0000");
		jugador.agregarMineral(250);
		jugador.agregarGas(350);
		try {
			jugador.agregarEstructura(null,"Puerto Estelar", new Vector2D(), new Mundo(null, 1000, 1000, null));
			jugador.agregarEstructura(null,"Archivos Templarios", new Vector2D(), new Mundo(null, 1000, 1000, null));
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				|NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		}  catch ( NoTieneLaEstructuraCreadaException e){}
		
	}
	
	@Test
	public void correlacionArchivosTemplariosNecesitaPuertoEstelarYLoTiene() throws Exception {
		
		Jugador jugador= new Protoss(0,new Vector2D(100,100),null,"Pepe","#FF0000");
		jugador.agregarMineral(250);
		jugador.agregarGas(350);
		try {
			jugador.agregarEstructura(null,"Acceso", new Vector2D(), new Mundo(null, 1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 8);
			jugador.agregarEstructura(null,"Puerto Estelar", new Vector2D(), new Mundo(null, 1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 10);
			jugador.agregarEstructura(null,"Archivos Templarios", new Vector2D(), new Mundo(null, 1000, 1000, null));
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				|NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear 
				|NoTieneLaEstructuraCreadaException e) {
			throw e;
		} 
		
		assert(true);
		
	}
}
