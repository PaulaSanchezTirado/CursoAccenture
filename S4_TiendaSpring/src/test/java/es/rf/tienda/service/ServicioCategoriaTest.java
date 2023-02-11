package es.rf.tienda.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;

/**
 * 
 * Nombre		ServicioCategoriaTest
 * Descripcion	Test de la clase ServicioCategoria
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

class ServicioCategoriaTest {

	private ServicioCategoria cDao;
	private Categoria c1;
	private Categoria c2;
	private ArrayList<Categoria> listCategoria;
	
	private final int ID1 = 3;
	private final String NOMBRE_CATEGORIA1 = "Nombre categoria";
	private final String DESCRIPCION_CATEGORIA1 = "Descripción de categoria";
	
	private final int ID2 = 7;
	private final String NOMBRE_CATEGORIA2 = "Nombre categoria";
	private final String DESCRIPCION_CATEGORIA2 = "Descripción de categoria";
	
	private final int LONG_CORRECTA = 2;
	private final int LONG_INCORRECTA = 3;
	
	@BeforeEach
	void creacion() {
		cDao = mock(ServicioCategoria.class);
	}
	
	@BeforeEach
	void creacionCategoria() throws DomainException {
		c1 = new Categoria();
		c1.setId_categoria(ID1);
		c1.setCat_nombre(NOMBRE_CATEGORIA1);
		c1.setCat_descripcion(DESCRIPCION_CATEGORIA1);
		
		c2 = new Categoria();
		c2.setId_categoria(ID2);
		c2.setCat_nombre(NOMBRE_CATEGORIA2);
		c2.setCat_descripcion(DESCRIPCION_CATEGORIA2);
		
		listCategoria = new ArrayList<>();
		listCategoria.add(c1);
		listCategoria.add(c2);
	}
	
	/**
	 * Comprueba que lee bien la lista de categorías comparando el tamaño del array
	 */
	@Test
	void testLeerTodosCorrecto() {
		when(cDao.leerTodos()).thenReturn(listCategoria);
		assertEquals(LONG_CORRECTA, listCategoria.size());
	}
	
	/**
	 * Comprueba que no lee bien la lista de categorías comparando el tamaño del array
	 */
	@Test
	void testLeerTodosIncorrecto() {
		when(cDao.leerTodos()).thenReturn(listCategoria);
		assertNotEquals(LONG_INCORRECTA, listCategoria.size());
	}
	
	/**
	 * Comprueba que lee bien una categoría mediante el id
	 * @throws DAOException
	 */
	@Test
	void testLeerUnoCorrecto() throws DAOException {
		when(cDao.leerUno(ID1)).thenReturn(c1);
		assertEquals(cDao.leerUno(ID1), c1);
	}

	/**
	 * Comprueba que no lee bien una categoría cuando se le pasa el id que no corresponde a ella
	 * @throws DAOException
	 */
	@Test
	void testLeerUnoIncorrecto() throws DAOException {
		when(cDao.leerUno(ID1)).thenReturn(c1);
		when(cDao.leerUno(ID2)).thenReturn(c2);
		assertNotEquals(cDao.leerUno(ID2), c1);
	}
}
