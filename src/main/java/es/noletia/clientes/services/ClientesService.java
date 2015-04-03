/**
 * 
 */
package es.noletia.clientes.services;

import es.noletia.clientes.modelo.Cliente;

/**
 * @author ramon
 *
 */
public interface ClientesService extends CRUDService<Cliente>{

	public void borraContacto(Long idcontacto);
	
}
