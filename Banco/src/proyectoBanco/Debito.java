package proyectoBanco;

/**
 * Ejercicio Banco
 */

import java.time.LocalDate;

import excepciones.ExcepcionNumeroNegativo;
import excepciones.ExcepcionSaldo;
import excepciones.ExcepcionesLongitud;
import filtros.Filtros;

public class Debito extends Tarjeta{
	
	/**
	 * Clase hija de Tarjeta cuyos movimientos se asocian directamente a cuenta
	 * @param mFechaDeCaducidad
	 * @param mNumero
	 * @param mTitular
	 * @throws ExcepcionesLongitud
	 */
	
	// Constructor
	public Debito(LocalDate mFechaDeCaducidad, String mNumero, String mTitular) throws ExcepcionesLongitud {
		super(mFechaDeCaducidad, mNumero, mTitular);
		if (!Filtros.longitudNecesaria(mTitular, 20, 40)) {// Si la longitud del titular no es la adecuada, lanza un error
			throw new ExcepcionesLongitud("El nombre del titular es inválido. No tiene la longitud adecuada");
		}
	}
	
	// Los siguientes métodos acceden a los métodos de cuenta directamente
	@Override
	public double getSaldo() {		
		return getmCuenta().getSaldo();
	}

	@Override
	public void ingresar(double x) throws ExcepcionNumeroNegativo, ExcepcionesLongitud {		
		getmCuenta().ingresar("Ingreso en cajero automático: ", x);
	}

	@Override
	public void pagoEnEstablecimiento(String datos, double x) throws ExcepcionNumeroNegativo, ExcepcionSaldo, ExcepcionesLongitud{		
		getmCuenta().retirar("Compras en: "+datos, x);	
	}

	@Override
	public void retirar(double x) throws ExcepcionSaldo, ExcepcionNumeroNegativo, ExcepcionesLongitud {
			getmCuenta().retirar("Retirada en cajero automático: ", x);	
	}
	
}
