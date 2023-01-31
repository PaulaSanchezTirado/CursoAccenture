package ejercicioReloj;

import java.text.DecimalFormat;

public class Reloj {

	public static void main(String[] args) throws InterruptedException {
		
		int hora;
		int minuto;
		int segundo;
		
		DecimalFormat formateador = new DecimalFormat("00");
		
		System.out.println("Reloj:");
		
		for (hora=0; hora<24; hora++) {
			for (minuto=0;minuto<60;minuto++) {
				for (segundo=0;segundo<60;segundo++) {
					System.out.println(formateador.format(hora)+":"+formateador.format(minuto)+":"+formateador.format(segundo));
					Thread.sleep(1000);
				}
			}
		}

	}

}
