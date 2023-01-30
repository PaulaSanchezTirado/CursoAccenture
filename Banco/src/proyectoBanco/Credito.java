package proyectoBanco;

/**
 * Ejercicio Banco
 */

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import excepciones.ExcepcionNumeroNegativo;
import excepciones.ExcepcionSinCredito;
import excepciones.ExcepcionesLongitud;
import filtros.Filtros;

public class Credito extends Tarjeta{
	
	/**
	 * Clase hija que hereda de Tarjeta. Se trata de una clase muy parecida a cuenta, ya que tiene sus propios movimientos
	 */
	
	public static final double COMISION = 0.05;
	public static final double MINIMO = 3;
	final int TITULAR_MIN = 20;
	final int TITULAR_MAX = 40;
	final int CONCEPTO_MIN = 5;
	final int CONCEPTO_MAX = 100;
	
	private double mCredito;
	private ArrayList<Movimiento> mMovimiento;
	
	// Getters y setters
	public double getmCredito() {
		return mCredito;
	}

	public void setmCredito(double mCredito) {
		this.mCredito = mCredito;
	}

	public ArrayList<Movimiento> getmMovimiento() {
		return mMovimiento;
	}

	public void setmMovimiento(ArrayList<Movimiento> mMovimiento) {
		this.mMovimiento = mMovimiento;
	}
	
	// Constructor
	public Credito(LocalDate mFechaDeCaducidad, String mNumero, String mTitular, double mCredito) throws ExcepcionesLongitud {
		super(mFechaDeCaducidad, mNumero, mTitular);
		this.mCredito = mCredito;
		mMovimiento = new ArrayList<Movimiento>(); // Movimientos de crédito
		if (!Filtros.longitudNecesaria(mTitular, TITULAR_MIN, TITULAR_MAX)) {
			throw new ExcepcionesLongitud("El nombre del titular es inválido. No tiene la longitud adecuada");
		}
		
	}
	
	/**
	 * Método para comprobar el crédito del que se dispone
	 * @return
	 */
	public double getCreditoDisponible() {
		return mCredito+getSaldo();
		
	}
	
	// Método sacado del profesor
	/*
	public void liquidar(int mes, int year) {
		
		Movimiento liquidacion = new Movimiento();
		liquidacion.setmConcepto("Liquidación del"+mes+"/"+year);
		double r = 0;
		for (int i=mMovimiento.size(); i>0; i--) {
			Movimiento movimiento = (Movimiento)mMovimiento.elementAt(i);
			if (movimiento.getmFecha().getMonthValue() == mes && movimiento.getmFecha().getYear() == year) {
				r+=movimiento.getmImporte();
				mMovimiento.remove(i);
			}
		}
	}
	*/
	
	/**
	 * // Método sacado del profesor (REHACER SOLA)
	 * Elimina los movimientos del mes del año que se le ha indicado
	 * @param mes
	 * @param year
	 */
	/*
	public void liquidar(int mes, int year) {
		Movimiento liquidacion = new Movimiento();
		liquidacion.setmConcepto("Liquidación del"+mes+"/"+year);
		double r = 0;
		for (Iterator it = mMovimiento.iterator();it.hasNext();) {
			Movimiento movimiento = (Movimiento)it.next();
			if (movimiento.getmFecha().getMonthValue() == mes && movimiento.getmFecha().getYear() == year) {
				r+=movimiento.getmImporte();
				it.remove();
			}
		}
		liquidacion.setmImporte(r);
		getmCuenta().addMovimiento(liquidacion);
	}
	*/
	
	/**
	 * Método liquidación hecho con stream
	 * @param mes
	 * @param year
	 */
	public void liquidar(int mes, int year) {
		Movimiento liquidacion = new Movimiento();
		liquidacion.setmConcepto("Liquidación del"+mes+"/"+year);
		double r = 0;
		r = mMovimiento.stream()
				.filter(movimiento->movimiento.getmFecha().getMonthValue() == mes && movimiento.getmFecha().getYear() == year)
				.map(movimiento->movimiento.getmImporte())
				.reduce(0d, (subtotal, element)->subtotal+element);
		mMovimiento = new ArrayList<Movimiento>(mMovimiento.stream()
				.filter(movimiento->!(movimiento.getmFecha().getMonthValue() == mes && movimiento.getmFecha().getYear() == year))
				.collect(Collectors.toList()));
		
		liquidacion.setmImporte(r);
		getmCuenta().addMovimiento(liquidacion);
	}
	
