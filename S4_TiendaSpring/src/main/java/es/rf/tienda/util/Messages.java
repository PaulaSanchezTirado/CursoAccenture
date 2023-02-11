package es.rf.tienda.util;


/* *****************************************************
 * NOMBRE: ErrorMessages.java
 * 
 * DESCRIPCION:  
 * 			Clase con los String que contienen los mensajes de error 
 * 			especificados por las reglas de negocio y mensajes del cliente.
 * 
 *  @version	Enero 2023
 *  
 *  @author 	Paula Sánchez
 *  
 *  *****************************************************/
public class Messages {
	
	
	
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
	
	/**
	 * Errores de categoria
	 */
	public final static String CAT_ERR001 = "La longitud del nombre de categoría debe estar entre 5 y 50";
	
	/**
	 * Errores Mensaje
	 */
	public final static String CODE_200 = "200";
	public final static String CODE_400 = "400";
	public final static String STATUS_200 = "OK";
	public final static String CAT_INEXISTENTE = "No existe la categoría pedida";
	public final static String COD_ERRONEO = "Código erróneo";
	public final static String PETICION_ERRONEA = "Petición errónea";
	public final static String REGISTRO_INSERTADO = "Registro insertado";
	public final static String REGISTRO_NO_INSERTADO = "Registro no insertado";
	public final static String REGISTRO_MODIFICADO = "Registro modificado";
	public final static String REGISTRO_NO_MODIFICADO = "Registro no modificado";
	public final static String REGISTRO_BORRADO = "Registro eliminado";
	public final static String REGISTRO_NO_BORRADO = "No existe registro solicitado para eliminar";
	
	/**
	 * Errores ServicioCategoria
	 */
	public final static String ID_CAT_NULO_BORRAR = "El id proporcionado para eliminar la categoría es nulo";
	public final static String ID_CAT_NULO_LEERUNO = "El id proporcionado para encontrar la categoría es nulo";
	
	
	
	
}
