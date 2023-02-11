package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import es.rf.tienda.exception.DomainException;

/**
 * 
 * Nombre		UsuarioTest
 * Descripcion	Test de la clase usuario
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

class UsuarioTest {
	
	private final int USER_ID = 8;
	private final String USER_NOMBRE = "Sergio";
	private final String USER_EMAIL = "sergio@hotmail.es";
	private final String USER_PASS = "letra1-A%";
	private final int USER_TIPO = 87;
	private final String USER_DNI = "77.391.895-T";
	private final LocalDate USER_FECALTA = LocalDate.now();
	private final LocalDate USER_FECCONFIRMACION = LocalDate.now();

	private final String USER_NOMBRE_LONG = "ser";
	private final String USER_NOMBRE_VACIO = "";
	
	private final String CORREO1 = "tex@to1@texto2.es";
	private final String CORREO2 = "texto1@texto2";
	private final String CORREO3 = "@texto2.com";
	private final String CORREO4 = "t@t2.c";
	private final String CORREO5 = "";
	
	final String PASSWORD_INVALIDA1 = "23456";
	final String PASSWORD_INVALIDA2 = "stexto4%";
	final String PASSWORD_INVALIDA3 = "texto1-";
	final String PASSWORD_INVALIDA4 = "AAAAAAA%-";
	final String PASSWORD_INVALIDA5 = "";
	
	final String DNI_INVALIDO1 =  "77391895-T";
	final String DNI_INVALIDO2 = "77.391.895T";
	final String DNI_INVALIDO3 = "77.391.895-A";
	final String DNI_INVALIDO4 = "";
	
	Usuario user;
	@BeforeEach
	void creacion() {
		user = new Usuario();
	}
	
	// Comprobación de getters y setters
	
	/**
	 * Comprueba que el get y set de la variable id de usuario funcionan correctamente
	 */
	@Test
	void testGetId_usuario() {
		user.setId_usuario(USER_ID);
		assertEquals(USER_ID, user.getId_usuario());
	}

	/**
	 * Comprueba que el get y set de la variable nombre de usuario funcionan correctamente
	 */
	@Test
	void testGetUser_nombre() throws DomainException {
		user.setUser_nombre(USER_NOMBRE);
		assertEquals(USER_NOMBRE, user.getUser_nombre());
	}

	/**
	 * Comprueba que el get y set de la variable email de usuario funcionan correctamente
	 */
	@Test
	void testGetUser_email() throws DomainException {
		user.setUser_email(USER_EMAIL);
		assertEquals(USER_EMAIL, user.getUser_email());
	}

	/**
	 * Comprueba que el get y set de la variable pass de usuario funcionan correctamente
	 */
	@Test
	void testGetUser_pass() throws DomainException {
		user.setUser_pass(USER_PASS);
		assertEquals(USER_PASS, user.getUser_pass());
	}

	/**
	 * Comprueba que el get y set de la variable tipo de usuario funcionan correctamente
	 */
	@Test
	void testGetUser_tipo() {
		user.setUser_tipo(USER_TIPO);
		assertEquals(USER_TIPO, user.getUser_tipo());
	}

	/**
	 * Comprueba que el get y set de la variable dni de usuario funcionan correctamente
	 */
	@Test
	void testGetUser_dni() throws DomainException {
		user.setUser_dni(USER_DNI);
		assertEquals(USER_DNI, user.getUser_dni());
	}

	/**
	 * Comprueba que el get y set de la variable fecalta de usuario funcionan correctamente
	 */
	@Test
	void testGetUser_fecAlta() throws DomainException {
		user.setUser_fecAlta(USER_FECALTA);
		assertEquals(USER_FECALTA, user.getUser_fecAlta());
	}

	/**
	 * Comprueba que el get y set de la variable fecconfirmacion de usuario funcionan correctamente
	 */
	@Test
	void testGetUser_fecConfirmacion() throws DomainException {
		user.setUser_fecConfirmacion(USER_FECCONFIRMACION);
		assertEquals(USER_FECCONFIRMACION, user.getUser_fecConfirmacion());
	}
	
	// Comprobación de excepciones
	
	/**
	 * Comprueba las excepciones en la variable nombre de usuario
	 */
	@Test
	void testGetUser_nombreErrorLong() {
		assertThrows(DomainException.class,
	    () -> { user.setUser_nombre(USER_NOMBRE_LONG);});
	}
	
	/**
	 * Comprueba las excepciones en la variable nombre de usuario
	 */
	@Test
	void testGetUser_nombreErrorVacio() {
		assertThrows(DomainException.class,
	    () -> { user.setUser_nombre(USER_NOMBRE_VACIO);});
	}
	
	/**
	 * Comprueba las excepciones en la variable email de usuario
	 */
	@ParameterizedTest
	@ValueSource(strings = {CORREO1, CORREO2, CORREO3, CORREO4, CORREO5})
	void testGetUser_emailError(String param) {
		assertThrows(DomainException.class,
			    () -> { user.setUser_email(param);});
	}
	
	/**
	 * Comprueba las excepciones en la variable pass de usuario
	 */
	@ParameterizedTest
	@ValueSource(strings = {PASSWORD_INVALIDA1, PASSWORD_INVALIDA2, PASSWORD_INVALIDA3, PASSWORD_INVALIDA4, PASSWORD_INVALIDA5})
	void testGetUser_passError(String param) {
		assertThrows(DomainException.class,
			    () -> { user.setUser_pass(param);});
	}
	
	/**
	 * Comprueba las excepciones en la variable dni de usuario
	 */
	@ParameterizedTest
	@ValueSource(strings = {DNI_INVALIDO1, DNI_INVALIDO2, DNI_INVALIDO3, DNI_INVALIDO4})
	void testGetUser_dniError(String param) {
		assertThrows(DomainException.class,
			    () -> { user.setUser_dni(param);});
	}
	
}

