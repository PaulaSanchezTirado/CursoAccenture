package es.rf.tienda.util;


/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio.
 * 
 *  @version	Enero 2016
 *  
 *  @author 	Miguel Garcia
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
	 * Error alfanumérico en nombre dirección
	 */
	public final static String ERR_ALFANUMERIC = "El nombre introducido no es válido";
	
	/**
	 * Errores de Producto
	 */
	public final static String PROERR_001 = "Formato código erróneo";
	public final static String PROERR_004 = "El precio introducido no se encuentra entre el rango especificado";
	public final static String PROERR_005 = "La fecha de prevista de reposición del producto introducida no es válida";
	public final static String PROERR_006 = "La fecha de activación del producto introducida no es válida";
	public final static String PROERR_007 = "La fecha de desactivación del producto introducida no es válida";
	public final static String PROERR_008 = "La longitud de la descripción del uso recomendado del producto no es válida";

}
