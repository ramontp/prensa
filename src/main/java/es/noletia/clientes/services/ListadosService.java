/**
 * 
 */
package es.noletia.clientes.services;

import java.util.List;
import java.util.Map;

/**
 * @author ramon
 *
 * Esta clase no hereda de CRUDService. Sólo va a disponer de un método
 */
public interface ListadosService {

	/**
	 * Método para realizar las búsquedas de emails
	 * 
	 * @param parametros, mapa con los valores para realizar el filtrado
	 * */
	public List<String> buscaListadoEmails(Map<String, Object> parametros);
	
}
