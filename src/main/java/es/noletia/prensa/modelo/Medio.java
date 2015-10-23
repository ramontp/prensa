/**
 * 
 */
package es.noletia.prensa.modelo;

import java.io.Serializable;
import java.util.List;

/**
 * @author ramon
 *
 */
public class Medio implements Serializable{

	private static final long serialVersionUID = -3254545985936533800L;
	private Long idmedio;
	private String nombre;
	private Ambito ambito;
	private String observaciones;
	private List<Contacto> listacontactos;
	private List<Categoria> listacategorias;
	private Categoria categoria1;
	private Categoria categoria2;
	
	/**
	 * @return the categoria1
	 */
	public Categoria getCategoria1() {
		return categoria1;
	}
	/**
	 * @param categoria1 the categoria1 to set
	 */
	public void setCategoria1(Categoria categoria1) {
		this.categoria1 = categoria1;
	}
	/**
	 * @return the categoria2
	 */
	public Categoria getCategoria2() {
		return categoria2;
	}
	/**
	 * @param categoria2 the categoria2 to set
	 */
	public void setCategoria2(Categoria categoria2) {
		this.categoria2 = categoria2;
	}
	/**
	 * @return the idmedio
	 */
	public Long getIdmedio() {
		return idmedio;
	}
	/**
	 * @param idmedio the idmedio to set
	 */
	public void setIdmedio(Long idcliente) {
		this.idmedio = idcliente;
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
	public void setNombre(String empresa) {
		this.nombre = empresa;
	}
	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}
	/**
	 * @param observaciones the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}
	/**
	 * @return the listacontactos
	 */
	public List<Contacto> getListacontactos() {
		return listacontactos;
	}
	/**
	 * @param listacontactos the listacontactos to set
	 */
	public void setListacontactos(List<Contacto> listacontactos) {
		this.listacontactos = listacontactos;
	}
	/**
	 * @return the listacategorias
	 */
	public List<Categoria> getListacategorias() {
		return listacategorias;
	}
	/**
	 * @param listacategorias the listacategorias to set
	 */
	public void setListacategorias(List<Categoria> listacategorias) {
		this.listacategorias = listacategorias;
	}
	public Ambito getAmbito() {
		return ambito;
	}
	public void setAmbito(Ambito ambito) {
		this.ambito = ambito;
	}
}
