package es.rf.tienda.controller;


import es.rf.tienda.objetos.repository.ICategoriaRepo;

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

@RestController
@RequestMapping("/categorias")
public class CategoriaController{
	
	@Autowired
	private ICategoriaRepo cDao;
	
	@GetMapping("/{id}")
	public String[] leerUno(@PathVariable("id") Integer id) {
		try {
			Categoria c = cDao.findById(id).get();
			return new String[] {"200", c.toString()};
		}
		catch (NoSuchElementException e) {
			return new String[] {"400", "No existe registro solicitado"};	
		}
	}
	
	@GetMapping()
	public List<Categoria> leerTodos(){
		return cDao.findAll();
	}

	@PostMapping
	public String[] insertar(@RequestBody Categoria c) {
		c.setId_categoria(0);
		cDao.save(c);
		return new String[] {"200", "Registro guardado"};
	}
	
	@PutMapping
	public String[] modificar(@RequestBody Categoria c) {
		if (c.isValid()) {
			cDao.save(c);
			return new String[] {"200", "Registro modificado"};
		}
		else {
			return new String[] {"500", "Registro no modificado"};
		}
	}
	
	@DeleteMapping("/{id}")
	public String[] eliminar(@PathVariable("id") Integer id) {
		try {
			cDao.deleteById(id);
			return new String[] {"200", "Registro eliminado"};
		}
		catch (IllegalArgumentException e) {
			return new String[] {"400", "No existe registro solicitado"};
		}
	}
}
