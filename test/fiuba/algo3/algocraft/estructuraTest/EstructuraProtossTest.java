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
import fiuba.algo3.algocraft.pasaTurnos.PasaTurnos;

public class EstructuraProtossTest {

	@Test
	public void correlacionPuertoEstelarNecesitaAcceso() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Protoss("Pepe");
		jugador.agregarMineral(100);
		jugador.agregarGas(300);
		try {
	
				jugador.agregarEstructura("Puerto Estelar", null, null);
		
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		} catch ( NoTieneLaEstructuraCreadaException e){}
		
	}
	
	@Test
	public void correlacionArchivosTemplariosNecesitaPuertoEstelarYNoLaTiene() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Protoss("Pepe");
		jugador.agregarMineral(250);
		jugador.agregarGas(350);
		try {
			jugador.agregarEstructura("Acceso", null, null);
			jugador.agregarEstructura("Archivos Templarios", null, null);
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				|NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		}  catch ( NoTieneLaEstructuraCreadaException e){}
		
	}
	
	@Test
	public void correlacionArchivosTemplariosNecesitaPuertoEstelarQueNoSeTerminoDeConstruir() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Protoss("Pepe");
		jugador.agregarMineral(250);
		jugador.agregarGas(350);
		try {
			jugador.agregarEstructura("Puerto Estelar", null, null);
			jugador.agregarEstructura("Archivos Templarios", null, null);
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				|NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		}  catch ( NoTieneLaEstructuraCreadaException e){}
		
	}
	
	@Test
	public void correlacionArchivosTemplariosNecesitaPuertoEstelarYLoTiene() throws Exception {
		
		Jugador jugador= new Protoss("Pepe");
		jugador.agregarMineral(250);
		jugador.agregarGas(350);
		try {
			jugador.agregarEstructura("Acceso", null, null);
			PasaTurnos.pasarTurnos(jugador, 8);
			jugador.agregarEstructura("Puerto Estelar", null, null);
			PasaTurnos.pasarTurnos(jugador, 10);
			jugador.agregarEstructura("Archivos Templarios", null, null);
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
