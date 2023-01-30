package filtros;

/**
 * Filtros para ejercicio Banco
 */

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Optional;

public class Filtros {
	
	/**
	 * Filtro que determina la longitud necesaria de nombre de titular y concepto
	 * @param nombre
	 * @param longitudMinima
	 * @param longitudMaxima
	 * @return
	 */
	
	public static boolean longitudNecesaria(String nombre, int longitudMinima, int longitudMaxima) {
		boolean longitudMin;
		boolean longitudMax;
		longitudMin =  longitudMinima<=nombre.length();
		longitudMax = nombre.length()<=longitudMaxima;
		return longitudMin && longitudMax;
		
	}
	
	/**
	 * Filtro para determinar que la fecha de caducidad de la tarjeta está en el rango determinado
	 * @param fecha
	 * @param minYear
	 * @param maxYear
	 * @return
	 */
	
	public static boolean fechaAdecuada(LocalDate fecha, int minYear, int maxYear) {
		LocalDate fechaHoy = LocalDate.now();
		LocalDate minFecha = fechaHoy.plusYears(minYear);
		LocalDate maxFecha = fechaHoy.plusYears(maxYear);
		return fecha.isAfter(minFecha) && fecha.isBefore(maxFecha);
		
	}
	
	/**
	 * Filtro para determinar que la fecha utilizada está en el formato correcto.
	 * Si no se le pasa formato, escoge el predeterminado
	 * @param fecha
	 * @return
	 * @throws Exception
	 */
	
	public static LocalDate fechaCorrecta(String fecha){
		return fechaCorrecta(fecha, "dd-MM-yyyy");
	}
	
	/**
	 * Filtro para determinar que la fecha utilizada está en el formato correcto.
	 * Es necesario pasarle el formato que se quiere utilizar
	 * @param fecha
	 * @param formato
	 * @return
	 * @throws Exception
	 */
	
	public static LocalDate fechaCorrecta(String fecha, String formato){
		
		// Se escoge el formato de la fecha
		DateTimeFormatter format = DateTimeFormatter.ofPattern(formato);
		
		// Para que lance un error cuando el formato de la fecha es erróneo, utilizamos try-catch
		try {
			LocalDate fech = (LocalDate.parse(fecha, format)); // Parsea el string fecha con el formato indicado 
			if(!fech.toString().isEmpty()) { // Si no está vacío, devuelve la fecha
				return fech;	
		
			}
		}
		catch (DateTimeParseException e){ // Controlamos el error
		}
		
		return null; // Retorna null
	}
	
	/**
	 * Filtro corregido por el profesor
	 * @param fecha
	 * @param formato
	 * @return
	 * @throws Exception
	 */
	
	public static LocalDate fechaCorrectaCorregido(String fecha, String formato){
		
		
		DateTimeFormatter format = DateTimeFormatter.ofPattern(formato);
		Optional<LocalDate> date = Optional.empty();
		
		try {
			date = Optional.of(LocalDate.parse(fecha, format)); 
			if(date.isPresent()) { // Comprueba que un optional tiene algo dentro
				return date.get(); // Para retornar un LocalDate
		
			}
		}
		catch (DateTimeParseException e){
		}
		
		return null; 
	}
	
	/**
	 * Otras forma de hacer el filtro
	 * @param fecha
	 * @param formato
	 * @return
	 
	public static LocalDate fechaCorrectaForma2(String fecha, String formato){
		
		// Se escoge el formato de la fecha
		DateTimeFormatter format = DateTimeFormatter.ofPattern(formato);
		
		// Para que lance un error cuando el formato de la fecha es erróneo, utilizamos try-catch
		try {
			LocalDate fech = (LocalDate.parse(fecha, format)); // Parsea el string fecha con el formato indicado 
			if(!(fech==null)) { // Si no está vacío, devuelve la fecha (fech == null)
				return fech;	
		
			}
		}
		catch (DateTimeParseException e){ // Controlamos el error
		}
		
		return null; // Retorna null
	}
	
	public static LocalDate fechaCorrectaForma2(String fecha, String formato){
		
		// Se escoge el formato de la fecha
		DateTimeFormatter format = DateTimeFormatter.ofPattern(formato);
		
		// Para que lance un error cuando el formato de la fecha es erróneo, utilizamos try-catch
		try {
			LocalDate fech = (LocalDate.parse(fecha, format)); // Parsea el string fecha con el formato indicado 
			return fech;	
		
			}
		}
		catch (DateTimeParseException e){ // Controlamos el error
		}
		
		return null; // Retorna null
	}
	*/
}