package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.Acciones.RecuperarCampo;
import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class Dragon extends UnidadAtaqueBasico {

	public Dragon(int dimension, Vector2D posicion, Jugador jugador) {
		
		super(dimension, posicion, new VidaConEscudo(100,80), 1, jugador, "Dragon", new Costo(125,50), "Acceso", 2 , 4, 6 ,new Ataque(20, 20, 4*dimension, 4*dimension));
		
		agregarAccion(new RecuperarCampo(this));
	
	}


}
