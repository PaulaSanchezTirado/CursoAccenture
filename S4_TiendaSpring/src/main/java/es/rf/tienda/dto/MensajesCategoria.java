package es.rf.tienda.dto;

import java.util.List;

import es.rf.tienda.dominio.Categoria;

/**
 * 
 * Nombre		MensajesCategoria
 * Descripcion	Mensajes para el cliente de la clase categoria
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

public class MensajesCategoria {
	
	public String code;
	public String status;
	public Categoria categoria;
	public List<Categoria> listCategoria;
	
	/**
	 * Método para enviar un mensaje formato string, string, objeto categoria
	 * @param code
	 * @param status
	 * @param c
	 * @return
	 */
	public static MensajesCategoria mensaje(String code, String status, Categoria c) {
		MensajesCategoria returnValido = new MensajesCategoria();
		returnValido.code = code;
		returnValido.status = status;
		returnValido.categoria = c;
		return returnValido;	
	}
	
	/**
	 * Método para enviar un mensaje formato string, string, lista de objeto categoria
	 * @param code
	 * @param status
	 * @param c
	 * @return
	 */
	public static MensajesCategoria mensajeList(String code, String status, List<Categoria> c) {
		MensajesCategoria returnValido = new MensajesCategoria();
		returnValido.code = code;
		returnValido.status = status;
		returnValido.listCategoria = c;
		return returnValido;	
	}
	
	/**
	 * Método para enviar un mensaje formato string, string
	 * @param code
	 * @param status
	 * @return
	 */
	public static MensajesCategoria mensajeComun(String code, String status) {
		MensajesCategoria returnValido = new MensajesCategoria();
		returnValido.code = code;
		returnValido.status = status;
		return returnValido;
	}

}
