package es.rf.tienda.controller;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.dto.MensajesCategoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Messages;

/**
 * 
 * Nombre		CategoriaControllerTest
 * Descripcion	Test del controlador de la clase categoria
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

class CategoriaControllerTest {
	
	private CategoriaController cDao;
	private Categoria c1;
	private Categoria c2;
	private ArrayList<Categoria> listCategoria;
	
	private final String ID1 = "3";
	private final int ID1_INT = 3;
	private final String NOMBRE_CATEGORIA1 = "Nombre categoria";
	private final String DESCRIPCION_CATEGORIA1 = "Descripción de categoria";
	
	private final String ID2 = "7";
	private final int ID2_INT = 7;
	private final String NOMBRE_CATEGORIA2 = "Nombre categoria";
	private final String DESCRIPCION_CATEGORIA2 = "Descripción de categoria";
	
	private final MensajesCategoria MENSAJE_CORRECTO = MensajesCategoria.mensaje(Messages.CODE_200, Messages.STATUS_200, c1);
	private final MensajesCategoria MENSAJE_CORRECTO2 = MensajesCategoria.mensaje(Messages.CODE_200, Messages.STATUS_200, c2); 
	private final MensajesCategoria MENSAJE_CORRECTO3 = MensajesCategoria.mensajeList(Messages.CODE_200, Messages.STATUS_200, listCategoria);
	private final MensajesCategoria MENSAJE_CORRECTO_ELIMINAR = MensajesCategoria.mensajeComun(Messages.CODE_200, Messages.REGISTRO_BORRADO);
	private final MensajesCategoria MENSAJE_CORRECTO_PETICION = MensajesCategoria.mensajeComun(Messages.CODE_400, Messages.PETICION_ERRONEA);
	private final MensajesCategoria MENSAJE_CORRECTO_INSERTAR = MensajesCategoria.mensajeComun(Messages.CODE_200, Messages.REGISTRO_INSERTADO);
	private final MensajesCategoria MENSAJE_CORRECTO_MODIFICAR = MensajesCategoria.mensajeComun(Messages.CODE_200, Messages.REGISTRO_MODIFICADO);
	
	@BeforeEach
	void creacion() {
		cDao = mock(CategoriaController.class);
	}

	@BeforeEach
	void creacionCategoria() throws DomainException {
		c1 = new Categoria();
		c1.setId_categoria(ID1_INT);
		c1.setCat_nombre(NOMBRE_CATEGORIA1);
		c1.setCat_descripcion(DESCRIPCION_CATEGORIA1);
		
		c2 = new Categoria();
		c2.setId_categoria(ID2_INT);
		c2.setCat_nombre(NOMBRE_CATEGORIA2);
		c2.setCat_descripcion(DESCRIPCION_CATEGORIA2);
		
		listCategoria = new ArrayList<>();
		listCategoria.add(c1);
		listCategoria.add(c2);
	}
	
	/**
	 * Comprueba que lee bien la lista de categorías devolviendo el mensaje correspondiente
	 */
	@Test
	void testLeerTodosCorrecto() {
		when(cDao.leerTodos()).thenReturn(MENSAJE_CORRECTO3);
		assertEquals(cDao.leerTodos(), MENSAJE_CORRECTO3);
	}
	
	/**
	 * Comprueba que no lee bien la lista de categorías devolviendo el mensaje correspondiente
	 */
	@Test
	void testLeerTodosIncorrecto() {
		when(cDao.leerTodos()).thenReturn(MENSAJE_CORRECTO3);
		assertNotEquals(cDao.leerTodos(), MENSAJE_CORRECTO);
	}
	
	/**
	 * Comprueba que lee bien una categoría mediante el id devolviendo el mensaje correspondiente
	 * @throws DAOException
	 */
	@Test
	void testLeerUnoCorrecto() throws DAOException {
		when(cDao.leerUno(ID1)).thenReturn(MENSAJE_CORRECTO);
		assertEquals(cDao.leerUno(ID1), MENSAJE_CORRECTO);
	}
	
	/**
	 * Comprueba que devuelve el mensaje de error correspondiente cuando el id es nulo
	 * @throws DAOException
	 */
	@Test
	void testLeerUnoCorrectoPeticion() throws DAOException {
		when(cDao.leerUno(null)).thenReturn(MENSAJE_CORRECTO_PETICION);
		assertEquals(cDao.leerUno(null), MENSAJE_CORRECTO_PETICION);
	}

	/**
	 * Comprueba que no lee bien una categoría cuando se le pasa el id que no corresponde a ella devolviendo el mensaje correspondiente
	 * @throws DAOException
	 */
	@Test
	void testLeerUnoIncorrecto() throws DAOException {
		when(cDao.leerUno(ID1)).thenReturn(MENSAJE_CORRECTO);
		when(cDao.leerUno(ID2)).thenReturn(MENSAJE_CORRECTO2);
		assertNotEquals(cDao.leerUno(ID2), MENSAJE_CORRECTO);
	}
	
	/**
	 * Comprueba que devuelve el mensaje correspondiente cuando se elimina una categoria
	 * @throws DAOException
	 */
	@Test
	void testDeleteCorrecto() throws DAOException {
		when(cDao.eliminar(ID1)).thenReturn(MENSAJE_CORRECTO_ELIMINAR);
		assertEquals(cDao.eliminar(ID1), MENSAJE_CORRECTO_ELIMINAR);
	}
	
	/**
	 * Comprueba que devuelve el mensaje correspondiente cuando se elimina una categoria con un id incorrecto
	 * @throws DAOException
	 */
	@Test
	void testDeleteIncorrecto() throws DAOException {
		when(cDao.eliminar(ID1)).thenReturn(MENSAJE_CORRECTO_ELIMINAR);
		assertNotEquals(cDao.eliminar(ID2), MENSAJE_CORRECTO_ELIMINAR);
	}
	
	/**
	 * Comprueba que devuelve el mensaje correspondiente cuando se elimina una categoria
	 * @throws DAOException
	 */
	@Test
	void testDeleteCategoriaCorrecto() throws DAOException {
		when(cDao.eliminarCategorias(c1)).thenReturn(MENSAJE_CORRECTO_ELIMINAR);
		assertEquals(cDao.eliminarCategorias(c1), MENSAJE_CORRECTO_ELIMINAR);
	}
	
	/**
	 * Comprueba que devuelve el mensaje correspondiente cuando se elimina una categoria con un id incorrecto
	 * @throws DAOException
	 */
	@Test
	void testDeleteCategoriaIncorrecto() throws DAOException {
		when(cDao.eliminarCategorias(c1)).thenReturn(MENSAJE_CORRECTO_ELIMINAR);
		assertNotEquals(cDao.eliminarCategorias(c2), MENSAJE_CORRECTO_ELIMINAR);
	}
	
	/**
	 * Comprueba que devuelve el mensaje de error correspondiente cuando el id es nulo
	 * @throws DAOException
	 */
	@Test
	void testDeleteCorrectoPeticion() throws DAOException {
		when(cDao.eliminar(null)).thenReturn(MENSAJE_CORRECTO_PETICION);
		assertEquals(cDao.eliminar(null), MENSAJE_CORRECTO_PETICION);
	}
	
	/**
	 * Comprueba que devuelve el mensaje correspondiente cuando se inserta una categoria
	 * @throws DAOException
	 */
	@Test
	void testInsertarCorrecto() throws DAOException {
		when(cDao.insertar(c1)).thenReturn(MENSAJE_CORRECTO_INSERTAR);
		assertEquals(cDao.insertar(c1), MENSAJE_CORRECTO_INSERTAR);
	}
	
	/**
	 * Comprueba que devuelve el mensaje correspondiente cuando se inserta una categoria con un id incorrecto
	 * @throws DAOException
	 */
	@Test
	void testInsertarIncorrecto() throws DAOException {
		when(cDao.insertar(c1)).thenReturn(MENSAJE_CORRECTO_INSERTAR);
		assertNotEquals(cDao.insertar(c2), MENSAJE_CORRECTO_INSERTAR);
	}
	
	/**
	 * Comprueba que devuelve el mensaje correspondiente cuando se modifica una categoria
	 * @throws DAOException
	 */
	@Test
	void testModificarCorrecto() throws DAOException {
		when(cDao.modificar(c1)).thenReturn(MENSAJE_CORRECTO_MODIFICAR);
		assertEquals(cDao.modificar(c1), MENSAJE_CORRECTO_MODIFICAR);
	}
	
	/**
	 * Comprueba que devuelve el mensaje correspondiente cuando se modifica una categoria con un id incorrecto
	 * @throws DAOException
	 */
	@Test
	void testModificarIncorrecto() throws DAOException {
		when(cDao.modificar(c1)).thenReturn(MENSAJE_CORRECTO_MODIFICAR);
		assertNotEquals(cDao.modificar(c2), MENSAJE_CORRECTO_MODIFICAR);
	}
	
}
