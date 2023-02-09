package es.rf.tienda.util;


/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @version	Enero 2023
 *  
 *  @author 	Paula Sánchez
 *  
 *  *****************************************************/
public class ErrorMessages {
	
	
	
	/**
	 * Codigo de producto
	 */
	//public final static String PROERR_001 = "Formato codigo erroneo";
	public final static String PROERR_002 = "Longitud de codigo erroneo";
	
	/**
	 * Campo con longitud erronea
	 */
	public final static String PROERR_003 = "La longitud de ? ha de estar entre ? y ?";
	
	/**
	 * Errores de Producto
	 */
	public final static String PROERR_001 = "Formato código erróneo";
	public final static String PROERR_004 = "El precio introducido no se encuentra entre el rango especificado";
	public final static String PROERR_005 = "La fecha de prevista de reposición del producto introducida no es válida";
	public final static String PROERR_006 = "La fecha de activación del producto introducida no es válida";
	public final static String PROERR_007 = "La fecha de desactivación del producto introducida no es válida";
	public final static String PROERR_008 = "La longitud de la descripción del uso recomendado del producto no es válida";
	
	/**
	 * Errores de usuario
	 */
	public final static String USERR_001 = "La longitud del nombre de usuario introducido no es correcta";
	public final static String USERR_002 = "El email introducido no es correcto";
	public final static String USERR_003 = "La contraseña introducida no es correcta";
	public final static String USERR_004 = "El DNI no cumple el formato establecido";
	public final static String USERR_005 = "La fecha de alta no es correcta";
	public final static String USERR_006 = "La fecha de confirmación no es correcta";
}
