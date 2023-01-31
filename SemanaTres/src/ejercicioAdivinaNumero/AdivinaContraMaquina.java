package ejercicioAdivinaNumero;

import java.util.Scanner;

public class AdivinaContraMaquina {
	
	static int miNumeroIntroducido;
	static int random;
	static int numeroIntroducidoMaquina;
	static boolean finJuego;
	
	public static void main(String[] args) {
		
		while(!finJuego) {
			adivinaMaquina();
			if(!finJuego) {
				adivinoYo();
			}
		}
		
	}
	
	public static void adivinaMaquina() {
		
		random = (int) (Math.random()*100); //Mi random
		numeroIntroducidoMaquina = (int) (Math.random()*100);//El número random que proporciona la máquina
		
		//Scanner teclado = new Scanner(System.in);
		
		System.out.println("Mi número es: "+random);
		
		if(numeroIntroducidoMaquina<random) {
			System.out.println("Mi número es mayor");
		}
		
		else {
			System.out.println("Mi número es menor");

		}
		
	}
	
	public static void adivinoYo() {
		
		Scanner teclado = new Scanner(System.in);
		
		System.out.println("Introduce un número: ");
		miNumeroIntroducido = teclado.nextInt(); 
		teclado.nextLine();
		
		if(miNumeroIntroducido<random) {
			System.out.println("Mayor");
			System.out.println("Introduce un número: ");
			miNumeroIntroducido = teclado.nextInt(); 
			teclado.nextLine();
		}
		else {
			System.out.println("Menor");
			System.out.println("Introduce un número: ");
			miNumeroIntroducido = teclado.nextInt(); 
			teclado.nextLine();
		}
		
		System.out.println("¡Enhorabuena! Has acertado el número. El número correcto es: "+random);
	}

}
