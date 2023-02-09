package es.rf.tienda.service;

import java.util.List;

import org.springframework.stereotype.Service;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

@Service
public interface IServicioCategoria{

	public boolean insertar(Categoria c);
	public boolean update(Categoria c);
	public boolean deleteById(int id) throws DAOException;
	public boolean deleteCategorias(Categoria c) throws DAOException;	
	public List<Categoria> leerTodos();
	public Categoria leerUno(int id) throws DAOException;
	public boolean idExist(int id) throws DAOException;
	
}
