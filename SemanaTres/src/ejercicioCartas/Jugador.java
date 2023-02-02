package ejercicioCartas;

/**
 * Juego de Póker
 */

import java.util.Set;
import java.util.HashSet;

public class Jugador {
	
	private String nombre;
	private int edad;
	private Set<Cartas> mano = new HashSet<>();
	
	// Constructores
	public Jugador() {
	}
	
	public Jugador(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;	
	}
	
	// Getters y setters
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public Set<Cartas> getMano() {
		return mano;
	}

	public void setMano(Set<Cartas> mano) {
		this.mano = mano;
	}
	
	public void setCarta(Cartas carta) {
		mano.add(carta);
	}
	
	@Override
	public String toString() {
		return "Jugador: " + nombre + ". Edad: " + edad + " Mano:\n" + mano;
	}
}
