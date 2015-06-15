package fiuba.algo3.algocraft.estructuraTest;

import static org.junit.Assert.*;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Terran;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class EstructuraTerranTest {

	@Test
	public void correlacionPuertoEstelarNecesitaFabrica() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Terran(null,"Pepe","#FF0000");
		jugador.agregarMineral(2300);
		jugador.agregarGas(2500);
		try {
			jugador.agregarEstructura(null,"Deposito Suministro", new Vector2D(), null);
			jugador.agregarEstructura(null,"Barraca", new Vector2D(), null);
			jugador.agregarEstructura(null,"Puerto Estelar", new Vector2D(), null);
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		} catch ( NoTieneLaEstructuraCreadaException e){}
		
	}
	
	@Test
	public void correlacionFabricaNecesitaBarraca() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Terran(null,"Pepe","#FF0000");
		jugador.agregarMineral(2300);
		jugador.agregarGas(2500);
		try {
			jugador.agregarEstructura(null,"Deposito Suministro", new Vector2D(), null);
			jugador.agregarEstructura(null,"Fabrica", new Vector2D(), null);
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		}  catch ( NoTieneLaEstructuraCreadaException e){}
		
	}

}
