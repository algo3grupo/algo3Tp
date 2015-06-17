package fiuba.algo3.algocraft.atributos;

import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesAereas;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesDeEsteTipo;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesEnTierra;

public class Ataque {
	private int ataqueTierra;
	private int ataqueAereo;
	private int rangoAtaqueA;
	private int rangoAtaqueT;
	
	public Ataque(int ataqueT, int ataqueA, int rangoT, int rangoA){
		ataqueTierra = ataqueT;
		ataqueAereo = ataqueA;
		rangoAtaqueT = rangoT;
		rangoAtaqueA = rangoA;
	}

	public int danioTierra() {
		
		return ataqueTierra;
	}
	
	public int danioAereo(){
		
		return ataqueAereo;
	}
	
	public boolean estaEnRangoTierra(int distancia) throws NoPuedeAtacarUnidadesEnTierra{
		
		try {
			
			return estaEnRango(distancia,rangoAtaqueT);
			
		} catch (NoPuedeAtacarUnidadesDeEsteTipo e) {
			
			throw new NoPuedeAtacarUnidadesEnTierra();
		}
	}
	
	public boolean estaEnRangoAire(int distancia) throws NoPuedeAtacarUnidadesAereas{
		
		try {
			
			return estaEnRango(distancia,rangoAtaqueA);
			
		} catch (NoPuedeAtacarUnidadesDeEsteTipo e) {
			
			throw new NoPuedeAtacarUnidadesAereas();
		}
	}
	
	private boolean estaEnRango(int distancia, int rango) throws NoPuedeAtacarUnidadesDeEsteTipo{
		
		if ( distancia <= rango ){
			return true;
		}
		if (rango == 0){
			throw new NoPuedeAtacarUnidadesDeEsteTipo();
		}
		return false;
	}
	
	public void modificarAtaque(int danioT, int danioA){
		//solo para ser usado por la unidad copia
		ataqueTierra = danioT;
		ataqueAereo = danioA;
	}
}
