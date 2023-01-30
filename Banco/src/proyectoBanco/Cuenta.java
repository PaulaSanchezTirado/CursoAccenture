package proyectoBanco;

/**
 * Ejercicio Banco
 */

import java.util.ArrayList;
import java.util.Arrays;

import excepciones.ExcepcionNumeroNegativo;
import excepciones.ExcepcionSaldo;
import excepciones.ExcepcionesLongitud;
import filtros.Filtros;

public class Cuenta {
	
	/**
	 * Esta clase genera la cuenta del usuario y guarda los movimientos que se hacen en ella
	 */
	
	final int TITULAR_MIN = 15;
	final int TITULAR_MAX = 40;
	final int CONCEPTO_MIN = 5;
	final int CONCEPTO_MAX = 100;
	
	private String mNumero;
	private String mTitular;
	private ArrayList<Movimiento> mMovimientos;
	
	// Getters y setters
	public String getmNumero() {
		return mNumero;
	}

	public void setmNumero(String mNumero) {
		this.mNumero = mNumero;
	}

	public String getmTitular() {
		return mTitular;
	}

	public void setmTitular(String mTitular) {
		this.mTitular = mTitular;
	}
	
	public ArrayList<Movimiento> getmMovimientos() {
		return mMovimientos;
	}

	public void setmMovimientos(ArrayList<Movimiento> mMovimientos) {
		this.mMovimientos = mMovimientos;
	}

	// Constructor
	public Cuenta(String mNumero, String mTitular) throws ExcepcionesLongitud {
		if (Filtros.longitudNecesaria(mTitular, TITULAR_MIN, TITULAR_MAX)) {// Si la longitud del titular no es la adecuada, lanza un error
			this.mNumero = mNumero;
			this.mTitular = mTitular;
			mMovimientos = new ArrayList<Movimiento>();
		}
		else {
			throw new ExcepcionesLongitud("El nombre del titular es inválido. No tiene la longitud adecuada");
		}
		
	}
	
	/**
	 * Método para añadir los movimientos (objetos) al arraylist
	 * @param m
	 */
	public void addMovimiento(Movimiento m) {
		mMovimientos.add(m);
		
	}
	
	/**
	 * Método para obtener el saldo de la cuenta
	 * @return
	 */
	public double getSaldo() {
		double saldo = 0;
		
		// Recorre los movimientos y se incorporan los importes a la variable saldo
		for (Movimiento movimiento:mMovimientos) {
				saldo+=movimiento.getmImporte(); // Dan positivos y negativos
		}
		
		/*
		 * getSaldo con Stream
		 * saldo = mMovimientos.stream()
		 * 			     .map(mov->mov.getmImporte())
		 * 				 .reduce(0d, (subtotal, element)->subtotal+element);
		 * 
		 * No se puede acceder a subtotal y a element desde fuera.
		 * El valor inicial de reduce es con el que empiezo
		 */
		
		return saldo;		
	}
	
	/**
	 * Método para ingresar dinero a la cuenta.  
	 * Como no tiene concepto, llama al método al que hay que ingresar concepto
	 * 
	 * @param x
	 * @throws ExcepcionNumeroNegativo
	 * @throws ExcepcionesLongitud
	 */
	public void ingresar(double x) throws ExcepcionNumeroNegativo, ExcepcionesLongitud { 
		ingresar("Ingreso", x);
		}
	
	/**
	 * Método para ingresar dinero en la cuenta con concepto
	 * @param concepto
	 * @param x
	 * @throws ExcepcionNumeroNegativo
	 * @throws ExcepcionesLongitud
	 */
	public void ingresar(String concepto, double x) throws ExcepcionNumeroNegativo, ExcepcionesLongitud{
		if (Filtros.longitudNecesaria(concepto, CONCEPTO_MIN, CONCEPTO_MAX)) { // Si el concepto no tiene la longitud adecuada, lanza un error
			if (x<0) {
				throw new ExcepcionNumeroNegativo("No se puede ingresar un número negativo");// Si el importe es negativo, lanza un error
			}
			// Se crea un objeto movimiento, se añaden concepto e importe y se añaden al arraylist de movimientos
			Movimiento movimiento = new Movimiento();
			movimiento.setmConcepto(concepto);
			movimiento.setmImporte(x);
			addMovimiento(movimiento);
			}
			
		else {
			throw new ExcepcionesLongitud("El concepto es inválido. No tiene la longitud adecuada");
		}
		
	}
	
	/**
	 * Método para retirar dinero de la cuenta. 
	 * Como no tiene concepto, llama al método en el que hay que ingresar concepto
	 * @param x
	 * @throws ExcepcionSaldo
	 * @throws ExcepcionNumeroNegativo
	 * @throws ExcepcionesLongitud
	 */
	public void retirar(double x) throws ExcepcionSaldo, ExcepcionNumeroNegativo, ExcepcionesLongitud {
		retirar("Retirada", x);
	}
	
	/**
	 * Método para retirar dinero de la cuenta con concepto
	 * @param concepto
	 * @param x
	 * @throws ExcepcionSaldo
	 * @throws ExcepcionNumeroNegativo
	 * @throws ExcepcionesLongitud
	 */
	public void retirar(String concepto, double x) throws ExcepcionSaldo, ExcepcionNumeroNegativo, ExcepcionesLongitud{
		if (Filtros.longitudNecesaria(concepto, CONCEPTO_MIN, CONCEPTO_MAX)) {// Si el concepto no tiene la longitud necesaria, lanza un error
			if (x<0) {
				throw new ExcepcionNumeroNegativo("No puede retirar un número negativo");// Si el importe es negativo, lanza un error
			}
			if (getSaldo()<=x) {
				throw new ExcepcionSaldo("No hay suficiente saldo");// Si no hay suficiente saldo para retirar dinero, lanza un error
			}
			// Se crea un objeto movimiento, se añaden concepto e importe y se añaden al arraylist de movimientos
			Movimiento movimiento = new Movimiento();
			movimiento.setmConcepto(concepto);
			movimiento.setmImporte(-x);
			addMovimiento(movimiento);
		}
		else {
			throw new ExcepcionesLongitud("El concepto es inválido. No tiene la longitud adecuada");
		}
	}
	
	public String toString() {
		return "\nNúmero de cuenta:\t\t\t"+getmNumero()+"\nTitular:\t\t\t\t"+getmTitular()+"\n---------------------------------------------------------------"
		+"\nMovimientos de la tarjeta de débito y el cajero automático"+"\n---------------------------------------------------------------"+mMovimientos.toString();		
	}
}