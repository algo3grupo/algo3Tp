package fiuba.algo3.algocraft.estructuraTest;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Terran;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class EstructuraTerranTest {

	@Test
	public void correlacionPuertoEstelarNecesitaFabrica() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Terran(0,new Vector2D(100,100),"Pepe",new Color(0),new Mundo(1000, 1000, null));
		jugador.agregarMineral(2300);
		jugador.agregarGas(2500);
		try {
			jugador.agregarEstructura("Deposito Suministro", new Vector2D());
			jugador.agregarEstructura("Barraca", new Vector2D());
			jugador.agregarEstructura("Puerto Estelar", new Vector2D());
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		} catch ( NoTieneLaEstructuraCreadaException e){}
		
	}
	
	@Test
	public void correlacionFabricaNecesitaBarraca() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Terran(0,new Vector2D(100,100),"Pepe",new Color(0),new Mundo(1000, 1000, null));
		jugador.agregarMineral(2300);
		jugador.agregarGas(2500);
		try {
			jugador.agregarEstructura("Deposito Suministro", new Vector2D());
			jugador.agregarEstructura("Fabrica", new Vector2D());
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		}  catch ( NoTieneLaEstructuraCreadaException e){}
		
	}

}
