/**
 * 
 */
package es.noletia.prensa.modelo;

import java.io.Serializable;

/**
 * @author Ramón
 *
 */
public class Filtro implements Serializable{

	private static final long serialVersionUID = 1L;
	private Medio medio;
	private Categoria categoria1;
	private Categoria categoria2;
	private Ambito ambito;
	
	
	/**
	 * @return the medio
	 */
	public Medio getMedio() {
		return medio;
	}
	/**
	 * @param medio the medio to set
	 */
	public void setMedio(Medio medio) {
		this.medio = medio;
	}
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
	 * @return the ambito
	 */
	public Ambito getAmbito() {
		return ambito;
	}
	/**
	 * @param ambito the ambito to set
	 */
	public void setAmbito(Ambito ambito) {
		this.ambito = ambito;
	}

}
