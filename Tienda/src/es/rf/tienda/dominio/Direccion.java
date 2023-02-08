package es.rf.tienda.dominio;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Validator;

/**
 * 
 * Nombre		Direccion
 * Descripcion	Lista de direcciones
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */
public class Direccion {

	private String dir_nombre;
	private String dir_direccion;
	private String dir_poblacion;
	private String dir_cPostal;
	private String dir_provincia;
	private String dir_pais;
	private String dir_correoE;
	
	private final int LONGITUD_MIN_NOMBRE = 5;
	private final int LONGITUD_MAX_NOMBRE = 100;
	
	// Contructor
	public Direccion() {
		
	}
	
	// Getters y setters
	
	public String getDir_nombre() {
		return dir_nombre;
	}
	
	// Tiene que cumplir que la longitud se encuentre entre 5 y 100 y que el formato sea alfanumérico
	public void setDir_nombre(String dir_nombre) throws DomainException {
		if (Validator.isAlfanumeric(dir_nombre)) {
			if(Validator.cumpleLongitud(dir_nombre, LONGITUD_MIN_NOMBRE, LONGITUD_MAX_NOMBRE)){
				this.dir_nombre = dir_nombre;
			}
			else {
				throw new DomainException(ErrorMessages.PROERR_003);
			}
		}
		else {
			throw new DomainException(ErrorMessages.ERR_ALFANUMERIC);
		}
	}
	
	public String getDir_direccion() {
		return dir_direccion;
	}
	
	public void setDir_direccion(String dir_direccion) {
		this.dir_direccion = dir_direccion;
		
	}
	
	public String getDir_poblacion() {
		return dir_poblacion;
	}
	
	public void setDir_poblacion(String dir_poblacion) {
		this.dir_poblacion = dir_poblacion;
	}
	
	public String getDir_cPostal() {
		return dir_cPostal;
	}
	
	public void setDir_cPostal(String dir_cPostal) {
		this.dir_cPostal = dir_cPostal;
	}
	
	public String getDir_provincia() {
		return dir_provincia;
	}
	
	public void setDir_provincia(String dir_provincia) {
		this.dir_provincia = dir_provincia;
	}
	
	public String getDir_pais() {
		return dir_pais;
	}
	
	public void setDir_pais(String dir_pais) {
		this.dir_pais = dir_pais;
	}
	
	public String getDir_correoE() {
		return dir_correoE;
	}
	
	public void setDir_correoE(String dir_correoE) {
		this.dir_correoE = dir_correoE;
	}
		
}
