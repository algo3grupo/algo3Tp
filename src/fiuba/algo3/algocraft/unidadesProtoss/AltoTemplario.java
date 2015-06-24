package fiuba.algo3.algocraft.unidadesProtoss;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.Acciones.PerduracionTormenta;
import fiuba.algo3.algocraft.Interfaces.IEfectoEMP;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.entidadesAbstractas.Unidad;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.excepciones.NoEsPosibleCargarEstaUnidad;
import fiuba.algo3.algocraft.excepciones.NoEsPosibleLanzarElHechizoAlli;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.excepciones.NoTieneEnergiaSuficiente;
import fiuba.algo3.algocraft.hechizos.Alucinacion;
import fiuba.algo3.algocraft.hechizos.TormentaPsiconica;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class AltoTemplario extends UnidadEnergia {

	public AltoTemplario(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, new VidaConEscudo(40,40), 7, jugador, "AltoTemplario", new Costo(100,0), "Archivos Templarios", 2, 2, 7);
		
	}

	public void lanzarTormentaPsiconica(Vector2D posicion, Mundo mundo) throws NoTieneEnergiaSuficiente,
																	NoEsPosibleLanzarElHechizoAlli{
		
		
		lanzarHechizo(new TormentaPsiconica(), posicion, mundo);
		this.agregarAccion(new PerduracionTormenta(posicion, mundo, new TormentaPsiconica()));
		
	}
	
	public void lanzarAlucinacion(Vector2D posicion, Mundo mundo) throws NoTieneEnergiaSuficiente, NoEsPosibleLanzarElHechizoAlli{
		lanzarHechizo(new Alucinacion(), posicion, mundo);
		
	}
	
	public ArrayList<String> mostrarAcciones(){
		ArrayList<String> listaAcciones = super.mostrarAcciones();
		listaAcciones.add("LanzarTormentaPsiconica");
		listaAcciones.add("LanzarAlucinacion");
		
		return listaAcciones;
		
	}
	
	public void realizarAccion(String accion, Entidad destino) throws NoPuedeRealizarEsaAccion {
		switch (accion){
			case "LanzarTormentaPsiconica": 
					try {
						lanzarTormentaPsiconica(destino.obtenerPosicion(),destino.getJugador().getMundo());
					} catch (NoTieneEnergiaSuficiente | NoEsPosibleLanzarElHechizoAlli e) {
					
						throw new NoPuedeRealizarEsaAccion();
					}
					break;
							
			case "LanzarAlucinacion":
					try {
						lanzarAlucinacion(destino.obtenerPosicion(),destino.getJugador().getMundo());
					} catch (NoTieneEnergiaSuficiente | NoEsPosibleLanzarElHechizoAlli e) {
						
						throw new NoPuedeRealizarEsaAccion();
					}
					break;
							
			default:	super.realizarAccion(accion, destino);
						break;
		}
	}

}
