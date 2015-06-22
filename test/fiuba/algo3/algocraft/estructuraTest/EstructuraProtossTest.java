package fiuba.algo3.algocraft.estructuraTest;

import static org.junit.Assert.*;

import java.awt.Color;

import org.junit.Test;

import fiuba.algo3.algocraft.excepciones.ErrorAlHacerCopia;
import fiuba.algo3.algocraft.excepciones.NoEsDeSuRazaLaEstructuraException;
import fiuba.algo3.algocraft.excepciones.NoHayGasEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHayMineralEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoHaySuministroEnElLugarACrear;
import fiuba.algo3.algocraft.excepciones.NoTieneLaEstructuraCreadaException;
import fiuba.algo3.algocraft.excepciones.NoTieneRecursosSuficientesException;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.jugador.Protoss;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.pasaTurnos.PasaTurnos;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class EstructuraProtossTest {

	@Test
	public void correlacionPuertoEstelarNecesitaAcceso() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Protoss(100,new Vector2D(100,100),"Pepe",new Color(0),new Mundo(1000, 1000, null));
		jugador.agregarMineral(100);
		jugador.agregarGas(300);
		try {
	
				jugador.agregarEstructura("Puerto Estelar", new Vector2D());
		
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				| NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear
				| NoHaySuministroEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		} catch ( NoTieneLaEstructuraCreadaException e){
			assert (true);
		}
		
	}
	
	@Test
	public void correlacionArchivosTemplariosNecesitaPuertoEstelarYNoLaTiene() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Protoss(100,new Vector2D(100,100),"Pepe",new Color(0),new Mundo(1000, 1000, null));
		jugador.agregarMineral(250);
		jugador.agregarGas(350);
		try {
			jugador.agregarEstructura("Acceso", new Vector2D());
			jugador.agregarEstructura("Archivos Templarios", new Vector2D());
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				|NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear
				| NoHaySuministroEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		}  catch ( NoTieneLaEstructuraCreadaException e){}
		
	}
	
	@Test
	public void correlacionArchivosTemplariosNecesitaPuertoEstelarQueNoSeTerminoDeConstruir() throws ErrorAlHacerCopia {
		
		Jugador jugador= new Protoss(100,new Vector2D(100,100),"Pepe",new Color(0),new Mundo(1000, 1000, null));
		jugador.agregarMineral(250);
		jugador.agregarGas(350);
		try {
			jugador.agregarEstructura("Puerto Estelar", new Vector2D());
			jugador.agregarEstructura("Archivos Templarios", new Vector2D());
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				|NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear
				| NoHaySuministroEnElLugarACrear e) {
			fail("Deberia tirar error de estructura no creada");
		}  catch ( NoTieneLaEstructuraCreadaException e){}
		
	}
	
	@Test
	public void correlacionArchivosTemplariosNecesitaPuertoEstelarYLoTiene() throws Exception {
		
		Jugador jugador= new Protoss(100,new Vector2D(100,100),"Pepe",new Color(0),new Mundo(1000, 1000, null));
		jugador.agregarMineral(250);
		jugador.agregarGas(350);
		try {
			jugador.agregarEstructura("Acceso", new Vector2D());
			PasaTurnos.pasarTurnos(jugador, 8);
			jugador.agregarEstructura("Puerto Estelar", new Vector2D());
			PasaTurnos.pasarTurnos(jugador, 10);
			jugador.agregarEstructura("Archivos Templarios", new Vector2D());
		} catch (NoEsDeSuRazaLaEstructuraException
				| NoTieneRecursosSuficientesException
				|NoHayMineralEnElLugarACrear 
				| NoHayGasEnElLugarACrear 
				|NoTieneLaEstructuraCreadaException e) {
			throw e;
		} 
		
		assert(true);
		
	}
}
