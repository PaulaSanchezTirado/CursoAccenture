package es.rf.tienda.service;

import org.springframework.beans.factory.annotation.Autowired;

import es.rf.tienda.objetos.repository.ICategoriaRepo;

public class ServicioDao <T>{
	
	@Autowired
	private ICategoriaRepo cDao;
	
	public void save() {
	}
	public void deleteById() {
	}
	public void findAll() {
	}
	public void findById() {
	}

}
