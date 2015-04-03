/**
 * 
 */
package es.noletia.clientes.modelo;

import java.io.Serializable;

/**
 * @author ramon
 *
 */
public class Categoria implements Serializable{

	private static final long serialVersionUID = -7168921653471456217L;
	private Long idcategoria;
	private String nombrecategoria;
	private Boolean seleccionado=false;
	
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof Categoria){
			Categoria cat = (Categoria) obj;
			return (this.idcategoria == cat.getIdcategoria() && this.getNombrecategoria().equals(cat.getNombrecategoria()));
		}
		return false;
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
	/**
	 * @return the nombrecategoria
	 */
	public String getNombrecategoria() {
		return nombrecategoria;
	}
	/**
	 * @param nombrecategoria the nombrecategoria to set
	 */
	public void setNombrecategoria(String nombrecategoria) {
		this.nombrecategoria = nombrecategoria;
	}
	/**
	 * @return the seleccionado
	 */
	public Boolean getSeleccionado() {
		return seleccionado;
	}
	/**
	 * @param seleccionado the seleccionado to set
	 */
	public void setSeleccionado(Boolean seleccionado) {
		this.seleccionado = seleccionado;
	}
}
