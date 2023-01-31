package grabarLectura;

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
		
		File doc = new File("C:\\Trabajo\\FormacionAccenture\\SemanaTres\\nombreApellido.txt");

	    BufferedReader obj = new BufferedReader(new FileReader(doc));

	    String cadena;
	    String nombre="";
	    String apellido="";
	    while ((cadena = obj.readLine()) != null) {
	    	String[] cadena_string = cadena.split("=");
	    	if (cadena_string[0].equals("Nombre")) { // Ejercicio corregido. Faltaba esta comprobación
	    		nombre=cadena_string[1];
	    	}
	    	if (cadena_string[0].equals("Apellido")) {
	    		apellido=cadena_string[1];
	    	}
	    }
	    
	    System.out.println(nombre+" "+apellido);
		
	}

}
