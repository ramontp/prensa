/**
 * 
 */
package es.noletia.clientes.dao;

import es.noletia.clientes.modelo.Contacto;

/**
 * @author ramon
 *
 */
public interface ContactoDAO extends CRUDDAO<Contacto> {

	public void borraContactosPorCliente(Long idcliente);
}
