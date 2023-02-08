package es.rf.tienda.dominio;

import java.time.LocalDate;

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
	
	public void setUser_nombre(String user_nombre) {
		if (Validator.cumpleLongitud(user_nombre, LIM_MIN_USER_NOMBRE, LIM_MAX_USER_NOMBRE)) {
			if (Validator.isAlfanumeric(user_nombre)) {
				this.user_nombre = user_nombre;
			}
			else {
				System.out.println("Excepción alfanumérico");
			}
		}
		else {
			System.out.println("Excepción longitud");
		}
	}
	
	public String getUser_email() {
		return user_email;
	}
	
	public void setUser_email(String user_email) {
		if (Validator.cumpleLongitud(user_email, LIM_MIN_USER_NOMBRE, LIM_MAX_USER_NOMBRE)) {
			if (Validator.isEmailValido(user_email)) {
				this.user_email = user_email;
			}
			else {
				System.out.println("Excepción pattern email");
			}
		}
		else {
			System.out.println("Excepción longitud");
		}	
	}
	
	public String getUser_pass() {
		return user_pass;
	}
	
	public void setUser_pass(String user_pass) {
		if (Validator.esPasswordValida(user_pass)) {
			this.user_pass = user_pass;
		}
		else {
			System.out.println("Excepción contraseña");
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
	
	public void setUser_dni(String user_dni) {
		if (Validator.cumpleDNI(user_dni)) {
			this.user_dni = user_dni;
		}
		else {
			System.out.println("Excepción dni");
		}
	}
	
	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}
	
	public void setUser_fecAlta(LocalDate user_fecAlta) {
		if (Validator.valDateEqual(user_fecAlta, HOY)){
			this.user_fecAlta = user_fecAlta;
		}
		else {
			System.out.println("Excepción no es fecha igual");
		}
	}
	
	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}
	
	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) {
		if (Validator.valDateEqual(user_fecConfirmacion, HOY)){
			this.user_fecConfirmacion = user_fecConfirmacion;
		}
		else {
			System.out.println("Excepción no es fecha igual");
		}
	}
	
}
