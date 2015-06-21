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
		agregarEntidad( new Barraca(0,new Vector2D(), jugador) );
		agregarEntidad( new CentroDeMineral(0,new Vector2D(), jugador) );
		agregarEntidad( new DepositoSuministro(0, new Vector2D(), jugador) );
		agregarEntidad( new Fabrica(0, new Vector2D(), jugador) );
		agregarEntidad( new Refineria(0, new Vector2D(), jugador) );
		agregarEntidad( new PuertoEstelarT(0, new Vector2D(), jugador) );
	}
}
