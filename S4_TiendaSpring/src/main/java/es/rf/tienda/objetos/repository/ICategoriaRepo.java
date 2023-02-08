package es.rf.tienda.objetos.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import es.rf.tienda.dominio.Categoria;

public interface ICategoriaRepo extends JpaRepository<Categoria, Integer>{
	
}
