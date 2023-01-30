package excepciones;

/**
 * Excepciones para ejercicio Banco
 */

public class ExcepcionSaldo extends Exception{
	
	public ExcepcionSaldo() {
		super("Error. Saldo insuficiente");
	}
	
	public ExcepcionSaldo(String mensajeError) {
		super(mensajeError);
	}

}
