package es.rf.tienda.controller;

import es.rf.tienda.service.IServicio;
import es.rf.tienda.util.Messages;

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
import es.rf.tienda.dto.MensajesCategoria;
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
	 */
	@GetMapping("/{id}")
	public MensajesCategoria leerUno(@PathVariable("id") String id_string) throws DAOException{
		if (id_string != null) {
			try {
				int id = Integer.parseInt(id_string);
				Categoria c = (Categoria) cDao.leerUno(id);
				if (cDao.idExist(id)) {
					return MensajesCategoria.mensaje(Messages.CODE_200, Messages.STATUS_200, c);
				}
				else {
					return MensajesCategoria.mensaje(Messages.CODE_400, Messages.CAT_INEXISTENTE, c);  
				}
			}
			catch (NumberFormatException e) {
				return MensajesCategoria.mensajeComun(Messages.CODE_400, Messages.COD_ERRONEO);
			}
		}
		else {
			return MensajesCategoria.mensajeComun(Messages.CODE_400, Messages.PETICION_ERRONEA);
		}
	}

	/**
	 * Método para leer todas las categorías
	 * @return
	 */
	@GetMapping()
	public MensajesCategoria leerTodos(){
		return MensajesCategoria.mensajeList(Messages.CODE_200, Messages.STATUS_200, cDao.leerTodos());
	}

	/**
	 * Método para insertar una categoría en la tabla Categorias
	 * @param c
	 * @return
	 */
	@PostMapping
	public MensajesCategoria insertar(@RequestBody Categoria c) {
		c.setId_categoria(0);
		if (cDao.insertar(c)) {
			return MensajesCategoria.mensajeComun(Messages.CODE_200, Messages.REGISTRO_INSERTADO);
		}
		else {
			return MensajesCategoria.mensajeComun(Messages.CODE_400, Messages.REGISTRO_NO_INSERTADO);
		}
	}
	
	/**
	 * Método para modificar una categoría existente
	 * @param c
	 * @return
	 */
	@PutMapping
	public MensajesCategoria modificar(@RequestBody Categoria c) {
		if (cDao.update(c)) {
			return MensajesCategoria.mensajeComun(Messages.CODE_200, Messages.REGISTRO_MODIFICADO);
		}
		else {
			return MensajesCategoria.mensajeComun(Messages.CODE_400, Messages.REGISTRO_NO_MODIFICADO);
		}
	}
	
	/**
	 * Método para borrar una categoría a través de su Id en formato string
	 * @param id
	 * @return
	 * @throws DAOException
	 */
	@DeleteMapping("/{id}")
	public MensajesCategoria eliminar(@PathVariable("id") String id_string) throws DAOException{
		if (id_string != null) {
			try {
				int id = Integer.parseInt(id_string);
				if (cDao.idExist(id)) {
					cDao.deleteById(id);
					return MensajesCategoria.mensajeComun(Messages.CODE_200, Messages.REGISTRO_BORRADO);
				}
				else {
					return MensajesCategoria.mensajeComun(Messages.CODE_400, Messages.REGISTRO_NO_BORRADO);
				}
			}
			catch (NumberFormatException e) {
				return MensajesCategoria.mensajeComun(Messages.CODE_400, Messages.COD_ERRONEO);
			}
		}
		else {
			return MensajesCategoria.mensajeComun(Messages.CODE_400, Messages.PETICION_ERRONEA);
		}
	}
	
	/**
	 * Método para borrar una categoría 
	 * @param c
	 * @return
	 * @throws DAOException
	 */
	@DeleteMapping
	public MensajesCategoria eliminarCategorias(Categoria c) throws DAOException{
		if (cDao.idExist(c.getId_categoria())) {
			int id = c.getId_categoria();
			String idString= String.valueOf(id);
			eliminar(idString);
			return MensajesCategoria.mensajeComun(Messages.CODE_200, Messages.REGISTRO_BORRADO);
			
		}
		else {
			return MensajesCategoria.mensajeComun(Messages.CODE_400, Messages.REGISTRO_NO_BORRADO);
		}
	}
	
	
}
