/**
 * 
 */
package es.noletia.prensa.services;

import java.util.List;

import es.noletia.prensa.dao.CRUDDAO;
import es.noletia.prensa.modelo.Contacto;
import es.noletia.prensa.modelo.Filtro;

/**
 * @author Ramón
 *
 */
public interface ContactosService extends CRUDDAO<Contacto>{

	public List<Contacto> getContactosListado(Filtro filtro);
	public void setDestacado(Contacto contacto);
	public void setFotografo(Contacto contacto);
}
