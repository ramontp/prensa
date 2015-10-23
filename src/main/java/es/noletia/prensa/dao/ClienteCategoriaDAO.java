/**
 * 
 */
package es.noletia.prensa.dao;

import es.noletia.prensa.modelo.ClienteCategoria;

/**
 * @author ramon
 *
 */
public interface ClienteCategoriaDAO extends CRUDDAO<ClienteCategoria> {

	public void borraPorCliente(Long idcliente);
	
}
