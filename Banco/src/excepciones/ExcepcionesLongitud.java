package excepciones;

/**
 * Excepciones para ejercicio Banco
 */

public class ExcepcionesLongitud extends Exception{
	
	public ExcepcionesLongitud() {
		super("Error de longitud inválida");
	}
	
	public ExcepcionesLongitud(String mensajeError) {
		super(mensajeError);
	}

}
