package proyectoBanco;

/**
 * Ejercicio Banco
 */

import java.time.LocalDate;

public class testBanco {
	
	public static void main(String[] args) throws Exception {
		
		Cuenta cuenta = new Cuenta("89736849", "Sergio Uclés Fernández");
		cuenta.ingresar(1000);
		cuenta.ingresar("Sueldo", 2000);
		cuenta.retirar(200);
		cuenta.retirar("Compra", 500);
		
		LocalDate fecha = LocalDate.now();
		Debito tarjetaDebito = new Debito(fecha, "89736849", "Sergio Uclés Fernández");
		tarjetaDebito.setCuenta(cuenta);// Asociar tarjeta de crédito a una cuenta
		tarjetaDebito.ingresar(10);
		tarjetaDebito.retirar(30);
		tarjetaDebito.pagoEnEstablecimiento("Zara", 45.95);
		
		Credito tarjetaCredito = new Credito(fecha, "89736849", "Sergio Uclés Fernández",  5000);
		tarjetaCredito.setCuenta(cuenta);
		tarjetaCredito.ingresar(100);
		tarjetaCredito.retirar(200);
		tarjetaCredito.pagoEnEstablecimiento("Mercadona", 150);
		
		System.out.println(cuenta.toString());	
		System.out.println(tarjetaCredito.toString());
		System.out.println("\n---------------------------------------------------------------");
		System.out.println("El saldo final de la cuenta es de: "+cuenta.getSaldo());
		System.out.println("El saldo de la tarjeta de crédito es de: "+tarjetaCredito.getSaldo());
		
		tarjetaCredito.liquidar(fecha.getMonthValue(), fecha.getYear());
		System.out.println(tarjetaCredito.toString());
		System.out.println("Tras liquidar, el saldo de la tarjeta de crédito es de: "+tarjetaCredito.getSaldo());
		System.out.println("Tras liquidar, el saldo de la tarjeta de crédito es de: "+cuenta.getSaldo());
		
	}

}
