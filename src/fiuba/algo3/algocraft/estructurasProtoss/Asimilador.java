package fiuba.algo3.algocraft.estructurasProtoss;

import java.util.ArrayList;

import fiuba.algo3.algocraft.Acciones.RecogerSuministro;
import fiuba.algo3.algocraft.Acciones.RecuperarCampo;
import fiuba.algo3.algocraft.Interfaces.IRecolectores;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.entidadesAbstractas.Estructura;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Asimilador extends Estructura implements IRecolectores {
	
	public Asimilador(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, new VidaConEscudo(450, 450), 0, jugador, "Asimilador", new Costo(50,0), "", 8);
		
		agregarAccion(new RecogerSuministro(this));
		agregarAccion(new RecuperarCampo(this));
	}
	
	public void recolectarSuministro()
	{
		getJugador().agregarGas(10);
	}

	public ArrayList<String> obtenerUnidadesCreables() 
	{
		return new ArrayList<String>();
	}

	
	public boolean haySuministroEn(Vector2D posicion) {
		
		return getJugador().getMundo().hayGas(posicion);
	}
	
}
