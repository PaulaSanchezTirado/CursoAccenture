package es.rf.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.objetos.repository.ICategoriaRepo;
import es.rf.tienda.util.Messages;

/**
 * 
 * Nombre		ServicioCategoria
 * Descripcion	Clase de apoyo a la clase controlador
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

@Service
public class ServicioCategoria implements IServicio<Categoria, Integer>{
	
	@Autowired
	private ICategoriaRepo cDao;
	
	/**
	 * Método para insertar una categoría. Devuelve un booleano para utilizarlo en el controller
	 */
	public boolean insertar(Categoria c) {
		if (c.isValidInsert()) {
			cDao.save(c);
			return true;
		}
		else {
			return false;
		}	
	}
	
	/**
	 * Método para actualizar una categoría. Devuelve un booleano para utilizarlo en el controller
	 */
	public boolean update(Categoria c) {
		if (c.isValidUpdate()) {
			cDao.save(c);
			return true;
		}
		else {
			return false;
		}
	}
	
	/**
	 * Método para borrar una categoría por Id. Devuelve un booleano para utilizarlo en el controller
	 */
	public boolean deleteById(Integer id) throws DAOException {
		try {
			cDao.deleteById(id);
			return true;
		}
		catch (IllegalArgumentException e) {
			throw new DAOException(Messages.ID_CAT_NULO_BORRAR);
		}
	}
	
	/**
	 * Método para borrar una categoría. Devuelve un booleano para utilizarlo en el controller
	 */
	public boolean delete(Categoria c) throws DAOException {
		try {
			deleteById(c.getId_categoria());
			return true;
		}
		catch (IllegalArgumentException e) {
			throw new DAOException(Messages.ID_CAT_NULO_BORRAR);
		}
	}
	
	/**
	 * Método para leer todas las categorías. Devuelve una lista al controller
	 */
	public List<Categoria> leerTodos(){
		return cDao.findAll();
	}
	
	/**
	 * Método para leer una categoría por su Id. Devuelve un objeto categoría para ser utilizado en el controller
	 */
	public Categoria leerUno(Integer id) throws DAOException {
		try {
			return cDao.findById(id).get();	
		}
		catch (IllegalArgumentException e) {
			throw new DAOException(Messages.ID_CAT_NULO_LEERUNO);
		}
	}
	
	/**
	 * Método para comprobar que existe una categoría por su Id. Devuelve un booleano para utilizarlo en el controller
	 */
	public boolean idExist(Integer id) throws DAOException {
		try {
			return cDao.existsById(id);
		}
		catch (IllegalArgumentException e) {
			throw new DAOException(Messages.ID_CAT_NULO_LEERUNO);
		}
	}
	
}
