import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;


public class PartidaTest {

	@Test
	public void UnaPartidaCompleta() {
		
		Juego juego = new Juego("Protoss","Martin","#FF0000","Terran","Damian","#0000FF");
		
		Mundo mundo = new Mundo(1000,10,juego);
		
		juego.construirEstructura("Nexo Mineral", mundo.mineralesCercanos(juego.obtenerMundo().posicionBaseJugador1()).get(0).obtenerPosicion());
		
		juego.finalizarTurno();
		
		juego.construirEstructura("Centro de mineral", mundo.mineralesCercanos(juego.obtenerMundo().posicionBaseJugador2()).get(0).obtenerPosicion());
		juego.construirEstructura("Refineria", mundo.gasCercano(juego.obtenerMundo().posicionBaseJugador2()).get(0).obtenerPosicion());
		
		juego.finalizarTurno();
		
		juego.construirEstructura("Pilon", mundo.posicionBaseJugador1());
		
		for(int i=3;i<=100;i++)
			juego.finalizarTurno();
		
		Vector2D posicionLibre = new Vector2D().aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(posicionLibre))
			posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		juego.construirEstructura("Acceso", posicionLibre);
		
		juego.finalizarTurno();
		
		posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		while(!mundo.estaLibre(posicionLibre))
			posicionLibre.aleatorio(0, 1000, 0, 1000);
		
		juego.construirEstructura("Barraca",posicionLibre);
		
		
		
		
		
		
	}

}
