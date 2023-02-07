package rf.ficheros.dao;

import java.sql.SQLException;
import java.util.List;

import rf.ficheros.modelos.Country;

public interface CountryDaoInterface {
	
	public Country leerUno(String country_id) throws Exception;
	public List<Country> leerTodos() throws SQLException, Exception;
	public int actualizar(Country country) throws Exception; // Devuelve las filas afectadas (UPDATE)
	public int delete(Country country) throws Exception;		// DELETE
	public int delete(String country_id) throws Exception;
	public Country insert(Country country) throws Exception; // En este no hace falta devolver un country porque se lo voy a dar todo yo

}
