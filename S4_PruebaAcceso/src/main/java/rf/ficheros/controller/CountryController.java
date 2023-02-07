package rf.ficheros.controller;

import java.sql.SQLException;
import java.util.List;

import rf.ficheros.dao.CountryDao;
import rf.ficheros.dao.CountryDaoInterface;
import rf.ficheros.modelos.Country;

public class CountryController {
	
	CountryDaoInterface cDao;
	
	public CountryController() throws SQLException {
		cDao = new CountryDao();
	}
	
	public List<Country> leerTodos() throws Exception {
		return cDao.leerTodos();
		
	}
	
	public Country leerUno(String country_id) throws Exception {
		return cDao.leerUno(country_id);
	}
	
	public int actualizar(Country country) throws Exception {
		return cDao.actualizar(country);
		
	}
	
	public int delete(Country country) throws Exception {
		return cDao.delete(country);
		
	}
	
	public int delete(String country_id) throws Exception {
		return cDao.delete(country_id);
		
	}
	
}
