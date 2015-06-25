package fiuba.algo3.algocraft.UnidadesEnergiaTest;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaUnidadException;
import fiuba.algo3.algocraft.excepciones.NoEsPosibleLanzarElHechizoAlli;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHaySuministroEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.excepciones.NoSeEncontroLaEntidad;
import fiuba.algo3.algocraft.excepciones.NoTieneEnergiaSuficiente;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.unidadesProtoss.AltoTemplario;
import fiuba.algo3.algocraft.unidadesTerran.NaveCiencia;
import fiuba.algo3.algocraft.vector2D.Vector2D;
import fiuba.algo3.excepciones.NoLePerteneceLaEntidad;

public class NaveCienciaTest {

	@Test
	public void NaveCienciaTiraRadiacionEInfectaALosZealots() throws NoPuedeRealizarEsaAccion, NoTieneEnergiaSuficiente, NoEsPosibleLanzarElHechizoAlli, NoLePerteneceLaEntidad, NoEsDeSuRazaLaUnidadException, NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, NoSeEncontroLaEntidad, ErrorAlHacerCopia, NoEsDeSuRazaLaEstructuraException, NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, NoHaySuministroEnElLugarACrear {
		Juego juego = new Juego("Protoss", "Pepe", null, "Terran", "Pipi", null);
		Mundo mundo = juego.obtenerMundo();
		
		
		/*Turno 1: Jugador 1 crea un nexo mineral*/
		
		juego.construirEstructura("Nexo Mineral", mundo.mineralesCercanos(mundo.posicionBaseJugador1()).get(0).obtenerPosicion()); 
		
		juego.finalizarTurno();
		
		/*Turno 2: Jugador 2 crea un centro mineral y una refineria.*/
		
		juego.construirEstructura("Centro De Minerales", mundo.mineralesCercanos(mundo.posicionBaseJugador2()).get(0).obtenerPosicion());
		juego.construirEstructura("Refineria", mundo.gasCercano(mundo.posicionBaseJugador2()).get(0).obtenerPosicion());
		
		juego.finalizarTurno();
		
		/*Turno 3: Jugador 1 crea un pilones */
		
		juego.construirEstructura("Pilon", mundo.posicionBaseJugador1());
		
		
		for(int i=3;i<=100;i++)
			juego.finalizarTurno();
		
		//Turno 101: Jugador 1 crea un acceso y otro Pilon y Asimilador
		Vector2D posicionLibre = new Vector2D().aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(posicionLibre))
			posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		juego.construirEstructura("Pilon", posicionLibre);
		juego.construirEstructura("Asimilador", mundo.gasCercano(mundo.posicionBaseJugador1()).get(0).obtenerPosicion());
		
		posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(posicionLibre))
			posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		juego.construirEstructura("Acceso", posicionLibre);
		
		juego.finalizarTurno();
		
		//Turno 102: Jugador 2 crea una barraca
		
		posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(posicionLibre))
			posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		juego.construirEstructura("Barraca",posicionLibre);
		
		for(int i=102;i<=170;i++)
			juego.finalizarTurno();
		
		//Turno 171: Jugador1 crea puerto estelar
		posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(posicionLibre))
			posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		juego.construirEstructura("Puerto Estelar", posicionLibre);
		
		for(int i=171;i<=180;i++)
			juego.finalizarTurno();
		//Turno 181: Jugador2 crea Archivos Templarios y un par de unidades
		posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(posicionLibre))
			posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		juego.construirEstructura("Archivos Templarios", posicionLibre);
		
		
		Estructura acceso = juego.obtenerEstructurasDeJugador1().get(4);
		for (int j = 0; j < 5; j++){
			juego.crearUnidad("Zealot", acceso);
		}
		
		for(int i=181;i<=190;i++)
			juego.finalizarTurno();
		//Turno 191: Jugador2 se pone a Crear un AltoTemplario
		Estructura archivos = juego.obtenerEstructurasDeJugador1().get(6);
		juego.crearUnidad("AltoTemplario", archivos);
		
		for(int i=191;i<=211;i++)
			juego.finalizarTurno();
		
		
		//Turno 212: Jugador1 Crea Fabrica
		
		Vector2D nuevaPosicion= new Vector2D().aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(nuevaPosicion))
			nuevaPosicion.aleatorio(0, 1000, 0, 1000);
		
		juego.construirEstructura("Fabrica", nuevaPosicion);
		
		for(int i=212;i<=225;i++)
			juego.finalizarTurno();
		
		//Turno 226: Crea Puerto Estelar
		
		nuevaPosicion= new Vector2D().aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(nuevaPosicion))
			nuevaPosicion.aleatorio(0, 1000, 0, 1000);
		juego.construirEstructura("Puerto Estelar", nuevaPosicion);
		
		
		for(int i=226; i <= 235;i++)
			juego.finalizarTurno();
		
		//Turno 235 crea Nave Ciencia
		Estructura puertoEstelarT = juego.obtenerEstructurasDeJugador2().get(5);
		juego.crearUnidad("NaveCiencia", puertoEstelarT);
		
		for(int i=232;i<=250;i++)
			juego.finalizarTurno();
		
		//Turno 251: Mueve Zealot a configuracion de que todos reciban danio por infeccion
		Unidad zealot;
		zealot = juego.obtenerUnidadesTurno().get(1);
		juego.moverUnidad(zealot, new Vector2D(500,501));
		zealot = juego.obtenerUnidadesTurno().get(2);
		juego.moverUnidad(zealot, new Vector2D(501,500));
		zealot = juego.obtenerUnidadesTurno().get(3);
		juego.moverUnidad(zealot, new Vector2D(500,499));
		zealot = juego.obtenerUnidadesTurno().get(4);
		juego.moverUnidad(zealot, new Vector2D(499,500));
		zealot = juego.obtenerUnidadesTurno().get(0);
		juego.moverUnidad(zealot, new Vector2D(500,500));
		
		juego.finalizarTurno();
		
		//Turno 252: Nave ciencia tira Radiacion a Unidad Central 
		
		NaveCiencia nave = (NaveCiencia) juego.obtenerUnidadesTurno().get(0);
		nave.lanzarRadiacion(zealot.obtenerPosicion(), mundo);
		juego.finalizarTurno();
		
		//Turno 253 en adelante: VerificarDanioAZealotsAlrededor
		for (int j = 1; j < 5 ; j++){
			zealot = juego.obtenerUnidadesTurno().get(j);
			assertEquals(50,zealot.getVida().obtenerEscudoActual());
		}
		
		juego.finalizarTurno();
		
		for (int j = 1; j < 5 ; j++){
			zealot = juego.obtenerUnidadesDeJugador1().get(j);
			assertEquals(40,zealot.getVida().obtenerEscudoActual());
		}
		
		juego.finalizarTurno();// les sacan 30 y despues sube el escudo 10 --> -10 vida
		
		juego.finalizarTurno();//el escudo carga 10 y lo atacan con 30 --> -20 vida
		// su escudo ya se rompe en cada turno y pierden vida
		
		
		for ( int k = 70; k > 0; k-=20){
			for (int j = 1; j < 5 ; j++){
				zealot = juego.obtenerUnidadesDeJugador1().get(j);
				assertEquals(k, zealot.getVida().vidaActual());
			}
			juego.finalizarTurno();// escudo carga 10 y atacan 30 --> -20 vida
		}
		
		assertEquals(1, juego.obtenerUnidadesDeJugador1().size());
	}
}
