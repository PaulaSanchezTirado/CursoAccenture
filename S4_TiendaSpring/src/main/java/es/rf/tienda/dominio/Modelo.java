package es.rf.tienda.dominio;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Transient;

/**
 * 
 * Nombre		Modelo
 * Descripcion	Interfac auxiliar para los métodos isValid
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

public interface Modelo {
	
	/**
	 * Método para comprobar que la inserción sea válida
	 * @return
	 */
	@Transient
	@JsonIgnore
	public boolean isValidInsert();
	
	/**
	 * Método para comprobar que la actualización sea válida
	 * @return
	 */
	@Transient
	@JsonIgnore
	public boolean isValidUpdate();

}
