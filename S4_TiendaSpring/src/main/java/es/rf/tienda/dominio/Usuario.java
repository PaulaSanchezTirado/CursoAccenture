package es.rf.tienda.dominio;

import java.time.LocalDate;

import es.rf.tienda.exception.DomainException;
import es.rf.tienda.util.Messages;
import es.rf.tienda.util.Validator;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * 
 * Nombre		Usuario
 * Descripcion	Lista de usuarios
 * @author 		Paula Sánchez
 * @version		Enero 2023
 *
 */
@Entity
@Table(schema="ALUMNO_PST", name = "USUARIOS")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private int id_usuario;
	@Column(nullable=false, length = 100)
	private String user_nombre;
	@Column(nullable=false, length = 100)
	private String user_email;
	@Column(nullable=false, length = 20)
	private String user_pass;
	@Column(nullable=false)
	private int user_tipo;
	@Column(length = 12)
	private String user_dni;
	@Column
	private LocalDate user_fecAlta;
	@Column
	private LocalDate user_fecConfirmacion;
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "dir_nombre", column = @Column(name = "nombrePago")),
						 @AttributeOverride(name = "dir_direccion", column = @Column(name = "direccionPago")),
						 @AttributeOverride(name = "dir_poblacion", column = @Column(name = "poblacionPago")),
						 @AttributeOverride(name = "dir_cPostal", column = @Column(name = "cPostalPago")),
						 @AttributeOverride(name = "dir_provincia", column = @Column(name = "provinciaPago")),
						 @AttributeOverride(name = "dir_correoE", column = @Column(name = "correoEPago")),
						 @AttributeOverride(name = "dir_pais", column = @Column(name = "paisPago"))})
	private Direccion user_pago;
	@Embedded
	@AttributeOverrides({@AttributeOverride(name = "dir_nombre", column = @Column(name = "nombreEnvio")),
						 @AttributeOverride(name = "dir_direccion", column = @Column(name = "direccionEnvio")),
						 @AttributeOverride(name = "dir_poblacion", column = @Column(name = "poblacionEnvio")),
						 @AttributeOverride(name = "dir_cPostal", column = @Column(name = "cPostalEnvio")),
						 @AttributeOverride(name = "dir_provincia", column = @Column(name = "provinciaEnvio")),
						 @AttributeOverride(name = "dir_correoE", column = @Column(name = "correoEEnvio")),
						 @AttributeOverride(name = "dir_pais", column = @Column(name = "paisEnvio"))})
	private Direccion user_envio;

	/**
	 * Límite user_nombre
	 */
	private transient final int LIM_MIN_USER_NOMBRE = 5;
	private transient final int LIM_MAX_USER_NOMBRE = 100;
	
	/**
	 * Límite user_fecAlta
	 */
	private transient final LocalDate HOY = LocalDate.now();
	
	public int getId_usuario() {
		return id_usuario;
	}
	
	public void setId_usuario(int id_usuario) {
		this.id_usuario = id_usuario;
	}
	
	public String getUser_nombre() {
		return user_nombre;
	}
	
	public void setUser_nombre(String user_nombre) throws DomainException {
		if (Validator.cumpleLongitud(user_nombre, LIM_MIN_USER_NOMBRE, LIM_MAX_USER_NOMBRE)) {
			this.user_nombre = user_nombre;
		}
		else {
			throw new DomainException(Messages.USERR_001);
		}
	}
	
	public String getUser_email() {
		return user_email;
	}
	
	public void setUser_email(String user_email) throws DomainException {
		if (Validator.isEmailValido(user_email)) {
				this.user_email = user_email;
		}
		else {
			throw new DomainException(Messages.USERR_002);
		}	
	}
	
	public String getUser_pass() {
		return user_pass;
	}
	
	public void setUser_pass(String user_pass) throws DomainException {
		if (Validator.esPasswordValida(user_pass)) {
			this.user_pass = user_pass;
		}
		else {
			throw new DomainException(Messages.USERR_003);
		}
	}
	
	public int getUser_tipo() {
		return user_tipo;
	}
	
	public void setUser_tipo(int user_tipo) {
		this.user_tipo = user_tipo;
	}
	
	public String getUser_dni() {
		return user_dni;
	}
	
	public void setUser_dni(String user_dni) throws DomainException {
		if (Validator.cumpleDNI(user_dni)) {
			this.user_dni = user_dni;
		}
		else {
			throw new DomainException(Messages.USERR_004);
		}
	}
	
	public LocalDate getUser_fecAlta() {
		return user_fecAlta;
	}
	
	public void setUser_fecAlta(LocalDate user_fecAlta) throws DomainException {
		if (Validator.valDateEqual(user_fecAlta, HOY)){
			this.user_fecAlta = user_fecAlta;
		}
		else {
			throw new DomainException(Messages.USERR_005);
		}
	}
	
	public LocalDate getUser_fecConfirmacion() {
		return user_fecConfirmacion;
	}
	
	public void setUser_fecConfirmacion(LocalDate user_fecConfirmacion) throws DomainException {
		if (Validator.valDateEqual(user_fecConfirmacion, HOY)){
			this.user_fecConfirmacion = user_fecConfirmacion;
		}
		else {
			throw new DomainException(Messages.USERR_006);
		}
	}
	
	public Direccion getUser_pago() {
		return user_pago;
	}

	public void setUser_pago(Direccion user_pago) {
		this.user_pago = user_pago;
	}

	public Direccion getUser_envio() {
		return user_envio;
	}

	public void setUser_envio(Direccion user_envio) {
		this.user_envio = user_envio;
	}
	
}
