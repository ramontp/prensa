/**
 * 
 */
package es.noletia.clientes.services;

import java.util.List;
import java.util.Map;

/**
 * @author ramon
 *
 */
public interface CRUDService<T> {

	/**
	 * Método genérico para dar de alta un objeto
	 * 
	 * @param object, objeto a persistir en la base de datos
	 * */
	public void alta(T object);
	
	/**
	 * Método genérico para borrar un objeto
	 * 
	 * @param object, objeto a eliminar de la base de datos
	 * */
	public void borra(T object);
	
	/**
	 * Método genérico para borrar un registro a partir de su identificación 
	 * 
	 * @param id, identificador del registro en base de datos
	 * */
	public void borraPorId(Long id);
	
	/**
	 * Método genérico para actualizar un objeto de la base de datos
	 * 
	 * @param object, objeto a actualizar
	 * */
	public void actualiza(T object);
	
	/**
	 * Método genérico para recuperar un objeto de la base de datos
	 * 
	 *  @param object, objeto a recuperar, sólo necesita el identificador
	 *  @return T, objeto con todos los datos
	 **/
	public T getElemento(T object);
	
	/**
	 * Método genérico para recuperar un objeto a partir de su identificador
	 * */
	public T getElementoPorId(Long id);
	
	/**
	 * Método genérico para recuperar la lista de objetos de una tabla
	 * 
	 * @return List<T>, lista de objetos
	 * */
	public List<T> getListaElementos();
	
	/**
	 * Método genérico para recuperar una lista de objetos de una tabla mediante un filtro
	 * 
	 * @return List<T>, lista de objetos
	 * */
	public List<T> getElementosFiltrados(Map<String, Object> parametros);

}
