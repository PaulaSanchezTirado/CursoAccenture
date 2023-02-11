package es.rf.tienda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

/**
 * 
 * Nombre		IServicio
 * Descripcion	Interfaz con los métodos necesarios para el controlador
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

@Service
public interface IServicio<T, S>{

	/**
	 * Métodos genéricos para poder implementarlos en las distintas clases servicio de las distintas
	 * clases de dominio
	 * @param t
	 * @return
	 */
	public boolean insertar(T t);
	public boolean update(T t);
	public boolean deleteById(S s) throws DAOException;
	public boolean deleteCategorias(T t) throws DAOException;	
	public List<Categoria> leerTodos();
	public T leerUno(S s) throws DAOException;
	public boolean idExist(S s) throws DAOException;
	
}
