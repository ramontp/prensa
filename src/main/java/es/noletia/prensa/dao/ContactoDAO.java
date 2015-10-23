/**
 * 
 */
package es.noletia.prensa.dao;

import java.util.List;

import es.noletia.prensa.modelo.Contacto;
import es.noletia.prensa.modelo.Filtro;

/**
 * @author ramon
 *
 */
public interface ContactoDAO extends CRUDDAO<Contacto> {

	public void borraContactosPorCliente(Long idcliente);
	public List<Contacto> getContactosListado(Filtro filtro);
	public void setDestacado(Contacto contacto);
}
