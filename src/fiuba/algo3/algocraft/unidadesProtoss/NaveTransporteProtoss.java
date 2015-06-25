package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.Acciones.RecuperarCampo;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadNave;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class NaveTransporteProtoss extends UnidadNave{

	public NaveTransporteProtoss(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, new VidaConEscudo(80, 60), 8, jugador, new Costo(100,0), 2, 8);
		
		setNombre("NaveTransporteProtoss");
	
		agregarAccion(new RecuperarCampo(this));
	}
	

}
