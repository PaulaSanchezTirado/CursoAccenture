package ejercicioCartas;

/**
 * Juego de Póker
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Juego {
	
	static final String TIPO_BARAJA = Baraja.POKER;
	static ArrayList<Jugador> jugadores; 
	static final int NUMERO_CARTAS = 5;
	static Set<Cartas> baraja;
	
	public static void main(String[] args) {
		
		Baraja barajaB = new Baraja(TIPO_BARAJA);
		baraja = barajaB.getBaraja();
		
		//Jugador jugador = new Jugador("Paula", 23);
		
		System.out.println("\n--------------------------Baraja--------------------------\n");
		baraja.forEach(System.out::println);
		
		jugadores = recibirJugadores();
		System.out.println("\n--------------------------Jugadores--------------------------\n");
		visualizarJugadores(jugadores);
		
		System.out.println("\n--------------------------Jugador pedido--------------------------\n");
		visualizarJugador(jugadores, 0); // Si quieres el jugador número 1
		
		System.out.println("\n--------------------------Jugadores con baraja repartida--------------------------\n");
		repartirCartas(baraja, jugadores);
		jugadores.forEach(System.out::println);
	}
	
	/**
	 * Añadimos jugadores a un array
	 * @return
	 */
	public static ArrayList<Jugador> recibirJugadores() {
		ArrayList<Jugador> jugadoresArray = new ArrayList<>();
		jugadoresArray.add(new Jugador("Paula", 23));
		jugadoresArray.add(new Jugador("Sergio", 28));
		jugadoresArray.add(new Jugador("Natalia", 23));
		jugadoresArray.add(new Jugador("Pedro", 30));
		
		return jugadoresArray;
	}
	
	/**
	 * Reparte el número de cartas que se indique a un jugador
	 * @param barajas
	 * @param jugador
	 * @param numeroCartas
	 */
	public static void repartirCartasAJugador(Set<Cartas> barajas, Jugador jugador, int numeroCartas) {
		Iterator<Cartas> iterator = barajas.iterator();
		for (int i=0; i<numeroCartas; i++) {
			jugador.setCarta(iterator.next()); // Guarda las cartas que se van dando en el jugador correspondiente
			iterator.remove(); // Se elimina la carta que se ha dado
		}	
	}
	
	/**
	 * Reparte las cinco cartas a los jugadores
	 * @param barajas
	 * @param jugadores
	 */
	public static void repartirCartas(Set<Cartas> barajas, ArrayList<Jugador> jugadores) {
		for (int i=0; i<NUMERO_CARTAS; i++) {
			// Iterator del jugador para poder ir repartiendo las cartas
			for (Iterator<Jugador> jugadorIterator = jugadores.iterator(); jugadorIterator.hasNext();) {
				repartirCartasAJugador(barajas, jugadorIterator.next(), 1); // Se van repartiendo cartas de una en una
			}
		}
	}
	
	/**
	 * Método para visualizar los jugadores
	 * @param jugadoresV
	 */
	public static void visualizarJugadores(ArrayList<Jugador> jugadoresV) {
		jugadoresV.forEach(System.out::println);
	}
	
	/**
	 * Método para visualizar al jugador que se le pida mediante el índice del mismo
	 * @param jugadoresV
	 * @param index
	 */
	public static void visualizarJugador(ArrayList<Jugador> jugadoresV, int index) {	
		System.out.println(jugadoresV.toArray()[index]);
		
	}
}
