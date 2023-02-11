package es.rf.tienda.dominio;

import java.time.LocalDate;

import es.rf.tienda.util.Messages;
import es.rf.tienda.util.Validator;
import io.micrometer.common.util.StringUtils;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import es.rf.tienda.exception.DomainException;

/**
 * 
 * Nombre		Producto
 * Descripcion	Lista de producto
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */

@Entity
@Table(schema="ALUMNO_PST", name = "PRODUCTOS")
public class Producto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private String id_producto;
	@Column(nullable=false, length = 100)
	private String pro_descripcion;
	@Column(length = 2000)
	private String pro_desLarga;
	@Column(nullable=false)
	private double pro_precio; 
	@Column
	private int pro_stock;
	@Column
	private LocalDate pro_fecRepos;
	@Column
	private LocalDate pro_fecActi;
	@Column
	private LocalDate fecDesacti;
	@Column(nullable=false, length = 10)
	private String pro_uniVenta;
	@Column
	private int pro_cantXUniVenta;
	@Column
	private String pro_uniUltNivel;
	@Column(nullable=false)
	private int id_pais;
	@Column(length = 2000)
	private String pro_usoRecomendado;
	@ManyToOne(targetEntity = Categoria.class, cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "id_categoria", nullable = false)
	private Categoria id_categoria;
	@Column
	private int pro_stkReservado;
	@Column
	private int pro_nStkAlto;
	@Column
	private int pro_nStkBajo;
	@Column
	private char pro_stat;
	
	/**
	 * Límites id_producto
	 */
	private transient final int LIM_MIN_ID_PRODUCTO = 5;
	private transient final int LIM_MAX_ID_PRODUCTO = 5;
	
	/**
	 * Límites pro_descripcion
	 */
	private transient final int LIM_MIN_PRO_DESCRIPCION = 5;
	private transient final int LIM_MAX_PRO_DESCRIPCION = 100;
	
	/**
	 * Límites pro_desLarga
	 */
	private transient final int LIM_MIN_PRO_DESLARGA = 5;
	private transient final int LIM_MAX_PRO_DESLARGA = 2000;
	
	/**
	 * Límites pro_precio
	 */
	private transient final int LIM_MIN_PRO_PRECIO = 0;
	private transient final int LIM_MAX_PRO_PRECIO = 100;
	
	/**
	 * Límite fecRepos y fecActi
	 */
	private transient final LocalDate HOY = LocalDate.now();
	
	/**
	 * Longitud pro_uniVenta, pro_usoRecomendado
	 */
	private transient final int LONG_PROUNIVENTA_MAX = 10;
	private transient final int LONG_PROUSORECOMENDADO_MAX = 2000;
	
	public String getId_producto() {
		return id_producto;
	}
	
	public void setId_producto(String id_producto) throws DomainException {
		if (Validator.cumpleLongitud(id_producto, LIM_MIN_ID_PRODUCTO, LIM_MAX_ID_PRODUCTO)) {
			if (Validator.codigoProductoValido(id_producto)) {
				this.id_producto = id_producto;
			}
			else {
				throw new DomainException(Messages.PROERR_001);
			}
		}
		
		else {
			throw new DomainException(Messages.PROERR_003);
		}
	}
	
	public String getPro_descripcion() {
		return pro_descripcion;
	}
	
	public void setPro_descripcion(String pro_descripcion) throws DomainException {
		if (Validator.cumpleLongitud(pro_descripcion, LIM_MIN_PRO_DESCRIPCION, LIM_MAX_PRO_DESCRIPCION)) {
			this.pro_descripcion = pro_descripcion;
		}
		else {
			throw new DomainException(Messages.PROERR_003);
		}
	}
	
	public String getPro_desLarga() {
		return pro_desLarga;
	}
	
	public void setPro_desLarga(String pro_desLarga) throws DomainException {
		if (Validator.cumpleLongitud(pro_desLarga, LIM_MIN_PRO_DESLARGA, LIM_MAX_PRO_DESLARGA)) {
			this.pro_desLarga = pro_desLarga;
		}
		else {
			throw new DomainException(Messages.PROERR_003);
		}
	}
	
	public double getPro_precio() {
		return pro_precio;
	}
	
	public void setPro_precio(double pro_precio) throws DomainException {
		if(Validator.cumpleRango(pro_precio, LIM_MIN_PRO_PRECIO, LIM_MAX_PRO_PRECIO)) {
			this.pro_precio = pro_precio;
		}
		else {
			throw new DomainException(Messages.PROERR_004);
		}
	}
	
	public int getPro_stock() {
		return pro_stock;
	}
	
	public void setPro_stock(int pro_stock) {
		this.pro_stock = pro_stock;
	}
	
	public LocalDate getPro_fecRepos() {
		return pro_fecRepos;
	}
	
	public void setPro_fecRepos(LocalDate pro_fecRepos) throws DomainException {
		if (Validator.valDateMin(pro_fecRepos, HOY)) {
			this.pro_fecRepos = pro_fecRepos;
		}
		else {
			throw new DomainException(Messages.PROERR_005);
		}
	}
	
	public LocalDate getPro_fecActi() {
		return pro_fecActi;
	}
	
	public void setPro_fecActi(LocalDate pro_fecActi) throws DomainException {
		if (Validator.valDateMin(pro_fecActi, HOY)) {
			this.pro_fecActi = pro_fecActi;
		}
		else {
			throw new DomainException(Messages.PROERR_006);
		}
	}
	
	public LocalDate getFecDesacti() {
		return fecDesacti;
	}
	
	public void setFecDesacti(LocalDate fecDesacti) throws DomainException {
		if (this.pro_fecActi==null) {
			if (Validator.valDateMin(fecDesacti, HOY)) {
				this.fecDesacti = fecDesacti;
			}
			else {
				throw new DomainException(Messages.PROERR_007);
			}
		}
		else {
			if(Validator.valDateMin(fecDesacti, this.pro_fecActi)) {
				this.fecDesacti = fecDesacti;
			}
			else {
				throw new DomainException(Messages.PROERR_007);
			}
		}	
	}
	
	public String getPro_uniVenta() {
		return pro_uniVenta;
	}
	
	public void setPro_uniVenta(String pro_uniVenta) {
		this.pro_uniVenta = StringUtils.truncate(pro_uniVenta, LONG_PROUNIVENTA_MAX);;
	}
	
	public int getPro_cantXUniVenta() {
		return pro_cantXUniVenta;
	}
	
	public void setPro_cantXUniVenta(int pro_cantXUniVenta) {
		this.pro_cantXUniVenta = pro_cantXUniVenta;
	}
	
	public String getPro_uniUltNivel() {
		return pro_uniUltNivel;
	}
	
	public void setPro_uniUltNivel(String pro_uniUltNivel) {
		this.pro_uniUltNivel = pro_uniUltNivel;
	}
	
	public int getId_pais() {
		return id_pais;
	}
	
	public void setId_pais(int id_pais) {
		this.id_pais = id_pais;
	}
	
	public String getPro_usoRecomendado() {
		return pro_usoRecomendado;
	}
	
	public void setPro_usoRecomendado(String pro_usoRecomendado){
		this.pro_usoRecomendado = StringUtils.truncate(pro_usoRecomendado, LONG_PROUSORECOMENDADO_MAX);
	}
	
	public Categoria getId_categoria() {
		return id_categoria;
	}
	
	public void setId_categoria(Categoria id_categoria) {
		this.id_categoria = id_categoria;
	}
	
	public int getPro_stkReservado() {
		return pro_stkReservado;
	}
	
	public void setPro_stkReservado(int pro_stkReservado) {
		this.pro_stkReservado = pro_stkReservado;
	}
	
	public int getPro_nStkAlto() {
		return pro_nStkAlto;
	}
	
	public void setPro_nStkAlto(int pro_nStkAlto) {
		this.pro_nStkAlto = pro_nStkAlto;
	}
	
	public int getPro_nStkBajo() {
		return pro_nStkBajo;
	}
	
	public void setPro_nStkBajo(int pro_nStkBajo) {
		this.pro_nStkBajo = pro_nStkBajo;
	}
	
	public char getPro_stat() {
		return pro_stat;
	}
	
	public void setPro_stat(char pro_stat) {
		this.pro_stat = pro_stat;
	}
	
}