package rf.ficheros.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import rf.ficheros.modelos.Country;

public class OracleJDBC {
	
	private static Connection conn;
	public final static  String JDBC_DRIVER = "oracle.jdbc.driver.OracleDriver";  
	public final static String URL ="jdbc:oracle:thin:@95.17.8.252:1521:xe";
	//public final static String URL ="jdbc:oracle:thin:@localhost:1521:xe";
	public final static String DATABASE =  "";
	public final static String USUARIO="hr";
	public final static String PASSWORD="hr";
	//public final static String SQL_USE = "USE  ";
	//public final static String SQL_CREATE = "CREATE DATABASE ";
	
	public final static String SQL_LEER_TODOS = "Select * from Employees";

	public Connection abrir() throws SQLException {

		System.out.println("-------- Oracle JDBC Connection Testing ------");
		
		//Carga driver
		try {
			Class.forName(JDBC_DRIVER);
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return null;
		}
		System.out.println("Oracle JDBC Driver Registered!");
		
		//Consigue conexion
		conn = null;
		try {
			conn = DriverManager.getConnection(URL+DATABASE,USUARIO,PASSWORD);
		} catch (SQLException e) {
			System.out.println("Connection Failed! Check output console");
			e.printStackTrace();
			return null;
		}
		conn.setAutoCommit(false); // Esto significa que no va a hacer autocommit. Lo haré yo cuando me interese
		return conn;
	}
	
	public void cerrar() throws SQLException {
		if (conn != null) {
			System.out.println("You made it, take control your database now!");
			conn.rollback(); // Cuando se cierre la base de datos, todo lo que no se haya commiteado, se borrará
			conn.close();
		} else {
			System.out.println("Failed to make connection!");
		}
	}
	
	public static void lecturaEmployees() throws SQLException {
		
		ResultSet rs = null;
		
		try {
			Statement stm = conn.createStatement();
			rs = stm.executeQuery(SQL_LEER_TODOS);
			
			while (rs.next()) {
				System.out.println(rs.getString("First_name")+" "+rs.getString("last_name")); // Facilita la columna
			}
		}
		catch (SQLException e) {
			System.out.println(SQL_LEER_TODOS + " "+ e.getMessage());
		}
		finally {
			if (rs != null) {
				rs.close();
			}
		}
	}
	
}

