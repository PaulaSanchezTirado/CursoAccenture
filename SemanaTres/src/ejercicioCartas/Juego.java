package ejercicioCartas;

import java.util.HashSet;
import java.util.Set;

public class Juego {
	
	static final String TIPO_BARAJA = Baraja.POKER;
	static Set<Jugador> jugadores;
	
	public static void main(String[] args) {
		
		Baraja baraja = new Baraja(TIPO_BARAJA);
		
		System.out.println("\n--------------------------Baraja--------------------------\n");
		baraja.getBaraja().forEach(System.out::println);
		
		System.out.println("\n--------------------------Jugadores--------------------------\n");
		jugadores = recibirJugadores();
		visualizarJugadores(jugadores);
		
		System.out.println("\n--------------------------Jugador pedido--------------------------\n");
		visualizarJugador(jugadores, 0); // Si quieres el jugador número 1
		
	}
	
	public static Set<Jugador> recibirJugadores() {
		Set<Jugador> jugadoresSet = new HashSet<>();
		jugadoresSet.add(new Jugador("Paula", 23));
		jugadoresSet.add(new Jugador("Sergio", 28));
		jugadoresSet.add(new Jugador("Natalia", 23));
		jugadoresSet.add(new Jugador("Pedro", 30));
		
		return jugadoresSet;
	}
	
	public static void reparte() {
		
	}
	
	public static void visualizarJugadores(Set<Jugador> jugadoresV) {
		jugadoresV.forEach(System.out::println);
	}
	
	
	public static void visualizarJugador(Set<Jugador> jugadoresV, int index) {	
		System.out.println(jugadoresV.toArray()[index]);
		
	}
}
