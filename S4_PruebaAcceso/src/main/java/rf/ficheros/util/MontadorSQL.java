package rf.ficheros.util;

public class MontadorSQL {
	
	public static String addSalidaSencilla(String salida, String nombreCampo, String valor, String separador) {
		
		if (salida!=null && salida.length()>0) {
			salida = salida+separador+" ";
		}
		if (nombreCampo != null && nombreCampo.length()>0) {
			salida = salida+nombreCampo+" = ";
		}
		salida = salida+valor;
		return salida;
		
	}
	
	public static String addSalida(String salida, String nombreCampo, String valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, "'"+valor+"'", separador);
	}
	
	public static String addSalida(String salida, String nombreCampo, int valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, ""+valor, separador);
	}
	
	public static String addSalida(String salida, String nombreCampo, double valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, ""+valor, separador);
	}
	
	public static String addSalida(String salida, String nombreCampo, long valor, String separador) {
		return addSalidaSencilla(salida, nombreCampo, ""+valor, separador);
	}
	
}
