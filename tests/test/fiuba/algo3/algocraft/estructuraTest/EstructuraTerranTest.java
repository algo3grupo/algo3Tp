package test.fiuba.algo3.algocraft.estructuraTest;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algoCraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algoCraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algoCraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algoCraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algoCraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algoCraft.jugador.Jugador;
import fiuba.algo3.algoCraft.jugador.Terran;

public class EstructuraTerranTest {

	@Test
	public void correlacionPuertoEstelarNecesitaFabrica() {
		
		Jugador jugador= new Terran("Pepe",2500,2500);
		try {
			jugador.agregarEstructura("Deposito Suministro", null, null);
			jugador.agregarEstructura("Barraca", null, null);
			jugador.agregarEstructura("Puerto Estelar", null, null);
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		} catch ( NoTieneLaEstructuraCreadaException e){}
		
	}
	
	@Test
	public void correlacionFabricaNecesitaBarraca() {
		
		Jugador jugador= new Terran("Pepe", 2500 , 2500);
		try {
			jugador.agregarEstructura("Deposito Suministro", null, null);
			jugador.agregarEstructura("Fabrica", null, null);
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		}  catch ( NoTieneLaEstructuraCreadaException e){}
		
	}

}