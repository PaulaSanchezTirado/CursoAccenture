package excepciones;

/**
 * Excepciones para ejercicio Banco
 */

public class ExcepcionNumeroNegativo extends Exception{

	public ExcepcionNumeroNegativo() {
		super("Error. Número negativo");
	}
	
	public ExcepcionNumeroNegativo(String mensajeError) {
		super(mensajeError);
	}
}
