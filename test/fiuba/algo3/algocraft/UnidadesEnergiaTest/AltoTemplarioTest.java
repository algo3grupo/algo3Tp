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

public class AltoTemplarioTest {

	@Test
	public void AltoTemplarioRealizaAlucinacionYLaCopiaNoPoneDanioMuereAlPerderElEscudoACausaDelEMP() throws NoPuedeRealizarEsaAccion, NoTieneEnergiaSuficiente, NoEsPosibleLanzarElHechizoAlli, NoLePerteneceLaEntidad, NoEsDeSuRazaLaUnidadException, NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, NoSeEncontroLaEntidad, ErrorAlHacerCopia, NoEsDeSuRazaLaEstructuraException, NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, NoHaySuministroEnElLugarACrear {
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
		
		for(int i=191;i<=210;i++)
			juego.finalizarTurno();
		
		//Turno 211: Jugador2 Alucina unidad propia
		Unidad zealot = juego.obtenerUnidadesTurno().get(0);
		AltoTemplario mago= (AltoTemplario) juego.obtenerUnidadesTurno().get(5);
		mago.lanzarAlucinacion(zealot.obtenerPosicion(), mundo);
		assertEquals(7 , juego.obtenerUnidadesTurno().size());
		assertEquals(12 ,juego.obtenerPoblacionActualJugador());
		
		juego.finalizarTurno();
		
		//Turno 212: Jugador1 Crea un Marine y Fabrica
		
		Vector2D nuevaPosicion= new Vector2D().aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(nuevaPosicion))
			nuevaPosicion.aleatorio(0, 1000, 0, 1000);
		
		juego.construirEstructura("Fabrica", nuevaPosicion);
		
		Estructura barraca = juego.obtenerEstructurasDeJugador2().get(3);
		juego.crearUnidad("Marine", barraca);
		for(int i=212;i<=225;i++)
			juego.finalizarTurno();
		
		//Turno 226: Mueve Marine a posicion dada y crea Puerto Estelar
		Unidad marine = juego.obtenerUnidadesTurno().get(0);
		
		nuevaPosicion= new Vector2D().aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(nuevaPosicion))
			nuevaPosicion.aleatorio(0, 1000, 0, 1000);
		
		juego.moverUnidad(marine, nuevaPosicion);
		int vidaMarine = marine.verVida();
		
		while(!mundo.estaLibre(nuevaPosicion))
			nuevaPosicion.aleatorio(0, 1000, 0, 1000);
		juego.construirEstructura("Puerto Estelar", nuevaPosicion);
		
		juego.finalizarTurno();
		
		//Turno 227: Mueve copia cerca de marine y lo ataca
		
		Unidad copia = juego.obtenerUnidadesTurno().get(6);
		assertEquals(0,copia.verVida());
		assertEquals(100, copia.getVida().obtenerEscudoActual());
		juego.moverUnidad(copia, new Vector2D(0,1).sumarA(nuevaPosicion));
		juego.unidadAtaqueAtacaA((UnidadAtaqueBasico) copia,  marine);
		assertEquals(vidaMarine, marine.verVida());
		
		for(int i=227;i<=235;i++)
			juego.finalizarTurno();
		
		//Turno 235 crea Nave Ciencia
		Estructura puertoEstelarT = juego.obtenerEstructurasDeJugador2().get(5);
		juego.crearUnidad("NaveCiencia", puertoEstelarT);
		
		for(int i=232;i<=248;i++)
			juego.finalizarTurno();
		//Turno 249: AltoTemplario se mueve cerca de copia
		juego.moverUnidad(mago, new Vector2D(0,1).sumarA( copia.obtenerPosicion() ) );
		juego.finalizarTurno();
		
		//Turno 250: Nave ciencia tira EMP a Zona donde estan 
		
		NaveCiencia nave = (NaveCiencia) juego.obtenerUnidadesTurno().get(1);
		nave.lanzarEMP(copia.obtenerPosicion(), mundo);
		
		assertEquals(0, copia.getVida().obtenerEscudoActual());
		assertEquals(0, mago.obtenerEnergia());
		assertEquals(6, juego.obtenerUnidadesDeJugador1().size());
	}
	
	@Test
	public void AltoTemplarioRealizaTormentaPsiconicaDaniandoAAliadosYEnemigosEnDosTurnos() throws NoPuedeRealizarEsaAccion, NoTieneEnergiaSuficiente, NoEsPosibleLanzarElHechizoAlli, NoLePerteneceLaEntidad, NoEsDeSuRazaLaUnidadException, NoTieneLaEstructuraCreadaException, NoTieneRecursosSuficientesException, NoSeEncontroLaEntidad, ErrorAlHacerCopia, NoEsDeSuRazaLaEstructuraException, NoHayMineralEnElLugarACrear, NoHayGasEnElLugarACrear, NoHaySuministroEnElLugarACrear {
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
		
		for(int i=191;i<=210;i++)
			juego.finalizarTurno();
		
		//Turno 211: Jugador2 Alucina unidad propia
		Unidad zealot = juego.obtenerUnidadesTurno().get(0);
		AltoTemplario mago= (AltoTemplario) juego.obtenerUnidadesTurno().get(5);
		mago.lanzarAlucinacion(zealot.obtenerPosicion(), mundo);
		assertEquals(7 , juego.obtenerUnidadesTurno().size());
		assertEquals(12 ,juego.obtenerPoblacionActualJugador());
		
		juego.finalizarTurno();
		
		//Turno 212: Jugador1 Crea un Marine y Fabrica
		
		Vector2D nuevaPosicion= new Vector2D().aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(nuevaPosicion))
			nuevaPosicion.aleatorio(0, 1000, 0, 1000);
		
		
		Estructura barraca = juego.obtenerEstructurasDeJugador2().get(3);
		juego.crearUnidad("Marine", barraca);
		for(int i=212;i<=225;i++)
			juego.finalizarTurno();
		
		//Turno 226: Mueve Marine a posicion dada
		Unidad marine = juego.obtenerUnidadesTurno().get(0);
		
		nuevaPosicion= new Vector2D().aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(nuevaPosicion))
			nuevaPosicion.aleatorio(0, 1000, 0, 1000);
		
		juego.moverUnidad(marine, nuevaPosicion);
		int vidaMarineAnterior= marine.verVida();
		juego.finalizarTurno();
		
		//Turno 227: Mueve Zealot cerca de Marine y tira tormenta al lugar
		
		juego.moverUnidad(zealot, new Vector2D(0, 1 ).sumarA(nuevaPosicion));
		int vidaZealotAnterior = zealot.verVida();
		mago.lanzarTormentaPsiconica(nuevaPosicion, mundo);
		
		
		juego.finalizarTurno();
		
		//Turno 228: La tormenta les pego una vez, no rompiendo el escudo del zealot y mato al marine
		
		assertEquals(vidaZealotAnterior, zealot.verVida());
		assertEquals(0,juego.obtenerUnidadesDeJugador2().size());
		vidaZealotAnterior = zealot.verVida();
		juego.finalizarTurno();
		
		//Turno 229: La tormenta les pego otra vez rompiendo esta vez el escudo.
		assert(vidaZealotAnterior > zealot.verVida());
		vidaZealotAnterior = zealot.verVida();
		juego.finalizarTurno();
		
		//Turno 230: La tormenta ya no les pega
		assertEquals(vidaZealotAnterior, zealot.verVida());
		
	}

}
