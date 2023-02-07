package controller;

import java.sql.SQLException;
import java.util.List;

import dao.CountryDao;
import modelos.Country;


public class CountryController {
	
	CountryDao cDao;
	
	public CountryController() throws SQLException {
		cDao = new CountryDao();
	}
	
	public List<Country> leerTodos() throws Exception {
		return cDao.obtenerCountries();
		
	}
	
	public Country leerUno(String country_id) throws Exception {
		return cDao.buscar(country_id);
	}
	
	public void actualizar(Country country) throws Exception {
		cDao.editar(country);
		
	}
	
	 public void delete(Country country) throws Exception {
		cDao.eliminar(country);
	 
	 }
	 
	public void delete(String country_id) throws Exception {
		cDao.eliminar(country_id);
		
	}
	
}
