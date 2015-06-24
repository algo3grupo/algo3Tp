package fiuba.algo3.algocraft.excepciones;

public class FinDeLaPartida extends RuntimeException {
	
	private String ganador;
	
	public FinDeLaPartida(String nombreJugadorGanador)
	{
		ganador = nombreJugadorGanador;
	}

	public String obtenerGanador() 
	{
		return ganador;
	}

}
