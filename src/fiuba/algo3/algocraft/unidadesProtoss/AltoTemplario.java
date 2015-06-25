package fiuba.algo3.algocraft.unidadesProtoss;

import java.util.ArrayList;

import fiuba.algo3.algocraft.Acciones.PerduracionTormenta;
import fiuba.algo3.algocraft.Acciones.RecuperarCampo;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.VidaConEscudo;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
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
		
		agregarAccion(new RecuperarCampo(this));
	}

	public void lanzarTormentaPsiconica(Vector2D posicion, Mundo mundo) throws NoTieneEnergiaSuficiente,
																	NoEsPosibleLanzarElHechizoAlli{
		
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
						lanzarTormentaPsiconica(destino.obtenerPosicion(), getJugador().getMundo());
					} catch (NoTieneEnergiaSuficiente | NoEsPosibleLanzarElHechizoAlli e) {
					
						throw new NoPuedeRealizarEsaAccion();
					}
					break;
							
			case "LanzarAlucinacion":
					try {
						lanzarAlucinacion(destino.obtenerPosicion(), getJugador().getMundo());
					} catch (NoTieneEnergiaSuficiente | NoEsPosibleLanzarElHechizoAlli e) {
						
						throw new NoPuedeRealizarEsaAccion();
					}
					break;
							
			default:	super.realizarAccion(accion, destino);
						break;
		}
	}

}
