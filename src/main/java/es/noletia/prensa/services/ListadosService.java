/**
 * 
 */
package es.noletia.prensa.services;

import java.util.List;

import es.noletia.prensa.modelo.Contacto;
import es.noletia.prensa.modelo.Filtro;

/**
 * @author Ramón
 *
 */
public interface ListadosService {

	public List<Contacto> getContactosFiltro(Filtro filtro);
		
}
