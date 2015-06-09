package fiuba.algo3.algocraft.unidadesProtoss;

import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadAtaqueBasico;
import fiuba.algo3.algocraft.jugador.Jugador;

public class Dragon extends UnidadAtaqueBasico {

	public Dragon(Jugador jugador) {
		
		super( 100, 1, jugador, "Dragon", new Costo(125,50), "Acceso", 2 , 4, 6 ,new Ataque(20, 20, 4, 4));
		
	}

}
