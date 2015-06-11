package fiuba.algo3.algocraft.pasaTurnos;

import fiuba.algo3.algocraft.jugador.Jugador;

public abstract class PasaTurnos {
	
	public static void pasarTurnos(Jugador jugador, int i){
		
		for ( int j = 0; j < i; j++){
			jugador.terminarTurno();
		}
		
	}

}
