/**
 * 
 */
package es.noletia.clientes.modelo;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * @author ramon
 *
 */
public class Cliente implements Serializable{

	private static final long serialVersionUID = -3254545985936533800L;
	private Long idcliente;
	private String empresa;
	private Provincia provincia;
	private String datosfiscales;
	private String contactado;
	private Date fechault;
	private String observaciones;
	private List<Contacto> listacontactos;
	private List<Categoria> listacategorias;
	
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
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}
	/**
	 * @param empresa the empresa to set
	 */
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}
	/**
	 * @return the provincia
	 */
	public Provincia getProvincia() {
		return provincia;
	}
	/**
	 * @param provincia the provincia to set
	 */
	public void setProvincia(Provincia provincia) {
		this.provincia = provincia;
	}
	/**
	 * @return the datosfiscales
	 */
	public String getDatosfiscales() {
		return datosfiscales;
	}
	/**
	 * @param datosfiscales the datosfiscales to set
	 */
	public void setDatosfiscales(String datosfiscales) {
		this.datosfiscales = datosfiscales;
	}
	/**
	 * @return the contactado
	 */
	public String getContactado() {
		return contactado;
	}
	/**
	 * @param contactado the contactado to set
	 */
	public void setContactado(String contactado) {
		this.contactado = contactado;
	}
	/**
	 * @return the fechault
	 */
	public Date getFechault() {
		return fechault;
	}
	/**
	 * @param fechault the fechault to set
	 */
	public void setFechault(Date fechault) {
		this.fechault = fechault;
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
}
