package fiuba.algo3.algocraft.unidadesTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoEsPosibleCargarEstaUnidad;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEstructura;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTienePoblacionSuficienteException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Protoss;
import fiuba.algo3.algocraft.jugador.Terran;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.pasaTurnos.PasaTurnos;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class UnidadesNaveTestProtossTest {

	@Test
	public void crearNaveYCargarUnaUnidad() throws NoEsDeSuRazaLaEstructuraException, NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException,
					NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia, NoEsDeSuRazaLaUnidadException,
					NoEsPosibleCargarEstaUnidad, NoSeEncontroLaEstructura {
		Jugador jugador = new Protoss(0,new Vector2D(100,100),null,"Pepe","#FF0000");
		jugador.agregarMineral(4000);
		jugador.agregarGas(4000);
		jugador.agregarEstructura(null,"Pilon", new Vector2D(), new Mundo(null, 1000, 1000, null));
		PasaTurnos.pasarTurnos(jugador, 15);
		jugador.agregarEstructura(null,"Acceso", new Vector2D(), new Mundo(null, 1000, 1000, null));
		PasaTurnos.pasarTurnos(jugador, 8);
		jugador.agregarEstructura(null,"Puerto Estelar", new Vector2D(), new Mundo(null, 1000, 1000, null));
		PasaTurnos.pasarTurnos(jugador, 10);
		jugador.agregarUnidad("Nave Transporte", new Mundo(null, 1000, 1000, null));
		jugador.agregarUnidad("Zealot", new Mundo(null, 1000, 1000, null));
		PasaTurnos.pasarTurnos(jugador, 15);
		ArrayList<Unidad> unidades = jugador.ObtenerUnidades();
		UnidadNave nave = (UnidadNave) unidades.get(1);
		nave.cargarUnidad(unidades.get(0));
		assertEquals(nave.cantidadCarga(), 2);

	}

	@Test
	public void crearNaveYLaUnaUnidadQueQuiereCargarEsVoladora() throws NoEsDeSuRazaLaEstructuraException, NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException,
					NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia, NoEsDeSuRazaLaUnidadException, 
					NoSeEncontroLaEstructura {
		Jugador jugador = new Protoss(0,new Vector2D(100,100),null,"Pepe","#FF0000");
		jugador.agregarMineral(4000);
		jugador.agregarGas(4000);
		jugador.agregarEstructura(null,"Pilon", new Vector2D(), new Mundo(null, 1000, 1000, null));
		jugador.agregarEstructura(null,"Acceso", new Vector2D(), new Mundo(null, 1000, 1000, null));
		PasaTurnos.pasarTurnos(jugador, 8);
		jugador.agregarEstructura(null,"Puerto Estelar", new Vector2D(), new Mundo(null, 1000, 1000, null));
		PasaTurnos.pasarTurnos(jugador, 10);
		jugador.agregarUnidad("Nave Transporte", new Mundo(null, 1000, 1000, null));
		jugador.agregarUnidad("Scout", new Mundo(null, 1000, 1000, null));
		PasaTurnos.pasarTurnos(jugador, 15);
		ArrayList<Unidad> unidades = jugador.ObtenerUnidades();
		UnidadNave nave = (UnidadNave) unidades.get(0);
		try {
			nave.cargarUnidad(unidades.get(1));
		} catch (NoEsPosibleCargarEstaUnidad e) {
			assert(true);
		}

	}
	
	@Test
	public void crearNaveYQuiereSobreCargarLaNave() throws NoEsDeSuRazaLaEstructuraException, NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException,
					NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, ErrorAlHacerCopia, NoEsDeSuRazaLaUnidadException,
					 NoSeEncontroLaEstructura {
		Jugador jugador = new Protoss(0,new Vector2D(100,100),null,"Pepe","#FF0000");
		jugador.agregarMineral(4000);
		jugador.agregarGas(4000);
		jugador.agregarEstructura(null,"Pilon", new Vector2D(), new Mundo(null, 1000, 1000, null));
		jugador.agregarEstructura(null,"Pilon", new Vector2D(), new Mundo(null, 1000, 1000, null));
		jugador.agregarEstructura(null,"Pilon", new Vector2D(), new Mundo(null, 1000, 1000, null));
		jugador.agregarEstructura(null,"Acceso", new Vector2D(), new Mundo(null, 1000, 1000, null));
		PasaTurnos.pasarTurnos(jugador, 8);
		jugador.agregarEstructura(null,"Puerto Estelar", new Vector2D(), new Mundo(null, 1000, 1000, null));
		PasaTurnos.pasarTurnos(jugador, 10);
		jugador.agregarUnidad("Nave Transporte", new Mundo(null, 1000, 1000, null));
		for (int i=1; i < 6; i++){
			jugador.agregarUnidad("Zealot", new Mundo(null, 1000, 1000, null));
		}
		PasaTurnos.pasarTurnos(jugador, 17);
		ArrayList<Unidad> unidades = jugador.ObtenerUnidades();
		//la nave se crea ultima por eso posicion 5
		UnidadNave nave = (UnidadNave) unidades.get(5);
		try {
			for (int i=0; i < 4; i++){
			nave.cargarUnidad(unidades.get(i));
			}
		} catch (NoEsPosibleCargarEstaUnidad e) {
			fail("La tira antes de tiempo a la excepcion");
		}
		try {
			nave.cargarUnidad(unidades.get(5));
		} catch (NoEsPosibleCargarEstaUnidad e) {
			assert (true);
		}
	}

}
