package fiuba.algo3.algocraft.unidadesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTienePoblacionSuficienteException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Terran;
import fiuba.algo3.algocraft.unidadesTerran.Marine;

public class UnidadesTerranTest {

	@Test
	public void instaciarMarine(){
		Jugador jugador= new Terran("Pepe", 100 ,100 );
		Unidad marine = new Marine(jugador);
		assertEquals("Marine",marine.nombre());
	}
	
	@Test
	public void intentaCrearUnidadSinLaEstructura() throws ErrorAlHacerCopia{
		Jugador jugador= new Terran("Pepe",250 ,100 );
		try {
			jugador.agregarUnidad("Marine");
			fail("Deberia lanzar que no esta la estructura creada");
			
		} catch (NoEsDeSuRazaLaUnidadException
				|NoTieneRecursosSuficientesException
				| NoTienePoblacionSuficienteException e) {
				fail("No deberia tirar este error");
				
		} catch (NoTieneLaEstructuraCreadaException e) {
			assert(true);
		}
	}
	
	@Test
	public void creaUnidadDespuesDeCrearEstructura() throws ErrorAlHacerCopia{
		Jugador jugador= new Terran("Pepe", 350 ,100 );
		try {
			
			jugador.agregarEstructura("Deposito Suministro", null, null);
			jugador.agregarEstructura("Barraca", null, null);
			jugador.agregarUnidad("Marine");
			
		} catch (NoEsDeSuRazaLaUnidadException
				| NoEsDeSuRazaLaEstructuraException
				| NoTieneLaEstructuraCreadaException
				| NoTieneRecursosSuficientesException
				| NoTienePoblacionSuficienteException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("No deberia tirar este error");
		}
		
		assertEquals("Marine", jugador.ObtenerUnidades().get(0).nombre());
	}
	
	@Test
	public void creaUnidadYNoTieneMineralesSuficientes() throws ErrorAlHacerCopia{
		Jugador jugador= new Terran("Pepe", 210 ,100 );
		try {
			jugador.agregarEstructura("Deposito Suministro", null, null);
			jugador.agregarEstructura("Barraca", null, null);
			jugador.agregarUnidad("Marine");
		} catch (NoEsDeSuRazaLaUnidadException
				| NoEsDeSuRazaLaEstructuraException
				| NoTieneLaEstructuraCreadaException
				| NoTienePoblacionSuficienteException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("No deberia tirar este error");
		} catch (NoTieneRecursosSuficientesException e){
		}
		
	}
	
	@Test
	public void creaUnidadYNoTieneGasSuficiente() throws ErrorAlHacerCopia{
		Jugador jugador= new Terran("Pepe", 650 ,110);
		try {
			jugador.agregarEstructura("Deposito Suministro", null, null);
			jugador.agregarEstructura("Barraca", null, null);
			jugador.agregarEstructura("Fabrica", null, null);
			jugador.agregarUnidad("Golliat");
			fail("No deberia llegar a esta parte");
		} catch (NoEsDeSuRazaLaUnidadException
				| NoEsDeSuRazaLaEstructuraException
				| NoTieneLaEstructuraCreadaException
				| NoTienePoblacionSuficienteException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("No deberia tirar este error");
		} catch (NoTieneRecursosSuficientesException e){
		}
		
	}


	@Test
	public void creaUnidadYNoTieneEspacioSuficienteParaCrearla() throws ErrorAlHacerCopia{
		Jugador jugador= new Terran("Pepe", 380 , 60 );
	try {
		jugador.agregarEstructura("Barraca", null, null);
		jugador.agregarUnidad("Marine");
		fail("No deberia llegar a esta parte");
	} catch (NoEsDeSuRazaLaUnidadException
			| NoEsDeSuRazaLaEstructuraException
			| NoTieneLaEstructuraCreadaException
			| NoTieneRecursosSuficientesException
			| NoHayMineralEnElLugarACrear 
			| NoHayGasEnElLugarACrear e) {
		fail("No deberia tirar este error");
	} catch (NoTienePoblacionSuficienteException e){
		}
	
	}

}
