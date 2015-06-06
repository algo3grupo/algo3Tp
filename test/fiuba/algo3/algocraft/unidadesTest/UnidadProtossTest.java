package fiuba.algo3.algocraft.unidadesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Protoss;
import fiuba.algo3.algocraft.unidadesProtoss.Zealot;
import fiuba.algo3.algocraft.excepciones.NoTienePoblacionSuficienteException;

public class UnidadProtossTest {
	
	
	@Test
	public void instaciarZealot(){
		Jugador jugador= new Protoss("Pepe", 100 ,100 );
		Unidad zealot = new Zealot(jugador);
		assertEquals("Zealot",zealot.nombre());
	}
	
	@Test
	public void intentaCrearUnidadSinLaEstructura(){
		Jugador jugador= new Protoss("Pepe",250 ,100 );
		try {
			jugador.agregarUnidad("Zealot");
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
	public void creaUnidadDespuesDeCrearEstructura(){
		Jugador jugador= new Protoss("Pepe", 350 ,100 );
		try {
			
			jugador.agregarEstructura("Acceso", null, null);
			jugador.agregarEstructura("Pilon", null, null);
			jugador.agregarUnidad("Zealot");
			
		} catch (NoEsDeSuRazaLaUnidadException
				| NoEsDeSuRazaLaEstructuraException
				| NoTieneLaEstructuraCreadaException
				|NoTieneRecursosSuficientesException
				| NoTienePoblacionSuficienteException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("No deberia tirar este error");
		}
		
		assertEquals("Zealot", jugador.ObtenerUnidades().get(0).nombre());
	}
	
	@Test
	public void creaUnidadYNoTieneMineralesSuficientes(){
		Jugador jugador= new Protoss("Pepe", 200 ,100 );
		try {
			jugador.agregarEstructura("Acceso", null, null);
			jugador.agregarEstructura("Pilon", null, null);
			jugador.agregarUnidad("Zealot");
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
	public void creaUnidadYNoTieneGasSuficiente(){
		Jugador jugador= new Protoss("Pepe", 380 ,30 );
		try {
			jugador.agregarEstructura("Acceso", null, null);
			jugador.agregarEstructura("Pilon", null, null);
			jugador.agregarUnidad("Dragon");
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
	public void creaUnidadYNoTieneEspacioSuficienteParaCrearla(){
		Jugador jugador= new Protoss("Pepe", 380 , 60 );
	try {
		jugador.agregarEstructura("Acceso", null, null);
		jugador.agregarUnidad("Dragon");
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