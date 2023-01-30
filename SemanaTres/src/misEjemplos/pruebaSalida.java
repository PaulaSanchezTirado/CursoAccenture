package misEjemplos;

/**
 * Ejemplos de Entrada-salida en Java
 */

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class pruebaSalida {
	
	/**
	 * Crea un fichero .txt con el nombre y apellido que se le introduzca por scanner
	 * @param args
	 */

	public static void main(String[] args) {
		
		FileWriter fichero = null;
		PrintWriter pw = null;
		
		try (Scanner teclado = new Scanner(System.in)) {
			
			String nombre, apellido;
			
			System.out.println("Introduzca su nombre: ");
			nombre = teclado.next(); 
			teclado.nextLine(); 
			
			System.out.println("Introduzca su apellido: ");
			apellido = teclado.next();
			teclado.nextLine();
			
			try {
				fichero = new FileWriter("C:\\Trabajo\\cursoAccenture\\SemanaTres\\nombreApellido.txt");
				pw = new PrintWriter(fichero);
				
				pw.print("Nombre = "+nombre+"\nApellido = "+apellido);
			}
			catch (IOException e) {
				e.printStackTrace();
			}
			finally {
				try {
					if (null!=fichero) {
						fichero.close();
					}
				}
				catch (Exception e2) {
					e2.printStackTrace();
				}
			}
			
		}

	}

}
