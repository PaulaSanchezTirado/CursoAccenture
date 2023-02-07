package rf.ficheros.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import rf.ficheros.modelos.Country;
import rf.ficheros.util.MontadorSQL;
import rf.ficheros.util.OracleJDBC;

public class CountryDao implements CountryDaoInterface{

	private Connection conn;
	public final static String SQL_LEER_TODOS_COUNTRY = "Select * from Countries_PST";
	// public final static String SQL_LEER_COUNTRY_POR_ID = "Select * from Countries_PST where country_id = ";
	// public final static String SQL_LEER_COUNTRY_POR_ID_2 = "Select * from Countries_PST where country_id = ?";
	// public final static String SQL_ACTUALIZAR_COUNTRY = "Update Countries_PST set country_id = ?, country_name = ?, region_id = ? where country_id = ?";
	// public final static String SQL_DELETE_COUNTRY = "Delete Countries_PST where country_id = ?";
	// public final static String SQL_INSERT_COUNTRY = "Insert into Countries_PST country_id = ?, country_name = ?, region_id = ?";
	
	public CountryDao() throws SQLException {
		OracleJDBC oracle = new OracleJDBC();
		conn = oracle.abrir();
	}
	
	@Override
	public Country leerUno(String country_id) throws Exception {
		ResultSet rs = null;
		String sql = "Select * from Countries_PST ";
		
		try {
			
			//Esto es otra manera de hacerlo
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(sql+" where "+MontadorSQL.addSalida(sql, country_id, "BR", ","));
			
			/*
			PreparedStatement ps = conn.prepareStatement(SQL_LEER_COUNTRY_POR_ID_2);
			ps.setString(1, country_id); // La interrogación es el 1
			rs = ps.executeQuery();
			*/
			
			// Se necesitaría la comprobación de que hay uno leído o de que hay más de uno leído
			rs.next();
			return carga(rs);
			
		}
		catch (SQLException e) {
			throw new Exception(sql+ " "+ e.getMessage());
		}
	}

	@Override
	public List<Country> leerTodos() throws Exception{
			
		ResultSet rs = null;
		List<Country> salida = new ArrayList<>();
		
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(SQL_LEER_TODOS_COUNTRY);
			
			while (rs.next()) {
				salida.add(carga(rs));
			}
		}
		catch (SQLException e) {
			throw new Exception(SQL_LEER_TODOS_COUNTRY + " "+ e.getMessage());
		}
	
		return salida;
	}

	@Override
	public int actualizar(Country country) throws Exception {
		
		String sql = "Update Countries_PST set "+montaSQL(country);
		sql = sql+" where ";
		sql = MontadorSQL.addSalida(sql, "country_id", country.getCountry_id(), ",");	
		
		try {
			
			Statement stm = conn.createStatement();
			
			/*
			PreparedStatement ps = conn.prepareStatement(SQL_ACTUALIZAR_COUNTRY);
			ps.setString(1, country.getCountry_id()); 
			ps.setString(2, country.getCountry_name());
			ps.setString(3, country.getRegion_id());
			ps.setString(4, country.getCountry_id());
			*/
			
			return stm.executeUpdate(sql);
		}
		catch (SQLException e) {
			throw new Exception("SQL Update Exception" + " "+ e.getMessage());
		}
	}

	@Override
	public int delete(Country country) throws Exception {
		
		String sql = "Delete Countries_PST ";
		sql = sql+"where ";
		sql = MontadorSQL.addSalida(sql, "country_id", "BR", ",");
		
		try {
			
			Statement stm = conn.createStatement();
			
			/*
			PreparedStatement ps = conn.prepareStatement();
			ps.setString(1, country.getCountry_id()); 
			*/
			
			return stm.executeUpdate(sql);
		}
		catch (SQLException e) {
			throw new Exception("SQL Delete Exception" + " "+ e.getMessage());
		}
	}

	@Override
	public int delete(String country_id) throws Exception {
		
		String sql = "Delete Countries_PST ";
		sql = sql+"where ";
		sql = MontadorSQL.addSalida(sql, "country_id", "BR", ",");
		
		try {
			
			Statement stm = conn.createStatement();
			
			/*
			PreparedStatement ps = conn.prepareStatement(SQL_DELETE_COUNTRY);
			ps.setString(1, country_id); 
			*/
			
			return stm.executeUpdate(sql);
		}
		catch (SQLException e) {
			throw new Exception("SQL Delete Exception" + " "+ e.getMessage());
		}
	}
	
	
	@Override
	public Country insert(Country country) throws Exception {
		String sql = "insert into countries_PST "+montaSQL(country);
		
		try {
			Statement stm = conn.createStatement();
			stm.executeUpdate(sql);
			return country;
		}
		catch (SQLException e) {
			throw new Exception("SQL INSERT EXCEPTION "+ e.getMessage());
		}
	}
	
	public Country carga(ResultSet rs) throws SQLException{
		Country ctr = new Country();
		ctr.setCountry_id(rs.getString("country_id"));
		ctr.setCountry_name(rs.getString("country_name"));
		ctr.setRegion_id(rs.getString("region_id"));
		return ctr;
	}
	
	public String montaSQL(Country country) {
		String salida = "";
		salida = MontadorSQL.addSalida(salida, "country_id", country.getCountry_id(), ",");
		salida = MontadorSQL.addSalida(salida, "country_name", country.getCountry_name(), ",");
		salida = MontadorSQL.addSalida(salida, "region_id", country.getRegion_id(), ",");
		
		return salida;
	}
	

}
