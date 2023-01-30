package proyectoBanco;

/**
 * Ejercicio Banco
 */
	
import java.time.LocalDate;

import excepciones.ExcepcionNumeroNegativo;
import excepciones.ExcepcionSaldo;
import excepciones.ExcepcionSinCredito;
import excepciones.ExcepcionesLongitud;

public abstract class Tarjeta {
	
	/**
	 * Clase tarjeta padre 
	 */
	
	private LocalDate mFechaDeCaducidad;
	private String mNumero;
	private String mTitular;
	private Cuenta mCuentaAsociada;
	
	// Getters y setters
	public LocalDate getmFechaDeCaducidad() {
		return mFechaDeCaducidad;
	}
	
	public void setmFechaDeCaducidad(LocalDate mFechaDeCaducidad) {
		this.mFechaDeCaducidad = mFechaDeCaducidad;
	}
	
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
	
	public Cuenta getmCuenta() {
		return mCuentaAsociada;
	}
	
	public void setmCuenta(Cuenta mCuenta) {
		this.mCuentaAsociada = mCuenta;
	}
	
	// Constructor
	public Tarjeta(LocalDate mFechaDeCaducidad, String mNumero, String mTitular) {
		super();
		this.mFechaDeCaducidad = mFechaDeCaducidad;
		this.mNumero = mNumero;
		this.mTitular = mTitular;
		
	}
	
	// Métodos que van a sobreescribirse en las clases hijas
	public abstract double getSaldo();
	public abstract void ingresar(double x) throws ExcepcionNumeroNegativo, ExcepcionesLongitud;
	public abstract void pagoEnEstablecimiento(String datos, double x) throws ExcepcionNumeroNegativo, ExcepcionSaldo, ExcepcionesLongitud;
	public abstract void retirar(double x) throws ExcepcionSaldo, ExcepcionNumeroNegativo, ExcepcionesLongitud, ExcepcionSinCredito;
	public void setCuenta(Cuenta c) {
		 mCuentaAsociada = c;
	}

}
