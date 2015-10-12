/**
 * 
 */
package es.noletia.prensa.services;

import java.util.List;

import es.noletia.prensa.dao.CRUDDAO;
import es.noletia.prensa.modelo.Categoria;

/**
 * @author Ramón
 *
 */
public interface CategoriaService extends CRUDDAO<Categoria>{

	List<Categoria> getTipoSelect(int tipo);
}
