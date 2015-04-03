/**
 * 
 */
package es.noletia.clientes.dao;

import java.util.List;
import java.util.Map;

/**
 * @author ramon
 *
 */
public interface ListadosDAO {

	public List<String> buscaListadosEmails(Map<String, Object> parametros);
}
