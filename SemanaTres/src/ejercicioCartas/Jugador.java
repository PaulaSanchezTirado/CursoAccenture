package ejercicioCartas;

import java.util.Set;
import java.util.HashSet;

public class Jugador {
	
	private String nombre;
	private int edad;
	private Set<Cartas> mano;
	
	public Jugador() {
		mano = new HashSet<>();
	}
	
	public Jugador(String nombre, int edad) {
		this.nombre = nombre;
		this.edad = edad;
	}

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
	
	@Override
	public String toString() {
		return "Jugador [nombre=" + nombre + ", edad=" + edad + ", mano=" + mano + "]";
	}
	
}
