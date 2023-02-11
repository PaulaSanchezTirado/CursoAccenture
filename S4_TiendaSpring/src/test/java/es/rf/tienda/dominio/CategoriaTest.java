package es.rf.tienda.dominio;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import es.rf.tienda.exception.DomainException;

/**
 * 
 * Nombre		CategoriaTest
 * Descripcion	Test de la clase categoria
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

class CategoriaTest {
	
	private final int ID = 456;
	private final int ID_ERROR = 0;
	private final String CAT_NOMBRE = "Nombre Categoría";
	private final String CAT_NOMBRE_VACIO = "";
	private final String CAT_NOMBRE_ERROR1 = "cat";
	private final String CAT_NOMBRE_ERROR2 = "qwertyuioplkjhgfdsazxcvbnmqwertyuioplkjhgfdsazxcvbn";
	private final String CAT_DESCRIPCION = "Descripcion categoría";
	
	Categoria c;
	@BeforeEach
	void creacion() {
		c = new Categoria();
	}
	
	// Comprobaciones funciones auxiliares
	
	/**
	 * Comprueba que el nombre es correcto para insertar
	 * @throws DomainException
	 */
	@Test
	void testIsValidInsert() throws DomainException {
		c.setCat_nombre(CAT_NOMBRE);
		assertTrue(c.isValidInsert());
	}
	
	/**
	 * Comprueba que el nombre y la id son correctas para actualizar
	 * @throws DomainException
	 */
	@Test
	void testIsValidUpdate() throws DomainException {
		c.setCat_nombre(CAT_NOMBRE);
		c.setId_categoria(ID);
		assertTrue(c.isValidUpdate());
	}
	
	/**
	 * Comprueba que el Id no es correcto para actualizar
	 * @throws DomainException
	 */
	@Test
	void testIsValidUpdateErrorId() throws DomainException {
		c.setCat_nombre(CAT_NOMBRE);
		c.setId_categoria(ID_ERROR);
		assertFalse(c.isValidUpdate());
	}
	
	// Comprobaciones de setters y getters
	
	/**
	 * Comprueba que el get y set del id de categoría funcionan correctamente
	 */
	@Test
	void testGetId_categoria(){
		c.setId_categoria(ID);
		assertEquals(ID, c.getId_categoria());
	}
	
	/**
	 * Comprueba que el get y set del nombre de categoría funcionan correctamente
	 */
	@Test
	void testGetCat_nombre() throws DomainException {
		c.setCat_nombre(CAT_NOMBRE);
		assertEquals(CAT_NOMBRE, c.getCat_nombre());
	}
	
	/**
	 * Comprueba que el get y set de la descripción de categoría funcionan correctamente
	 */
	@Test
	void testGetCat_descripcion() {
		c.setCat_descripcion(CAT_DESCRIPCION);
		assertEquals(CAT_DESCRIPCION, c.getCat_descripcion());
	}
	
	// Comprobación de excepciones
	@ParameterizedTest
	@ValueSource(strings = {CAT_NOMBRE_VACIO, CAT_NOMBRE_ERROR1, CAT_NOMBRE_ERROR2})
	void testGetCat_nombreError(String param) {
		assertThrows(DomainException.class,
			    () -> { c.setCat_nombre(param);});
	}
	
}
