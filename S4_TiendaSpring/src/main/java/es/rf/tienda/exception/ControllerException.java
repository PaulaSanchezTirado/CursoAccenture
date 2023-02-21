package es.rf.tienda.exception;

public class ControllerException extends Exception{
	
	public ControllerException() {	
	}
	
	public ControllerException(String mensaje) {
		super(mensaje);
	}
}
