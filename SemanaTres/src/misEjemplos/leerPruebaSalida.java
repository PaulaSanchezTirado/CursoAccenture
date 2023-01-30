package misEjemplos;

/**
 * Ejemplos de Entrada-salida en Java
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class leerPruebaSalida {
	
	/**
	 * Lee el fichero creado en la clase pruebaSalida
	 * @param args
	 * @throws IOException
	 */

	public static void main(String[] args) throws IOException {
		
		/*
		String carpeta = "C:\\Trabajo\\cursoAccenture\\SemanaTres\\";
		String archivo = "nombreApellido.txt";
		
		File fichero = new File(carpeta+archivo);
		
		try (Scanner leerFichero = new Scanner(fichero)){ 
		leerFichero.useDelimiter("\n");
		while (leerFichero.hasNext()) {
			String cadena = leerFichero.next();
			System.out.println(cadena);
		}
		
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		*/
		
		File doc = new File("C:\\Trabajo\\cursoAccenture\\SemanaTres\\nombreApellido.txt");

	    BufferedReader obj = new BufferedReader(new FileReader(doc));

	    String cadena;
	    while ((cadena = obj.readLine()) != null) {
	    	System.out.println(cadena);
	    }
		
	}

}
