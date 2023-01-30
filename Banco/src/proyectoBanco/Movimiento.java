package proyectoBanco;

/**
 * Ejercicio Banco
 */

import java.time.LocalDate;

public class Movimiento {
	
	private String mConcepto;
	private LocalDate mFecha;
	private double mImporte;
	
	// Getters y setters
	public String getmConcepto() {
		return mConcepto;
	}
	public void setmConcepto(String mConcepto) {
		this.mConcepto = mConcepto;
	}
	public LocalDate getmFecha() {
		return mFecha;
	}
	public void setmFecha(LocalDate mFecha) {
		this.mFecha = mFecha;
	}
	public double getmImporte() {
		return mImporte;
	}
	public void setmImporte(double mImporte) {
		this.mImporte = mImporte;
	}
	// Constructor
	public Movimiento() {
		mFecha = LocalDate.now();
	}
	
	/**
	 * Con este método no tengo que repetir en cada clase .set
	 * Es más sencillo para trabajar.
	 * 
	 * public Movimiento(String mConcepto, double mImporte) {
		this.mConcepto = mConcepto;
		this.mImporte = mImporte;
		mFecha = LocalDate.now();
	}
	 */
	
	public String toString(){
		return "\nConcepto:\t\t\t"+getmConcepto()+"\nFecha:\t\t\t\t"+getmFecha()+"\nImporte:\t\t\t"+getmImporte();

	}
}
