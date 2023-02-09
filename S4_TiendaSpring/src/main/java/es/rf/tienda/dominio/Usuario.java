package es.rf.tienda.dominio;

import java.time.LocalDate;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.ErrorMessages;
import es.rf.tienda.util.Validator;

/**
 * 
 * Nombre		Usuario
 * Descripcion	Lista de usuarios
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

public class Usuario {
	
	private int id_usuario;
	private String user_nombre;
	private String user_email;
	private String user_pass;
	private int user_tipo;
	private String user_dni;
	private LocalDate user_fecAlta;
	private LocalDate user_fecConfirmacion;
	
	/**
	 * Límite user_nombre
	 */
	private final int LIM_MIN_USER_NOMBRE = 5;
	private final int LIM_MAX_USER_NOMBRE = 100;
	
	/**
	 * Límite user_fecAlta
	 */
	private final LocalDate HOY = LocalDate.now();
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getUser_nombre() {
		return user_nombre;
	}
	
	public void setUser_nombre(String user_nombre) throws DomainException {
		if (Validator.cumpleLongitud(user_nombre, LIM_MIN_USER_NOMBRE, LIM_MAX_USER_NOMBRE)) {
			this.user_nombre = user_nombre;
		}
		else {
			throw new DomainException(ErrorMessages.USERR_001);
		}
	}
	
	public String getUser_email() {
		return user_email;
	}
	
	public void setUser_email(String user_email) throws DomainException {
		if (Validator.isEmailValido(user_email)) {
				this.user_email = user_email;
		}
		else {
			throw new DomainException(ErrorMessages.USERR_002);
		}	
	}
	
	public String getUser_pass() {
		return user_pass;
	}
	
	public void setUser_pass(String user_pass) throws DomainException {
		if (Validator.esPasswordValida(user_pass)) {
			this.user_pass = user_pass;
		}
		else {
			throw new DomainException(ErrorMessages.USERR_003);
		}
	}
	
	public int getUser_tipo() {
		return user_tipo;
	}
	
	public void setUser_tipo(int user_tipo) {
		this.user_tipo = user_tipo;
	}
	
	public String getUser_dni() {
		return user_dni;
	}
	
	public void setUser_dni(String user_dni) throws DomainException {
		if (Validator.cumpleDNI(user_dni)) {
			this.user_dni = user_dni;
		}
		else {
			throw new DomainException(ErrorMessages.USERR_004);
		}
	}
	
	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}
	
	public void setUser_fecAlta(LocalDate user_fecAlta) throws DomainException {
		if (Validator.valDateEqual(user_fecAlta, HOY)){
			this.user_fecAlta = user_fecAlta;
		}
		else {
			throw new DomainException(ErrorMessages.USERR_005);
		}
	}
	
	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}
	
	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) throws DomainException {
		if (Validator.valDateEqual(user_fecConfirmacion, HOY)){
			this.user_fecConfirmacion = user_fecConfirmacion;
		}
		else {
			throw new DomainException(ErrorMessages.USERR_006);
		}
	}
	
}
