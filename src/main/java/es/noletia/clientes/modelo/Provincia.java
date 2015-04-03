/**
 * 
 */
package es.noletia.clientes.modelo;

import java.io.Serializable;


/**
 * @author ramon
 *
 */
public class Provincia implements Serializable{

	private static final long serialVersionUID = -6915676569677672600L;
	private Long idprovincia;
	private String nombre;

	/**
	 * @return the idprovincia
	 */
	public Long getIdprovincia() {
		return idprovincia;
	}
	/**
	 * @param idprovincia the idprovincia to set
	 */
	public void setIdprovincia(Long idprovincia) {
		this.idprovincia = idprovincia;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
}
