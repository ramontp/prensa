/**
 * 
 */
package es.noletia.clientes.dao;

import es.noletia.clientes.modelo.ClienteCategoria;

/**
 * @author ramon
 *
 */
public interface ClienteCategoriaDAO extends CRUDDAO<ClienteCategoria> {

	public void borraPorCliente(Long idcliente);
	
}
