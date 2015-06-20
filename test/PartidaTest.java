import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.Juego;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.excepciones.FinDeLaPartida;
import fiuba.algo3.excepciones.NoLePerteneceLaEntidad;

public class PartidaTest {

	@Test(expected = FinDeLaPartida.class)
	public void unaPartidaCompleta() throws NoLePerteneceLaEntidad {
		
		Juego juego = new Juego("Protoss","Martin","#FF0000","Terran","Damian","#0000FF");
		
		Mundo mundo = juego.obtenerMundo();
		
		/*Turno 1: Jugador 1 crea un nexo mineral*/
		
		juego.construirEstructura("Nexo Mineral", mundo.mineralesCercanos(mundo.posicionBaseJugador1()).get(0).obtenerPosicion()); 
		
		juego.finalizarTurno();
		
		/*Turno 2: Jugador 2 crea un centro mineral y una refineria.*/
		
		juego.construirEstructura("Centro De Minerales", mundo.mineralesCercanos(mundo.posicionBaseJugador2()).get(0).obtenerPosicion());
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
		
		//Turno 201: Comienza la creacion de unidades y la batalla.
		
		for (int j = 0; j < 5; j++){
			juego.crearUnidad("Zealot",null);
		}
		juego.finalizarTurno();
		
		//Turno 202:Crea UnidadesElJugadorTerran
		
		for (int j = 0; j < 5; j++){
			juego.crearUnidad("Marine",null);
		}
		
		for(int i=202;i<=209;i++)
			juego.finalizarTurno();
		
		//Turno 210: Mueve Unidades A Unas Posiciones
		Vector2D posicion1 = new Vector2D(2500,50);
		for (int j= 0; j< 5; j++){
			Unidad unidad= juego.obtenerUnidadesTurno().get(j);
			juego.moverUnidad(unidad,posicion1);
		}
		juego.finalizarTurno();
		
		//Turno 211: Mueve Unidades A Posiciones Cercanas del otro
		Vector2D posicion2 = new Vector2D(2500,51);
		for (int j= 0; j< 5; j++){
			Unidad unidad= juego.obtenerUnidadesTurno().get(j);
			juego.moverUnidad(unidad,posicion2);
		}
		juego.finalizarTurno();
		
		//Turno 212-222: Cada Marine ataca a un Zealot, cada Zealot ataca a un Marine Matando a los marines en el 5 turno.
		for (int k=0; k<9; k++){
			for (int j= 0; j< 5; j++){
				Unidad enemiga = juego.obtenerUnidadesContrarias().get(j);
				UnidadAtaqueBasico atacadora = (UnidadAtaqueBasico) juego.obtenerUnidadesTurno().get(j);
				juego.unidadAtaqueAtacaA(atacadora, enemiga);
			}
			juego.finalizarTurno();
		}
		
		for (int j= 0; j< 5; j++){
			//como las va eliminando siempre se ataca a la primera de la lista que quedo viviendo
			Unidad enemiga = juego.obtenerUnidadesContrarias().get(0);
			UnidadAtaqueBasico atacadora = (UnidadAtaqueBasico) juego.obtenerUnidadesTurno().get(j);
			juego.unidadAtaqueAtacaA(atacadora, enemiga);
		}
		assertEquals(juego.obtenerUnidadesContrarias().size(), 0);
		
		for (int i=0; i<2; i++){
			juego.finalizarTurno();
		}
		//Turno 223 en adelante: Los Zealot se acercan a las 4 estructuras y las destruyen una a una
		//al moverse se posicionan en el mismo lugar pero si mover lo mueve lo mas cerca posible deberia poder atacarlo
		
		for ( int l = 0; l< 4; l++){
			
			Estructura enemiga= juego.obtenerEstructurasContrarias().get(0);
			Vector2D posicion = juego.obtenerPosicion(juego.obtenerEstructurasContrarias().get(0));
		
			for (int j= 0; j< 5; j++){
				//muevo unidades a la estructura
				UnidadAtaqueBasico atacadora = (UnidadAtaqueBasico) juego.obtenerUnidadesTurno().get(j);
				juego.moverUnidad(atacadora,posicion);		
			}
		
			while (juego.obtenerEstructurasContrarias().size()== 4-l) {
				//atacan una vez por turno, y cuandola destruyen el ciclo empieza otra vez
				for (int j= 0; j< 5; j++){
					UnidadAtaqueBasico atacadora = (UnidadAtaqueBasico) juego.obtenerUnidadesTurno().get(j);
					juego.unidadAtaqueAtacaA(atacadora,enemiga);		
				}	
		
				for (int k=0; k<2; k++){
					//pasa dos turnos asi le vuelve a tocar al mismo
					juego.finalizarTurno();
				}
			}
		}
		
		
		
	}

}
