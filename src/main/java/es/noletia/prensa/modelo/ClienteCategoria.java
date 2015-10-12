/**
 * 
 */
package es.noletia.prensa.modelo;

import java.io.Serializable;

/**
 * @author ramon
 *
 */
public class ClienteCategoria implements Serializable{
	
	private static final long serialVersionUID = -3872403762805692145L;
	private Long idcliente;
	private Long idcategoria;
	/**
	 * @return the idcliente
	 */
	public Long getIdcliente() {
		return idcliente;
	}
	/**
	 * @param idcliente the idcliente to set
	 */
	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}
	/**
	 * @return the idcategoria
	 */
	public Long getIdcategoria() {
		return idcategoria;
	}
	/**
	 * @param idcategoria the idcategoria to set
	 */
	public void setIdcategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}
}
