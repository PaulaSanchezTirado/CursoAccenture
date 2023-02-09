package es.rf.tienda.controller;


import es.rf.tienda.objetos.repository.ICategoriaRepo;
import es.rf.tienda.service.IServicioCategoria;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.DAOException;

@RestController
@RequestMapping("/categorias")
public class CategoriaController{
	
	@Autowired
	private IServicioCategoria cDao;
	
	@GetMapping("/{id}")
	public String[] leerUno(@PathVariable("id") Integer id) throws DAOException {
		if (cDao.idExist(id)) {
			Categoria c = cDao.leerUno(id);
			return new String[] {"200", c.toString()};
		}
		else {
			return new String[] {"400", "No existe registro solicitado"};	
		}
	}
	
	@GetMapping()
	public List<Categoria> leerTodos(){
		return cDao.leerTodos();
	}

	@PostMapping
	public String[] insertar(@RequestBody Categoria c) {
		c.setId_categoria(0);
		if (cDao.insertar(c)) {
			return new String[] {"200", "Registro insertado"};
		}
		else {
			return new String[] {"400", "Registro no insertado"};
		}
	}
	
	@PutMapping
	public String[] modificar(@RequestBody Categoria c) {
		if (cDao.update(c)) {
			return new String[] {"200", "Registro modificado"};
		}
		else {
			return new String[] {"500", "Registro no modificado"};
		}
	}
	
	@DeleteMapping("/{id}")
	public String[] eliminar(@PathVariable("id") Integer id) throws DAOException{
		if (cDao.idExist(id)) {
			cDao.deleteById(id);
			return new String[] {"200", "Registro eliminado"};
			
			
		}
		else {
			return new String[] {"400", "No existe registro solicitado para eliminar"};
		}
	}
	
	@DeleteMapping
	public String[] eliminarCategorias(Categoria c) throws DAOException{
		if (cDao.idExist(c.getId_categoria())) {
			eliminar(c.getId_categoria());
			return new String[] {"200", "Registro eliminado"};
			
		}
		else {
			return new String[] {"400", "No existe registro solicitado para eliminar"};
		}
	}
}
