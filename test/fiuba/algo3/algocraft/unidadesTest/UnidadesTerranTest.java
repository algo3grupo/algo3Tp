package fiuba.algo3.algocraft.unidadesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.algocraft.vector2D.Vector2D;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEstructura;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTienePoblacionSuficienteException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Terran;
import fiuba.algo3.algocraft.pasaTurnos.PasaTurnos;
import fiuba.algo3.algocraft.unidadesTerran.Marine;

public class UnidadesTerranTest {

	@Test
	public void instaciarMarine(){
		Jugador jugador= new Terran("Pepe","#FF0000");
		Unidad marine = new Marine(new Vector2D(), jugador);
		assertEquals("Marine",marine.nombre());
	}
	
	@Test
	public void intentaCrearUnidadSinLaEstructura() throws ErrorAlHacerCopia, NoSeEncontroLaEstructura{
		Jugador jugador= new Terran("Pepe","#FF0000");
		jugador.agregarMineral(50);
		jugador.agregarGas(100);
		try {
			jugador.agregarUnidad("Marine");
			fail("Deberia lanzar que no esta la estructura creada");
			
		} catch (NoEsDeSuRazaLaUnidadException
				|NoTieneRecursosSuficientesException e) {
				fail("No deberia tirar este error");
				
		} catch (NoTieneLaEstructuraCreadaException e) {
			assert(true);
		}
	}
	
	@Test
	public void creaUnidadDespuesDeCrearEstructura() throws ErrorAlHacerCopia, NoSeEncontroLaEstructura{
		Jugador jugador= new Terran("Pepe","#FF0000");
		jugador.agregarMineral(150);
		jugador.agregarGas(100);
		try {
			
			jugador.agregarEstructura("Deposito Suministro", new Vector2D(), null);
			jugador.agregarEstructura("Barraca", new Vector2D(), null);
			PasaTurnos.pasarTurnos(jugador, 15);
			jugador.agregarUnidad("Marine");
			
		} catch (NoEsDeSuRazaLaUnidadException
				| NoEsDeSuRazaLaEstructuraException
				| NoTieneLaEstructuraCreadaException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("No deberia tirar este error");
		}
		PasaTurnos.pasarTurnos(jugador, 7);
		assertEquals("Marine", jugador.ObtenerUnidades().get(0).nombre());
	}
	
	@Test
	public void creaUnidadYNoTieneMineralesSuficientes() throws ErrorAlHacerCopia, NoSeEncontroLaEstructura{
		Jugador jugador= new Terran("Pepe","#FF0000");
		jugador.agregarMineral(10);
		jugador.agregarGas(100);
		try {
			jugador.agregarEstructura("Deposito Suministro", new Vector2D(), null);
			jugador.agregarEstructura("Barraca", new Vector2D(), null);
			PasaTurnos.pasarTurnos(jugador, 10);
			jugador.agregarUnidad("Marine");
		} catch (NoEsDeSuRazaLaUnidadException
				| NoEsDeSuRazaLaEstructuraException
				| NoTieneLaEstructuraCreadaException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("No deberia tirar este error");
		} catch (NoTieneRecursosSuficientesException e){
		}
		
	}
	
	@Test
	public void creaUnidadYNoTieneGasSuficiente() throws ErrorAlHacerCopia, NoSeEncontroLaEstructura{
		Jugador jugador= new Terran("Pepe","#FF0000");
		jugador.agregarMineral(450);
		jugador.agregarGas(110);
		try {
			jugador.agregarEstructura("Deposito Suministro", new Vector2D(), null);
			jugador.agregarEstructura("Barraca", new Vector2D(), null);
			PasaTurnos.pasarTurnos(jugador, 12);
			jugador.agregarEstructura("Fabrica", new Vector2D(), null);
			PasaTurnos.pasarTurnos(jugador, 12);
			jugador.agregarUnidad("Golliat");
			fail("No deberia llegar a esta parte");
		} catch (NoEsDeSuRazaLaUnidadException
				| NoEsDeSuRazaLaEstructuraException
				| NoTieneLaEstructuraCreadaException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("No deberia tirar este error");
		} catch (NoTieneRecursosSuficientesException e){
		}
		
	}


	@Test
	public void creaUnidadYNoTieneEspacioSuficienteParaCrearla() throws ErrorAlHacerCopia, NoSeEncontroLaEstructura{
		Jugador jugador= new Terran("Pepe","#FF0000");
		jugador.agregarMineral(180);
		jugador.agregarGas(60);
	try {
		jugador.agregarEstructura("Barraca", new Vector2D(), null);
		PasaTurnos.pasarTurnos(jugador, 15);
		jugador.agregarUnidad("Marine");
		
	} catch (NoEsDeSuRazaLaUnidadException
			| NoEsDeSuRazaLaEstructuraException
			| NoTieneLaEstructuraCreadaException
			| NoTieneRecursosSuficientesException
			| NoHayMineralEnElLugarACrear 
			| NoHayGasEnElLugarACrear e) {
		fail("No deberia tirar este error");
	} 
		
		assertEquals(jugador.ObtenerUnidades().size(), 0);
	
	}
	
}
