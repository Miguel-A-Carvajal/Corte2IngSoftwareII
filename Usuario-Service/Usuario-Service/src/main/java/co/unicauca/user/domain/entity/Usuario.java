package co.unicauca.user.domain.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;

/**
 * Representa un usuario de la tienda, mapeado con la base de datos.
 *
 * @author wpantoja, ahurtado
 */
@Entity
@Table(name = "Usuario")
public class Usuario implements Serializable {

	/** Identificador único del usuario */
	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	private Long usuario_id;

	/** Nombre del usuario */
	private String name;

	/** Correo electrónico del usuario */
	private String email;

	/** Contraseña del usuario */
	private String password;

	/** Lista de roles asociados al usuario */
	@ManyToMany
	@JoinTable(name = "usuario_rol",
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "id_rol"))
	private List<Rol> roles = new ArrayList<>();

	/** Fecha de creación del usuario */
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	private Date createAt;

	/**
	 * Constructor de Usuario con todos los atributos.
	 *
	 * @param usuario_id Identificador único del usuario
	 * @param name Nombre del usuario
	 * @param email Correo electrónico del usuario
	 * @param password Contraseña del usuario
	 * @param roles Lista de roles asociados al usuario
	 * @param createAt Fecha de creación del usuario
	 */
	public Usuario(Long usuario_id, String name, String email, String password, List<Rol> roles, Date createAt) {
		this.usuario_id = usuario_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
		this.createAt = createAt;
	}

	/**
	 * Constructor de Usuario sin la fecha de creación.
	 *
	 * @param usuario_id Identificador único del usuario
	 * @param name Nombre del usuario
	 * @param email Correo electrónico del usuario
	 * @param password Contraseña del usuario
	 * @param roles Lista de roles asociados al usuario
	 */
	public Usuario(Long usuario_id, String name, String email, String password, List<Rol> roles) {
		this.usuario_id = usuario_id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.roles = roles;
	}

	/**
	 * Constructor vacío de Usuario.
	 */
	public Usuario() {

	}

	public Long getUsuario_id() {
		return usuario_id;
	}

	public void setUsuario_id(Long usuario_id) {
		this.usuario_id = usuario_id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Rol> getRoles() {
		return roles;
	}

	public void setRoles(List<Rol> roles) {
		this.roles = roles;
	}

	public Date getCreateAt() {
		return createAt;
	}

	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
}