package es.rf.tienda.controller;

import es.rf.tienda.service.IServicio;
import es.rf.tienda.util.Messages;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import es.rf.tienda.auxiliar.Mensajes;
import es.rf.tienda.dominio.Categoria;
import es.rf.tienda.exception.ControllerException;
import es.rf.tienda.exception.DAOException;

/**
 * 
 * Nombre		CategoriaController
 * Descripcion	Controlador de la clase categoria
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

@RestController
@RequestMapping("/categorias")
public class CategoriaController{
	
	@Autowired
	private IServicio cDao;
	
	/**
	 * Método para leer una categoría a través de su Id en formato string
	 * @param id
	 * @return
	 * @throws DAOException
	 * @throws ControllerException 
	 */
	@GetMapping("/{id}")
	public Map<String, Object> leerUno(@PathVariable("id") String id_string) throws DAOException{
		if (id_string != null) {
			try {
				int id = Integer.parseInt(id_string);
				Categoria c = (Categoria) cDao.leerUno(id);
				if (cDao.idExist(id)) {
					return Mensajes.Mensaje(Messages.CODE_200, null, c);
				}
				else {
					return Mensajes.Mensaje(Messages.CODE_400, Messages.CAT_INEXISTENTE, null);
				}
			}
			catch (NumberFormatException e) {
				return Mensajes.Mensaje(Messages.CODE_400, Messages.COD_ERRONEO, null);
			}
		}
		else {
			return Mensajes.Mensaje(Messages.CODE_400, Messages.PETICION_ERRONEA, null);
		}
	}

	/**
	 * Método para leer todas las categorías
	 * @return
	 * @throws ControllerException 
	 */
	@GetMapping()
	public Map<String, Object> leerTodos(){
		List<Categoria> listCategoria = cDao.leerTodos();
		if (!listCategoria.isEmpty()) {
			return Mensajes.Mensaje(Messages.CODE_200, null, listCategoria);
		}
		else {
			return Mensajes.Mensaje(Messages.CODE_400, Messages.PETICION_ERRONEA, null);
		}
		
	}

	/**
	 * Método para insertar una categoría en la tabla Categorias
	 * @param c
	 * @return
	 */
	@PostMapping
	public Map<String, Object> insertar(@RequestBody Categoria c) {
		c.setId_categoria(0);
		if (cDao.insertar(c)) {
			return Mensajes.Mensaje(Messages.CODE_200, Messages.REGISTRO_INSERTADO, null);
		}
		else {
			return Mensajes.Mensaje(Messages.CODE_200, Messages.REGISTRO_NO_INSERTADO, null);
		}
	}
	
	/**
	 * Método para modificar una categoría existente
	 * @param c
	 * @return
	 */
	@PutMapping
	public Map<String, Object> modificar(@RequestBody Categoria c) {
		if (cDao.update(c)) {
			return Mensajes.Mensaje(Messages.CODE_200, Messages.REGISTRO_MODIFICADO, null);
		}
		else {
			return Mensajes.Mensaje(Messages.CODE_400, Messages.REGISTRO_NO_MODIFICADO, null);
		}
	}
	
	/**
	 * Método para borrar una categoría a través de su Id en formato string
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	@DeleteMapping("/{id}")
	public Map<String, Object> eliminar(@PathVariable("id") String id_string) throws DAOException{
		if (id_string != null) {
			try {
				int id = Integer.parseInt(id_string);
				if (cDao.idExist(id)) {
					cDao.deleteById(id);
					return Mensajes.Mensaje(Messages.CODE_200, Messages.REGISTRO_BORRADO, null);
				}
				else {
					return Mensajes.Mensaje(Messages.CODE_400, Messages.REGISTRO_NO_BORRADO, null);
				}
			}
			catch (NumberFormatException e) {
				return Mensajes.Mensaje(Messages.CODE_400, Messages.COD_ERRONEO, null);
			}
		}
		else {
			return Mensajes.Mensaje(Messages.CODE_400, Messages.PETICION_ERRONEA, null);
		}
	}
	
	/**
	 * Método para borrar una categoría 
	 * @param c
	 * @return
	 * @throws DAOException
	 */
	@DeleteMapping
	public Map<String, Object> eliminarCategorias(Categoria c) throws DAOException{
		if (cDao.idExist(c.getId_categoria())) {
			int id = c.getId_categoria();
			String idString= String.valueOf(id);
			eliminar(idString);
			return Mensajes.Mensaje(Messages.CODE_200, Messages.REGISTRO_BORRADO, null);
			
		}
		else {
			return Mensajes.Mensaje(Messages.CODE_400, Messages.REGISTRO_NO_BORRADO, null);
		}
	}
	
}
