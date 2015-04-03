/**
 * 
 */
package es.noletia.clientes.modelo;

import java.io.Serializable;

/**
 * @author ramon
 *
 */
public class Contacto implements Serializable{

	private static final long serialVersionUID = 1644376208445705738L;
	private Long idcontacto;
	private String contacto;
	private String departamento;
	private String email;
	private String telefono;
	private Cliente cliente;
	
	/**
	 * @return the idcontacto
	 */
	public Long getIdcontacto() {
		return idcontacto;
	}
	/**
	 * @param idcontacto the idcontacto to set
	 */
	public void setIdcontacto(Long idcontacto) {
		this.idcontacto = idcontacto;
	}
	/**
	 * @return the contacto
	 */
	public String getContacto() {
		return contacto;
	}
	/**
	 * @param contacto the contacto to set
	 */
	public void setContacto(String contacto) {
		this.contacto = contacto;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		return telefono;
	}
	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	/**
	 * @return the cliente
	 */
	public Cliente getCliente() {
		return cliente;
	}
	/**
	 * @param cliente the cliente to set
	 */
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	/**
	 * @return the departamento
	 */
	public String getDepartamento() {
		return departamento;
	}
	/**
	 * @param departamento the departamento to set
	 */
	public void setDepartamento(String departamento) {
		this.departamento = departamento;
	}
}
