package es.rf.tienda.dominio;

import jakarta.persistence.Embeddable;
import jakarta.persistence.Table;

/**
 * 
 * Nombre		Direccion
 * Descripcion	Lista de direcciones
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

@Embeddable
@Table(schema = "ALUMNO_PST", name = "DIRECCIONES")
public class Direccion {

	private String dir_nombre;
	private String dir_direccion;
	private String dir_poblacion;
	private String dir_cPostal;
	private String dir_provincia;
	private String dir_pais;
	private String dir_correoE;
	
	// Contructor
	public Direccion() {
		
	}
	
	// Getters y setters
	
	public String getDir_nombre() {
		return dir_nombre;
	}
	
	public void setDir_nombre(String dir_nombre){
		this.dir_nombre = dir_nombre;
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