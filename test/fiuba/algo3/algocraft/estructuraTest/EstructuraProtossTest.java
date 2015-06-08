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

public class EstructuraProtossTest {

	@Test
	public void correlacionPuertoEstelarNecesitaAcceso() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Protoss("Pepe",300,300);
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
	public void correlacionArchivosTemplariosNecesitaPuertoEstelar() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Protoss("Pepe", 450 ,350);
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

}
