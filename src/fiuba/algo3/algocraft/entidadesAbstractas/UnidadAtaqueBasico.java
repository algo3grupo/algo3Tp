package fiuba.algo3.algocraft.entidadesAbstractas;

import java.util.ArrayList;

import fiuba.algo3.algocraft.Interfaces.IAtacar;
import fiuba.algo3.algocraft.atributos.Ataque;
import fiuba.algo3.algocraft.atributos.Costo;
import fiuba.algo3.algocraft.atributos.Vida;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesAereas;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesEnTierra;
import fiuba.algo3.algocraft.excepciones.NoPuedeRealizarEsaAccion;
import fiuba.algo3.algocraft.excepciones.NoSePuedeAtacarEstaFueraDeRango;
import fiuba.algo3.algocraft.jugador.Jugador;
import fiuba.algo3.algocraft.vector2D.Vector2D;

public abstract class UnidadAtaqueBasico extends Unidad implements IAtacar {
	
	private Ataque ataque;

	public UnidadAtaqueBasico(int dimension, Vector2D posicion, Vida vida, int rangoDeVision, Jugador jugador, String nombre, Costo costo, String requiere, int suministro, 
			int transporte, int turnos, Ataque ataque) 
	{
		super(dimension, posicion, vida, rangoDeVision, jugador, nombre, costo, requiere, suministro, transporte, turnos);
		this.ataque = ataque;
	}
	
	public void atacar( Entidad entidad ) throws NoSePuedeAtacarEstaFueraDeRango, NoPuedeAtacarUnidadesEnTierra, NoPuedeAtacarUnidadesAereas{
		
		int distancia = (int) obtenerPosicion().distanciaA(entidad.obtenerPosicion());
		entidad.atacado(ataque, distancia);
		
		
	}

	public Ataque obtenerAtaque() {
		
		return ataque;
	}
	
	public ArrayList<String> mostrarAcciones(){
		ArrayList<String> listaAcciones = super.mostrarAcciones();
		listaAcciones.add("Atacar");
		return listaAcciones;
	}

	public void realizarAccion(String accion, Entidad destino) throws NoPuedeRealizarEsaAccion{
		
		switch (accion){
			case "Atacar": try {
								atacar(destino);
							} catch (NoSePuedeAtacarEstaFueraDeRango
									| NoPuedeAtacarUnidadesEnTierra
									| NoPuedeAtacarUnidadesAereas e) {
								e.printStackTrace();
								throw new NoPuedeRealizarEsaAccion();
							}
							break;
			default: super.realizarAccion(accion, destino); 
		}
		
	}
}
