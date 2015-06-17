package fiuba.algo3.algocraft.unidadesTest;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import org.junit.Test;

import fiuba.algo3.algocraft.vector2D.Vector2D;
import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesAereas;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesEnTierra;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEntidad;
import fiuba.algo3.algocraft.excepciones.NoSePuedeAtacarEstaFueraDeRango;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTienePoblacionSuficienteException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Terran;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.pasaTurnos.PasaTurnos;
import fiuba.algo3.algocraft.unidadesTerran.Marine;

public class UnidadesTerranTest {

	@Test
	public void instaciarMarine(){
		Jugador jugador= new Terran(10,new Vector2D(100,100),"Pepe","#FF0000");
		Unidad marine = new Marine(10,new Vector2D(), jugador);
		assertEquals("Marine",marine.nombre());
	}
	
	@Test
	public void intentaCrearUnidadSinLaEstructura() throws ErrorAlHacerCopia, NoSeEncontroLaEntidad{
		Jugador jugador= new Terran(10,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(50);
		jugador.agregarGas(100);
		try {
			jugador.agregarUnidad("Marine", new Mundo(1000, 1000, null));
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
		Jugador jugador= new Terran(10,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(150);
		jugador.agregarGas(100);
		try {
			
			jugador.agregarEstructura("Deposito Suministro", new Vector2D(), new Mundo(1000, 1000, null));
			jugador.agregarEstructura("Barraca", new Vector2D(), new Mundo(1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 15);
			jugador.agregarUnidad("Marine", new Mundo(1000, 1000, null));
			
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
	public void creaUnidadYNoTieneMineralesSuficientes() throws ErrorAlHacerCopia, NoSeEncontroLaEntidad{
		Jugador jugador= new Terran(10,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(10);
		jugador.agregarGas(100);
		try {
			jugador.agregarEstructura("Deposito Suministro", new Vector2D(), new Mundo(1000, 1000, null));
			jugador.agregarEstructura("Barraca", new Vector2D(), new Mundo(1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 10);
			jugador.agregarUnidad("Marine", new Mundo(1000, 1000, null));
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
		Jugador jugador= new Terran(10,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(450);
		jugador.agregarGas(110);
		try {
			jugador.agregarEstructura("Deposito Suministro", new Vector2D(), new Mundo(1000, 1000, null));
			jugador.agregarEstructura("Barraca", new Vector2D(), new Mundo(1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 12);
			jugador.agregarEstructura("Fabrica", new Vector2D(), new Mundo(1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 12);
			jugador.agregarUnidad("Golliat", new Mundo(1000, 1000, null));
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
		Jugador jugador= new Terran(10,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(180);
		jugador.agregarGas(60);
	try {
		jugador.agregarEstructura("Barraca", new Vector2D(), new Mundo(1000, 1000, null));
		PasaTurnos.pasarTurnos(jugador, 15);
		jugador.agregarUnidad("Marine", new Mundo(1000, 1000, null));
		
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
	
	@Test
	public void MarineEsFuliminadaPorUnAtaqueYEsEliminadaDelJugador() throws NoSeEncontroLaEntidad, ErrorAlHacerCopia, 
																		NoSePuedeAtacarEstaFueraDeRango, 
																		NoPuedeAtacarUnidadesEnTierra,
																		NoPuedeAtacarUnidadesAereas{
		Jugador jugador= new Terran(10,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(180);
		jugador.agregarGas(60);
		try {
			jugador.agregarEstructura("Barraca", new Vector2D(), new Mundo(1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 15);
			jugador.agregarUnidad("Marine", new Mundo(1000, 1000, null));
			
		}catch (NoEsDeSuRazaLaUnidadException
				| NoEsDeSuRazaLaEstructuraException
				| NoTieneLaEstructuraCreadaException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("No deberia tirar este error");
		} 
		PasaTurnos.pasarTurnos(jugador, 10);
		Unidad marine = jugador.ObtenerUnidades().get(0);
		Ataque eliminador = new Ataque(40, 40, 5, 1);
		marine.atacado(eliminador, 4);
		assertEquals(0,jugador.ObtenerUnidades().size());
	}
	
	@Test
	public void NaveEsFuliminadaPorUnAtaqueYEsEliminadaDelJugador() throws NoSeEncontroLaEntidad, ErrorAlHacerCopia, 
																		NoSePuedeAtacarEstaFueraDeRango{
		Jugador jugador= new Terran(10,new Vector2D(100,100),"Pepe","#FF0000");
		jugador.agregarMineral(500);
		jugador.agregarGas(300);
		try {
			jugador.agregarEstructura("Barraca", new Vector2D(), new Mundo(1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 15);
			jugador.agregarEstructura("Fabrica", new Vector2D(), new Mundo(1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 15);
			jugador.agregarEstructura("Puerto Estelar", new Vector2D(), new Mundo(1000, 1000, null));
			PasaTurnos.pasarTurnos(jugador, 15);
			
			jugador.agregarUnidad("Espectro", new Mundo(1000, 1000, null));
			
		}catch (NoEsDeSuRazaLaUnidadException
				| NoEsDeSuRazaLaEstructuraException
				| NoTieneLaEstructuraCreadaException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("No deberia tirar este error");
		} 
		PasaTurnos.pasarTurnos(jugador, 10);
		Unidad espectro = jugador.ObtenerUnidades().get(0);
		Ataque tierra = new Ataque(40, 0, 5, 0);
		try {
			espectro.atacado(tierra, 4);
		} catch (NoPuedeAtacarUnidadesEnTierra e) {
			fail("No deberia tirar este error");
		} catch (NoPuedeAtacarUnidadesAereas e) {
			assert(true);
		}
		
	}
}