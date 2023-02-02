package ejercicioCartas;

/**
 * Juego de Póker
 */

import java.util.HashSet;
import java.util.Set;

public class Baraja {
	
	private Set<Cartas> baraja = new HashSet<>(); // Set no deja tener ningún repetido (List sí)
	
	static final String ESP = "ESP";
	static final String POKER = "POKER";
	
	static final String[] PALOS_POKER = {"Diamantes", "Corazones", "Tréboles", "Picas"}; 
	static final String[] PALOS_ESP = {"Oros", "Copas", "Espadas", "Bastos"};
	
	public Baraja( String eleccionBaraja) {
		
		String[] palos;
		
		// Elegimos la baraja con la que se va a jugar
		if (eleccionBaraja.equals(POKER)) {
			palos = PALOS_POKER;
		}
		
		else {
			palos = PALOS_ESP;
		}
		
		for (String palo:palos) {
			for (int i=1;i<15;i++) {
				Cartas carta = new Cartas();
				carta.setNumero(i); // Se añade el número
				carta.setPalo(palo); // Se añade el palo
				baraja.add(carta); // Añadimos a la baraja la carta
			
			}
		}

	}

	public Set<Cartas> getBaraja() {
		return baraja;
	}

	public void setBaraja(Set<Cartas> baraja) {
		this.baraja = baraja;
	}
	
}
