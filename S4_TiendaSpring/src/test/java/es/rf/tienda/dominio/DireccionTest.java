package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * 
 * Nombre		DireccionTest
 * Descripcion	Test de la clase direccion
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

class DireccionTest {
	
	private final String DIR_NOMBRE = "Sergio Uclés";
	private final String DIR_DIRECCION = "Avenida Diagonal";
	private final String DIR_POBLACION = "San Juan de Alicante";
	private final String DIR_CODPOSTAL = "18100";
	private final String DIR_PROVINCIA = "Alicante";
	private final String DIR_PAIS = "España";
	private final String DIR_EMAIL = "s.u.f@gmail.com";
	
	Direccion dir;
	@BeforeEach
	void creacion() {
		dir = new Direccion();
	}
	
	@Test
	void testDireccion() {
		creacion();
	}
	
	// Comprobación de getters y setters
	
	/**
	 * Comprueba que el get y set de la variable nombre de direccion funcionan correctamente
	 */
	@Test
	void testGetDir_nombre() {
		dir.setDir_nombre(DIR_NOMBRE);
		assertEquals(DIR_NOMBRE, dir.getDir_nombre());
	}

	/**
	 * Comprueba que el get y set de la variable dirección de direccion funcionan correctamente
	 */
	@Test
	void testGetDir_direccion() {
		dir.setDir_direccion(DIR_DIRECCION);
		assertEquals(DIR_DIRECCION, dir.getDir_direccion());
	}

	/**
	 * Comprueba que el get y set de la variable población de direccion funcionan correctamente
	 */
	@Test
	void testGetDir_poblacion() {
		dir.setDir_poblacion(DIR_POBLACION);
		assertEquals(DIR_POBLACION, dir.getDir_poblacion());
	}

	/**
	 * Comprueba que el get y set de la variable codpostal de direccion funcionan correctamente
	 */
	@Test
	void testGetDir_cPostal() {
		dir.setDir_cPostal(DIR_CODPOSTAL);
		assertEquals(DIR_CODPOSTAL, dir.getDir_cPostal());
	}

	/**
	 * Comprueba que el get y set de la variable provincia de direccion funcionan correctamente
	 */
	@Test
	void testGetDir_provincia() {
		dir.setDir_provincia(DIR_PROVINCIA);
		assertEquals(DIR_PROVINCIA, dir.getDir_provincia());
	}

	/**
	 * Comprueba que el get y set de la variable pais de direccion funcionan correctamente
	 */
	@Test
	void testGetDir_pais() {
		dir.setDir_pais(DIR_PAIS);
		assertEquals(DIR_PAIS, dir.getDir_pais());
	}

	/**
	 * Comprueba que el get y set de la variable email de direccion funcionan correctamente
	 */
	@Test
	void testGetDir_correoE() {
		dir.setDir_correoE(DIR_EMAIL);
		assertEquals(DIR_EMAIL, dir.getDir_correoE());
	}

}

