package es.rf.tienda.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;
import es.rf.tienda.objetos.repository.ICategoriaRepo;

@Service
public class ServicioCategoria implements IServicioCategoria{
	
	@Autowired
	private ICategoriaRepo cDao;
	
	public boolean insertar(Categoria c) {
		if (c.isValidInsert()) {
			cDao.save(c);
			return true;
		}
		else {
			return false;
		}	
	}
	
	public boolean update(Categoria c) {
		if (c.isValidUpdate()) {
			cDao.save(c);
			return true;
		}
		else {
			return false;
		}
	}
	public boolean deleteById(int id) throws DAOException {
		try {
			cDao.deleteById(id);
			return true;
		}
		catch (IllegalArgumentException e) {
			throw new DAOException("El id proporcionado para eliminar la categoría es nulo");
		}
	}
	public boolean deleteCategorias(Categoria c) throws DAOException {
		try {
			deleteById(c.getId_categoria());
			return true;
		}
		catch (IllegalArgumentException e) {
			throw new DAOException("El id proporcionado para eliminar la categoría es nulo");
		}
	}
	
	public List<Categoria> leerTodos(){
		return cDao.findAll();
	}
	
	public Categoria leerUno(int id) throws DAOException {
		try {
			return cDao.findById(id).get();	
		}
		catch (IllegalArgumentException e) {
			throw new DAOException("El id proporcionado para encontrar la categoría es nulo");
		}
	}
	
	public boolean idExist(int id) throws DAOException {
		try {
			return cDao.existsById(id);
		}
		catch (IllegalArgumentException e) {
			throw new DAOException("El id proporcionado para encontrar la categoría es nulo");
		}
	}
	
}
