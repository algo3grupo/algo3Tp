package fiuba.algo3.algocraft.unidadesTest;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoEsPosibleLanzarElHechizoAlli;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEntidad;
import fiuba.algo3.algocraft.excepciones.NoTieneEnergiaSuficiente;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.jugador.Protoss;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.pasaTurnos.PasaTurnos;
import fiuba.algo3.algocraft.unidadesProtoss.AltoTemplario;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class UnidadesEnergiaTest {

	@Test
	public void UnidadDeEnergiaEnUnTurnoCargaDiezDeEnergia() throws NoEsDeSuRazaLaEstructuraException, NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, 
												NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia, 
												NoEsDeSuRazaLaUnidadException, NoSeEncontroLaEntidad{
		
		Jugador jugador = new Protoss(100,new Vector2D(100,100),"Pepe",new Color(0), new Mundo(1000, 1000, null));
		jugador.agregarMineral(4000);
		jugador.agregarGas(4000);
		jugador.agregarEstructura("Pilon", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 15);
		jugador.agregarEstructura("Acceso", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 8);
		jugador.agregarEstructura("Puerto Estelar", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 10);
		jugador.agregarEstructura("Archivos Templarios", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 12);
		Estructura archivos = jugador.obtenerEstructuras().get(4);
		jugador.agregarUnidad("AltoTemplario", archivos);
		PasaTurnos.pasarTurnos(jugador, 7); // en el turno que se crea se carga energia
		
		int energiaActual = ((UnidadEnergia) jugador.ObtenerUnidades().get(0)).obtenerEnergia();
		assertEquals(60,energiaActual);
	}
	
	@Test
	public void UnidadDeEnergiaYAunquePasenMuchosTurnosLaEnergiaNoSobrepasaLos200() throws NoEsDeSuRazaLaEstructuraException, 
														NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException,
														NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia, 
														NoEsDeSuRazaLaUnidadException, NoSeEncontroLaEntidad {
		Jugador jugador = new Protoss(100,new Vector2D(100,100),"Pepe",new Color(0), new Mundo(1000, 1000, null));
		jugador.agregarMineral(4000);
		jugador.agregarGas(4000);
		jugador.agregarEstructura("Pilon", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 15);
		jugador.agregarEstructura("Acceso", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 8);
		jugador.agregarEstructura("Puerto Estelar", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 10);
		jugador.agregarEstructura("Archivos Templarios", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 10);
		Estructura archivos = jugador.obtenerEstructuras().get(4);
		jugador.agregarUnidad("AltoTemplario", archivos);
		PasaTurnos.pasarTurnos(jugador, 30); //turnos de sobra
		
		int energiaActual = ((UnidadEnergia) jugador.ObtenerUnidades().get(0)).obtenerEnergia();
		assertEquals(200,energiaActual);
	}
	
	@Test
	public void NoTieneSuficienteEnergiaComoParaLanzarElHechizo() throws NoEsDeSuRazaLaEstructuraException,
											NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException,
											NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia,
											NoEsDeSuRazaLaUnidadException, NoSeEncontroLaEntidad, NoEsPosibleLanzarElHechizoAlli{
		Jugador jugador = new Protoss(100,new Vector2D(100,100),"Pepe",new Color(0),new Mundo(1000, 1000, null));
		jugador.agregarMineral(4000);
		jugador.agregarGas(4000);
		jugador.agregarEstructura("Pilon", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 15);
		jugador.agregarEstructura("Acceso", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 8);
		jugador.agregarEstructura("Puerto Estelar", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 10);
		jugador.agregarEstructura("Archivos Templarios", new Vector2D());
		PasaTurnos.pasarTurnos(jugador, 10);
		Estructura archivos = jugador.obtenerEstructuras().get(4);
		jugador.agregarUnidad("AltoTemplario", archivos);
		PasaTurnos.pasarTurnos(jugador, 8);
		AltoTemplario altoTemplario = (AltoTemplario) jugador.ObtenerUnidades().get(0);
		try {
			altoTemplario.lanzarTormentaPsiconica(new Vector2D(), new Mundo(1000, 1000, null));
		} catch (NoTieneEnergiaSuficiente e) {
			assert(true);
		}
	}
	
	
}
