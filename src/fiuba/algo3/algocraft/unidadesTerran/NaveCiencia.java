package fiuba.algo3.algocraft.unidadesTerran;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.excepciones.NoEsPosibleLanzarElHechizoAlli;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.excepciones.NoTieneEnergiaSuficiente;
import fiuba.algo3.algocraft.hechizos.EMP;
import fiuba.algo3.algocraft.hechizos.Radiacion;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class NaveCiencia extends UnidadEnergia {

	public NaveCiencia(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, new Vida(200), 10, jugador, "NaveCiencia", new Costo(125,50), "Puerto Estelar", 2, 0, 10);
	}

	public void lanzarEMP(Vector2D posicion, Mundo mundo) throws NoTieneEnergiaSuficiente, NoEsPosibleLanzarElHechizoAlli{
		lanzarHechizo(new EMP(), posicion, mundo);
	}
	
	public void lanzarRadiacion(Vector2D posicion, Mundo mundo) throws NoTieneEnergiaSuficiente, NoEsPosibleLanzarElHechizoAlli{
		lanzarHechizo(new Radiacion(), posicion, mundo);
	}
	
	public ArrayList<String> mostrarAcciones(){
		ArrayList<String> listaAcciones = super.mostrarAcciones();
		listaAcciones.add("LanzarRadiacion");
		listaAcciones.add("LanzarEMP");
		
		return listaAcciones;
		
	}
	
	public void realizarAccion(String accion, Entidad destino) throws NoPuedeRealizarEsaAccion{
		switch (accion){
			case "LanzarRadiacion": 
					
					try {
						lanzarRadiacion(destino.obtenerPosicion(),destino.getJugador().getMundo());
					} catch (NoTieneEnergiaSuficiente | NoEsPosibleLanzarElHechizoAlli e) {
					
						throw new NoPuedeRealizarEsaAccion();
					}
					break;
				
				
			case "LanzarEMP": 
					try {
						lanzarEMP(destino.obtenerPosicion(),destino.getJugador().getMundo());
					} catch (NoTieneEnergiaSuficiente | NoEsPosibleLanzarElHechizoAlli e) {
					
						throw new NoPuedeRealizarEsaAccion();
					}
					break;
							
			default:	super.realizarAccion(accion, destino);
						break;
		}
	}
}
