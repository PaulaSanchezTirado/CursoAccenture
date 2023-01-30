package excepciones;

/**
 * Excepciones para ejercicio Banco
 */

public class ExcepcionSinCredito extends Exception{
	
	public ExcepcionSinCredito() {
		super("Error de crédito");
	}
	
	public ExcepcionSinCredito(String mensajeError) {
		super(mensajeError);
	}
}