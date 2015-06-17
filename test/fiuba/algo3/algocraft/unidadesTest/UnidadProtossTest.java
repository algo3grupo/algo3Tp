package fiuba.algo3.algocraft.unidadesTest;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.vector2D.Vector2D;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEntidad;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Protoss;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.pasaTurnos.PasaTurnos;
import fiuba.algo3.algocraft.unidadesProtoss.Zealot;
import fiuba.algo3.algocraft.excepciones.NoTienePoblacionSuficienteException;

public class UnidadProtossTest {
	
	
	@Test
	public void instaciarZealot(){
		Jugador jugador= new Protoss(0,new Vector2D(100,100),"Pepe","#FF0000");
		Unidad zealot = new Zealot(0,new Vector2D(), jugador);
		assertEquals("Zealot",zealot.nombre());
	}
	
	@Test
	public void intentaCrearUnidadSinLaEstructura() throws ErrorAlHacerCopia, NoSeEncontroLaEntidad{
		Jugador jugador= new Protoss(0,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(50);
		jugador.agregarGas(100);
		try {
			jugador.agregarUnidad("Zealot", new Mundo(1000, 1000, null));
			fail("Deberia lanzar que no esta la estructura creada");
		} catch (NoEsDeSuRazaLaUnidadException
				|NoTieneRecursosSuficientesException e) {
				fail("No deberia tirar este error");
		} catch (NoTieneLaEstructuraCreadaException e) {
			assert(true);
		}
	}
	
	@Test
	public void creaUnidadDespuesDeCrearEstructura() throws ErrorAlHacerCopia, NoSeEncontroLaEntidad{
		Jugador jugador= new Protoss(0,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(250);
		jugador.agregarGas(100);
		try {
			
			jugador.agregarEstructura("Acceso", new Vector2D(), new Mundo(1000, 1000, null));
			jugador.agregarEstructura("Pilon", new Vector2D(), new Mundo(1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 15);
			jugador.agregarUnidad("Zealot", new Mundo(1000, 1000, null));
			
		} catch (NoEsDeSuRazaLaUnidadException
				| NoEsDeSuRazaLaEstructuraException
				| NoTieneLaEstructuraCreadaException
				|NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("No deberia tirar este error");
		}
		PasaTurnos.pasarTurnos(jugador, 7);
		assertEquals("Zealot", jugador.ObtenerUnidades().get(0).nombre());
	}
	
	@Test
	public void creaUnidadYNoTieneMineralesSuficientes() throws ErrorAlHacerCopia, NoSeEncontroLaEntidad{
		Jugador jugador= new Protoss(0,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(100);
		jugador.agregarGas(100);
		try {
			jugador.agregarEstructura("Acceso", new Vector2D(), new Mundo(1000, 1000, null));
			jugador.agregarEstructura("Pilon", new Vector2D(), new Mundo(1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 10);
			jugador.agregarUnidad("Zealot", new Mundo(1000, 1000, null));
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
	public void creaUnidadYNoTieneGasSuficiente() throws ErrorAlHacerCopia, NoSeEncontroLaEntidad{
		Jugador jugador= new Protoss(0,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(180);
		jugador.agregarGas(30);
		try {
			jugador.agregarEstructura("Acceso", new Vector2D(), new Mundo(1000, 1000, null));
			jugador.agregarEstructura("Pilon", new Vector2D(), new Mundo(1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 15);
			jugador.agregarUnidad("Dragon", new Mundo(1000, 1000, null));
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
	public void creaUnidadYNoTieneEspacioSuficienteParaCrearla() throws ErrorAlHacerCopia, NoSeEncontroLaEntidad{
		Jugador jugador= new Protoss(0,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(380);
		jugador.agregarGas(60);
	try {
		jugador.agregarEstructura("Acceso", new Vector2D(), new Mundo(1000, 1000, null));
		PasaTurnos.pasarTurnos(jugador, 15);
		jugador.agregarUnidad("Dragon", new Mundo(1000, 1000, null));
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