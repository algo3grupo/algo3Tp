package fiuba.algo3.algocraft.creadores;

import fiuba.algo3.algocraft.estructurasTerran.Barraca;
import fiuba.algo3.algocraft.estructurasTerran.CentroDeMineral;
import fiuba.algo3.algocraft.estructurasTerran.DepositoSuministro;
import fiuba.algo3.algocraft.estructurasTerran.Fabrica;
import fiuba.algo3.algocraft.estructurasTerran.PuertoEstelarT;
import fiuba.algo3.algocraft.estructurasTerran.Refineria;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class CreadorEstructurasTerran extends CreadorEstructuras {
	
	public CreadorEstructurasTerran(Jugador jugador){
		super();
		entidades.add( new Barraca(0,null,new Vector2D(), jugador) );
		entidades.add( new CentroDeMineral(0,null,new Vector2D(), jugador) );
		entidades.add( new DepositoSuministro(0,null, new Vector2D(), jugador) );
		entidades.add( new Fabrica(0,null, new Vector2D(), jugador) );
		entidades.add( new Refineria(0,null, new Vector2D(), jugador) );
		entidades.add( new PuertoEstelarT(0,null, new Vector2D(), jugador) );
	}
}
