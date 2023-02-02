package ejercicioCartas;

/**
 * Juego de Póker
 * @author paula.sanchez.tirado
 *
 */

public class Cartas {
		
	int numero;
	String palo;
	
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getPalo() {
		return palo;
	}
	public void setPalo(String palo) {
		this.palo = palo;
	}
	
	@Override
	public String toString() {
		return "Carta [palo="+palo+" Número="+numero+"]";
	}

}
