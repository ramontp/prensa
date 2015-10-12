/**
 * 
 */
package es.noletia.prensa.dao;

import java.util.List;

import es.noletia.prensa.modelo.Categoria;

/**
 * @author ramon
 *
 */
public interface CategoriaDAO extends CRUDDAO<Categoria> {

	public List<Categoria> getTipoSelect(int tipo);
	
}
