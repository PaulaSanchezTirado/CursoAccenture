package ejercicioCartas;

import java.util.HashSet;
import java.util.Set;

public class Baraja {
	
	private Set<Cartas> baraja = new HashSet<>(); // Set no deja tener ningún repetido (List sí)
	
	public Baraja() {
		
		String[] palos = {"Oros", "Copas", "Espadas", "Bastos"};
		for (String palo:palos) {
			for (int i=1;i<13;i++) {
				Cartas carta = new Cartas();
				carta.setNumero(i);
				carta.setPalo(palo);
				baraja.add(carta);
			
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