	/**
	 * Método para obtener el saldo de la tarjeta de crédito
	 */
	@Override
	public double getSaldo() {
		
		double saldo = 0;
		// Recorre los movimientos y se incorporan los importes a la variable saldo
		for (Movimiento movimiento:mMovimiento) {
				saldo+=movimiento.getmImporte();
		}
		return saldo+getmCredito();
	}
	
	/**
	 * Método para ingresar dinero a la tarjeta de crédito
	 */
	@Override
	public void ingresar(double x) throws ExcepcionNumeroNegativo, ExcepcionesLongitud {
		
		if (x<0) {
			throw new ExcepcionNumeroNegativo("No se puede ingresar un número negativo"); // Si se ingresa un número negativo, lanza un error
		}
		// Se crea un objeto movimiento, se añaden concepto e importe y se añaden al arraylist de movimientos
		Movimiento movimiento = new Movimiento();
		movimiento.setmConcepto("Ingreso en cuenta asociada: ");
		if (Filtros.longitudNecesaria(movimiento.getmConcepto(), CONCEPTO_MIN, CONCEPTO_MAX)) { // Si el concepto no tiene la longitud adecuada, lanza un error
			movimiento.setmImporte(x);
			mMovimiento.add(movimiento);
		}
		else {
			throw new ExcepcionesLongitud("El concepto es inválido. No tiene la longitud adecuada");
		}
	}

	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws ExcepcionNumeroNegativo, ExcepcionesLongitud {
		if (x<0) {
			throw new ExcepcionNumeroNegativo("Número negativo"); // Si se retira un número negativo, lanza un error
		}
		// Se crea un objeto movimiento, se añaden concepto e importe y se añaden al arraylist de movimientos
		Movimiento movimiento = new Movimiento();
		movimiento.setmConcepto("Compra a crédito en: "+datos);
		if (Filtros.longitudNecesaria(movimiento.getmConcepto(), CONCEPTO_MIN, CONCEPTO_MAX)) { // Si el concepto no tiene la longitud adecuada, lanza un error
			movimiento.setmImporte(x);
			mMovimiento.add(movimiento);
		}
		else {
			throw new ExcepcionesLongitud("El concepto es inválido. No tiene la longitud adecuada");
		}
	}

	@Override
	public void retirar(double x) throws ExcepcionSinCredito, ExcepcionNumeroNegativo, ExcepcionesLongitud {
		if (x<0) {
			throw new ExcepcionNumeroNegativo("No puede retirar un número negativo"); // Si se retira un número negativo, lanza un error
		}
		if (x>0) {
			// También puede hacerse así: x =x + (x * COMISION < MINIMO_COMISION ? MINIMO_COMISION : x * COMISION);
			if (x+COMISION*x < MINIMO) {
				x = x+3;
			}
			if (x+COMISION*x > MINIMO) {
				x = x+COMISION*x;
			}
			if (x>getCreditoDisponible()) {
				throw new ExcepcionSinCredito("No tiene crédito suficiente"); // Si no existe crédito suficiente, se lanza un error
			}
			// Se crea un objeto movimiento, se añaden concepto e importe y se añaden al arraylist de movimientos
			Movimiento movimiento = new Movimiento();
			movimiento.setmConcepto("Retirada en cuenta asociada: ");
			if (Filtros.longitudNecesaria(movimiento.getmConcepto(), CONCEPTO_MIN, CONCEPTO_MAX)) { // Si el concepto no tiene la longitud adecuada, lanza un error
				movimiento.setmImporte(-x);
				mMovimiento.add(movimiento);
			}
			else {
				throw new ExcepcionesLongitud("El concepto es inválido. No tiene la longitud adecuada");
			}
		}
	}	
	
	public String toString() {
		return "\nMovimientos de la tarjeta de crédito"+"\n---------------------------------------------------------------"+mMovimiento.toString();
		
	}
}
