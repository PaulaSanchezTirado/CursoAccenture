package es.rf.tienda.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Pattern;



/********************************************************************************************
 * NOMBRE: Validator.java
 * 
 * DESCRIPCION: 
 * 			Clase auxiliar para validar los datos que sean 
 * 			introducidos en la aplicación.
 * 
 *  @version	30/01/2023 
 *  @author 	Paula Sánchez
 *  
 * ******************************************************************************************/
public class Validator {
	
	private static final String ALFANUMERIC_PATTERN = "^[0-9a-zA-Z \\áéíóú.,;]+$";
	
	private static final String PASSWORD_PATTERN = 
            "((?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%]).{6,20})";
	/**
	 * Patrón para validar el email, evitando puntos finales antes de la @ y que solo contenga
	 * carácteres alfanuméricos		 
	 */
	private final static String EMAIL_PATTERN = 
			"^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
		
	/**
	 * Permite verificar que un DNI cumple con el patrón XX.XXX.XXX-L
	 */
	private final static String DNI_PATTERN = "\\d{2}\\.\\d{3}\\.\\d{3}-[a-zA-Z]";
		
	/**
	 * Permite validar un teléfono, el cual debe contener de 10 a 20 dígitos
	 * y donde los espacios están permitidos
	 */
	private final static String PHONE_PATTERN =  "[\\d ]{10,20}";
	
	/**
	 * Orden de las letras con las cuales se comprobará la validez del DNI
	 */
	private final static String LETRA_DNI = "TRWAGMYFPDXBNJZSQVHLCKE";
	
	/**
	 * Longitud que debe tener todo DNI pasado a la aplicación.
	 */
	private final static int LONGITUD_DNI = 12;
	
	// A partir de aquí las variables son propias
	
	private final static String FORMATO_FECHA= "dd/MM/yyyy";
	private final static String PRODUCT_PATTERN = "^[A-Z]{2}[0-9]{3}$";

	/* ***************************************************************************************
	 * NOMBRE: isAlfanumeric                                                                 *
	 * 
	 * DESCRIPCIÓN: *//**
	 * 		Permite verificar que el texto pasado solo contiene caracters alfanuméricos
	 * 
	 * @param texto String a verificar que solo tenga car�cteres alfanuméricos
	 * 
	 * @return  true, si cumple solo contiene caracters alfanuméricos. <br> 
	 * 			false en caso contrario
	 * 
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Paula Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean isAlfanumeric(String texto){
		return texto.matches(ALFANUMERIC_PATTERN);	
	}
	
	// No hacer por el momento
	public static boolean isVacio( String prueba ){
		return prueba==null || prueba=="";
			
	}
	
	/* ***************************************************************************************
	 * NOMBRE: cumplePhoneNumber                                                                 *
	 * 
	 * DESCRIPCIÓN: *//**
	 * 		El phone number debe tener un total de entre 10 y 20, contando dígitos y espacios.
	 * 		Mínimo aceptable son 10 dígitos.
	 * 
	 * @param phoneNumber String con el n�mero de telefono de entre 10 y 20 dígitos. 
	 * 		Puede tener espacios, pero siempre con 10 dígitos como mínimo.
	 * 
	 * @return true, si cumple todas las condiciones
	 *
	 * FECHA: Enero 2023
	 * AUTOR: Paula Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean cumplePhoneNumber(String phoneNumber){
		return !isVacio(phoneNumber) && phoneNumber.matches(PHONE_PATTERN);
	}
		
	/* ***************************************************************************************
	 * NOMBRE: isEmailValido                                                                 *
	 * 
	 * DESCRIPCIÓN: *//**
	 * 			Comprueba si el email tiene un formato que pueda ser válido.
	 * 
	 * @param email String a comprobar
	 * 
	 * @return true, en caso que el formato sea válido
	 * FECHA: Enero 2023
	 * 
	 * AUTOR: Paula Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean isEmailValido(String email){
		return !isVacio(email) && email.matches(EMAIL_PATTERN);
	}

	/* ***************************************************************************************
	 * NOMBRE: cumpleDNI                                                                 *
	 * 
	 * DESCRIPCIÓN: *//**
	 * 			Esta función verifica que el DNI cumple el siguiente formato: xx.xxx.xxx-L <br>
	 * 			El DNI ha de tener longitud 12
	 * 
	 * @param dni String con DNI a ser validado
	 * 
	 * @return true, si el DNI cumple el estandar nacional.
	 * FECHA: Enero 2023
	 * AUTOR: Paula Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean cumpleDNI(String dni){
		if (dni.length()==12){
			if (dni.matches(DNI_PATTERN)) {
				char letra = dni.charAt(dni.length()-1);
				String dniSinLetra = dni.substring(0, 11);
				int dniInt = Integer.parseInt(dniSinLetra.replace(".", "").replace("-", ""));
				int resto = dniInt%23;
				if (letra == LETRA_DNI.charAt(resto)) {
					return true;
				}
				else {
					return false;
				}
			}
			else {
				return false;
			}
		}
		else {
			return false;
		}		
	}

	/** ***************************************************************************************
	 * NOMBRE: cumpleRango                                                                 *
	 * 
	 * DESCRIPCIÓN: *//**
	 * 		Comprueba que un Número se necuentra entre 2 valores
	 * 
	 * @param valor (int)/(double) Número a comprobar
	 * @param valorMinimo (int) Número valor aceptable
	 * @param valorMaximo (int) Número valor aceptable
	 * 
	 * @return true si valorMinimo < valor < valorMaximo
	 * FECHA: Enero 2023
	 * AUTOR: Paula Sánchez
	 * 
	 * **************************************************************************************/
	
