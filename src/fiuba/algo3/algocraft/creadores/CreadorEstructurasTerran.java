package fiuba.algo3.algocraft.creadores;

import fiuba.algo3.algocraft.estructurasTerran.Barraca;
import fiuba.algo3.algocraft.estructurasTerran.CentroDeMineral;
import fiuba.algo3.algocraft.estructurasTerran.DepositoSuministro;
import fiuba.algo3.algocraft.estructurasTerran.Fabrica;
import fiuba.algo3.algocraft.estructurasTerran.PuertoEstelarT;
import fiuba.algo3.algocraft.estructurasTerran.Refineria;
import fiuba.algo3.algocraft.jugador.Jugador;

public class CreadorEstructurasTerran extends CreadorEstructuras {
	
	public CreadorEstructurasTerran(Jugador jugador){
		super();
		entidades.add( new Barraca(jugador) );
		entidades.add( new CentroDeMineral(jugador) );
		entidades.add( new DepositoSuministro(jugador) );
		entidades.add( new Fabrica(jugador) );
		entidades.add( new Refineria(jugador) );
		entidades.add( new PuertoEstelarT(jugador) );
	}
}
