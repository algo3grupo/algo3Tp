import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;
import fiuba.algo3.algocraft.excepciones.FinDeLaPartida;

public class PartidaTest {

	@Test(expected = FinDeLaPartida.class)
	public void unaPartidaCompleta() {
		
		Juego juego = new Juego("Protoss","Martin","#FF0000","Terran","Damian","#0000FF");
		
		Mundo mundo = juego.obtenerMundo();
		
		/*Turno 1: Jugador 1 crea un nexo mineral*/
		
		juego.construirEstructura("Nexo Mineral", mundo.mineralesCercanos(mundo.posicionBaseJugador1()).get(0).obtenerPosicion()); 
		
		juego.finalizarTurno();
		
		/*Turno 2: Jugador 2 crea un centro mineral y una refineria.*/
		
		juego.construirEstructura("Centro de mineral", mundo.mineralesCercanos(mundo.posicionBaseJugador2()).get(0).obtenerPosicion());
		juego.construirEstructura("Refineria", mundo.gasCercano(mundo.posicionBaseJugador2()).get(0).obtenerPosicion());
		
		juego.finalizarTurno();
		
		/*Turno 3: Jugador 1 crea un pilon */
		
		juego.construirEstructura("Pilon", mundo.posicionBaseJugador1());
		
		
		for(int i=3;i<=100;i++)
			juego.finalizarTurno();
		
		//Turno 101: Jugador 1 crea un acceso
		
		Vector2D posicionLibre = new Vector2D().aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(posicionLibre))
			posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		juego.construirEstructura("Acceso", posicionLibre);
		
		juego.finalizarTurno();
		
		//Turno 102: Jugador 2 crea una barraca
		
		posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(posicionLibre))
			posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		juego.construirEstructura("Barraca",posicionLibre);
		
		for(int i=102;i<=200;i++)
			juego.finalizarTurno();
		
		//Turno 200: Comienza la creacion de unidades y la batalla.
		
		
		
		
		
		
	}

}
