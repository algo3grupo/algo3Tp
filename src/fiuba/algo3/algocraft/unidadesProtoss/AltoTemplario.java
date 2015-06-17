package fiuba.algo3.algocraft.unidadesProtoss;

import java.awt.Graphics;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Acciones.PerduracionTormenta;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.excepciones.NoTieneEnergiaSuficiente;
import fiuba.algo3.algocraft.hechizos.Alucinacion;
import fiuba.algo3.algocraft.hechizos.TormentaPsiconica;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class AltoTemplario extends UnidadEnergia {

	public AltoTemplario(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 40, 7, jugador, "Alto Templario", new Costo(100,0), "Archivos Templarios", 2, 2, 7);
	}

	public void lanzarTormentaPsiconica(Vector2D posicion, Mundo mundo) throws NoTieneEnergiaSuficiente{
		
		
		lanzarHechizo(new TormentaPsiconica(), posicion, mundo);
		this.agregarAccion(new PerduracionTormenta(posicion, mundo, new TormentaPsiconica()));
		
	}
	
	public void lanzarAlucinacion(Vector2D posicion, Mundo mundo) throws NoTieneEnergiaSuficiente{
		lanzarHechizo(new Alucinacion(), posicion, mundo);
		
	}
	
	@Override
	public void dibujar(Graphics contexto) {
		// TODO Auto-generated method stub
		
	}

}