	/*
	 * Solo es necesario el método con double
	public static boolean cumpleRango(int valor, int valorMinimo, int valorMaximo){
		return valorMinimo<valor && valor<valorMaximo; // No pone que sea igual
		
	}
	*/
	
	public static boolean cumpleRango(double valor, int valorMinimo, int valorMaximo){
		return valorMinimo<=valor && valor<=valorMaximo;
		
	}


	/* ***************************************************************************************
	 * NOMBRE: cumpleLongitudMin                                                                 *
	 * 
	 * DESCRIPCIÓN: *//**
	 * 		Comprobar que el texto pasado tiene una longitud de al menos x caracteres, siendo
	 * 		x el entero pasado como par�metro
	 * 
	 * @param texto String texto a comprobar
	 * @param longitudMinima int que indique longitud mínima.
	 * 
	 * @return cierto, si la longitud del texto es mayor o igual que longitudMinima
	 * FECHA: Enero 2023
	 * AUTOR: Paula Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMin(String texto, int longitudMinima){
		return !isVacio(texto) && longitudMinima<=texto.length();
		
	}


	/* ***************************************************************************************
	 * NOMBRE: cumpleLongitudMax                                                                 *
	 * 
	 * DESCRIPCIÓN: *//**
	 * 		Comprobar que el texto pasado tiene una longitud de, como mucho, x caracteres, siendo
	 * 		x el entero pasado como par�metro
	 * 
	 * @param texto String con el texto a comprobar
	 * @param longitudMaxima int con la longitud máxima del texto
	 * 
	 * @return true, si el texto es menor o igual que la longitud máxima.
	 * FECHA: Enero 2023 
	 * AUTOR: Paula Sánchez 
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitudMax(String texto, int longitudMaxima){
		return !isVacio(texto) && texto.length()<=longitudMaxima;
		
	}


	/****************************************************************************************
	 * NOMBRE: cumpleLongitud                                                                 *
	 * 
	 * DESCRIPCIÓN: *//**
	 * 		Comprobar que la longitud de un texto se encuentra entre unos valores máximos y mínimos 
	 * 
	 * @param texto String con el texto que a validar
	 * @param longitudMinima (int) M�nima longitud del texto
	 * @param longitudMaxima (int) M�xima longitud válida para el texo
	 * 
	 * @return true, si la longitud del texto cumple: longitudMinima
	 *               <= longitudTexto <=longitudMaxima
	 * FECHA: Enero 2023 
	 * AUTOR: Paula Sánchez
	 * 
	 * **************************************************************************************/
	public static boolean cumpleLongitud(String texto, int longitudMinima, int longitudMaxima){
		return cumpleLongitudMin(texto, longitudMinima) && cumpleLongitudMax(texto, longitudMaxima);	
	}
	
	/**
	 * Valida una fecha calendar con mínimo min
	 * @param fecha
	 * @param min
	 * @return
	 */
	
	public static boolean valDateMin(LocalDate fecha, LocalDate min){
		return fecha.isAfter(min) || fecha==min;
		
	}
	
	/**
	 * Valida una fecha calendar con máximo max
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateMax(LocalDate fecha, LocalDate max){
		return fecha.isBefore(max) || fecha==max;
		
	}	
	
	/**
	 * Valida una fecha calendar para que sea la misma fecha que la actual
	 * @param fecha
	 * @param max
	 * @return
	 */
	public static boolean valDateEqual(LocalDate fecha, LocalDate hoy){
		return fecha.isEqual(hoy);
		
	}	
	
	/**
	 * esFechaValida
	 * Recibe una string con formato fecha dd/mm/aaaa y comprueba el formato
	 * @param fecha
	 * @return
	 */
	public static boolean esFechaValida(String fecha){
		boolean correcto = false;
		DateTimeFormatter formato = DateTimeFormatter.ofPattern(FORMATO_FECHA);
		try {
			LocalDate fech = (LocalDate.parse(fecha, formato)); 
			correcto = true; 			
		}
		catch (DateTimeParseException e){
			correcto = false;
		}
		
		return !isVacio(fecha) && correcto;
	}
	
	/**
	 * Nombre esPasswordValida
	 * Descripcion Comprueba que la cadena recibida cumpla con las normas de contraseña
	 * @param password string con la contraseña introducida
	 * @return true si cumple con las especificaciones
	 */
	public static boolean esPasswordValida(String password){
		return !isVacio(password) && password.matches(PASSWORD_PATTERN);
	}
	
	/* ***************************************************************************************
	 * NOMBRE: codigoProductoValido                                                                 *
	 * 
	 * DESCRIPCIÓN: *//**
	 * 		Comprobar que el código del producto es válido
	 * 
	 * @param texto String con el texto a comprobar
	 * 
	 * @return true, si cumple con las especificaciones
	 * FECHA: Enero 2023 
	 * AUTOR: Paula Sánchez 
	 * 
	 * **************************************************************************************/
	
	public static boolean codigoProductoValido(String codigo) {
		return !isVacio(codigo) && codigo.matches(PRODUCT_PATTERN);
	}
}
