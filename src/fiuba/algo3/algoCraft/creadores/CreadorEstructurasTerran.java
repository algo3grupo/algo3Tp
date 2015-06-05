package fiuba.algo3.algoCraft.creadores;

import fiuba.algo3.algoCraft.estructurasTerran.Barraca;
import fiuba.algo3.algoCraft.estructurasTerran.CentroDeMineral;
import fiuba.algo3.algoCraft.estructurasTerran.DepositoSuministro;
import fiuba.algo3.algoCraft.estructurasTerran.Fabrica;
import fiuba.algo3.algoCraft.estructurasTerran.PuertoEstelarT;
import fiuba.algo3.algoCraft.estructurasTerran.Refineria;
import fiuba.algo3.algoCraft.jugador.Jugador;

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
