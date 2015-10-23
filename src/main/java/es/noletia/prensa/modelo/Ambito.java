/**
 * 
 */
package es.noletia.prensa.modelo;

import java.io.Serializable;


/**
 * @author ramon
 *
 */
public class Ambito implements Serializable{

	private static final long serialVersionUID = -6915676569677672600L;
	private Long idambito;
	private String nombre;
	private String agrupacion;
	
	
	/**
	 * @return the idambito
	 */
	public Long getIdambito() {
		return idambito;
	}
	/**
	 * @param idambito the idambito to set
	 */
	public void setIdambito(Long idambito) {
		this.idambito = idambito;
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
	/**
	 * @return the agrupacion
	 */
	public String getAgrupacion() {
		return agrupacion;
	}
	/**
	 * @param agrupacion the agrupacion to set
	 */
	public void setAgrupacion(String agrupacion) {
		this.agrupacion = agrupacion;
	}
	
}
