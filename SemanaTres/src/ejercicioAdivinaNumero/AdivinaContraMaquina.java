package ejercicioAdivinaNumero;

import java.util.Scanner;

public class AdivinaContraMaquina {
	
	static String elegir;
	static int limitInferior = 0;
	static int limitSuperior = 1000;
	static int numeroIntroducidoMaquina;
	static int numeroMaquina;
	static int miNumeroIntroducido;
	static boolean finMiJuego = false;
	static boolean finMaquinaJuego = false;
	
	public static void main(String[] args) {
		
		Scanner teclado = new Scanner(System.in);
		
		while(!finMiJuego && !finMaquinaJuego) {
			
			numeroIntroducidoMaquina = (int) (Math.random()*1000)+1;
			numeroMaquina = (int) (Math.random()*1000)+1;
			
			while (!finMaquinaJuego) {	
				
				System.out.println("Está jugando la máquina. El número que ha introducido la máquina es: "+numeroIntroducidoMaquina+
						"\nElige: (M)ayor (m)enor (F)in");
				elegir = teclado.next();
				adivinaMaquina();
				
				if(!finMiJuego && !finMaquinaJuego) {
					
					System.out.println("Estás jugando tú. Introduce un número");
					miNumeroIntroducido = teclado.nextInt();
					adivinoYo();
					
				}
			}
		}
		
	}
	
	public static void adivinaMaquina() {
		
		
		if (elegir.equals("M")) {
			
			limitInferior = numeroIntroducidoMaquina + 1;
		
		}
		
		else if (elegir.equals("m")){
			
			limitSuperior = numeroIntroducidoMaquina - 1;
		
		}

		numeroIntroducidoMaquina = (limitSuperior+limitInferior)/2; 
		
		if (elegir.equals("F")){
			
			finMaquinaJuego = true;
			System.out.println("La maquina ha adivinado el número.");
		
		}
	}
	
	public static void adivinoYo() {
		
		if(miNumeroIntroducido<numeroMaquina) {
			
			System.out.println("El número a adivinar es mayor");
			
		}
		else if (miNumeroIntroducido>numeroMaquina) {
			
			System.out.println("El número a adivinar es menor");
		
		}
		
		else {
			
			finMiJuego = true;
			System.out.println("¡Enhorabuena! Has acertado el número. El número correcto es: "+numeroMaquina);
		
		}
		
	}

}
