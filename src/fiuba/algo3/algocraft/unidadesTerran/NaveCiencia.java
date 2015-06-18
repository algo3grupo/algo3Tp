package fiuba.algo3.algocraft.unidadesTerran;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;

import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.entidadesAbstractas.UnidadEnergia;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.excepciones.NoTieneEnergiaSuficiente;
import fiuba.algo3.algocraft.hechizos.EMP;
import fiuba.algo3.algocraft.hechizos.Radiacion;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.mundo.Mundo;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public class NaveCiencia extends UnidadEnergia {

	public NaveCiencia(int dimension, Vector2D posicion, Jugador jugador) {
		super(dimension, posicion, 200, 10, jugador, "Nave Ciencia", new Costo(125,50), "Puerto Estelar", 2, 0, 10);
	}

	public void lanzarEMP(Vector2D posicion, Mundo mundo) throws NoTieneEnergiaSuficiente{
		lanzarHechizo(new EMP(), posicion, mundo);
	}
	
	public void lanzarRadiacion(Vector2D posicion, Mundo mundo) throws NoTieneEnergiaSuficiente{
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
			case "LanzarRadiacion": //hay que solucionar tema de parametros.
				
							break;
							
			case "LanzarEMP": 
							break;
							
			default:	super.realizarAccion(accion, destino);
						break;
		}
	}
	
	
	@Override
	public void dibujar(Graphics contexto) {
		// TODO Auto-generated method stub
		
	}

}
