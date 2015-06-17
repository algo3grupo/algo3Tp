package fiuba.algo3.algocraft.Interfaces;

import fiuba.algo3.algocraft.entidadesAbstractas.Entidad;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesAereas;
import fiuba.algo3.algocraft.excepciones.NoPuedeAtacarUnidadesEnTierra;
import fiuba.algo3.algocraft.excepciones.NoSePuedeAtacarEstaFueraDeRango;

public interface IAtacar {
	
	public void atacar( Entidad entidad ) throws NoSePuedeAtacarEstaFueraDeRango, NoPuedeAtacarUnidadesEnTierra, 
														NoPuedeAtacarUnidadesAereas;
}
