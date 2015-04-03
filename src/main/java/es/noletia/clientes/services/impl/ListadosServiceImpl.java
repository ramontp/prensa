/**
 * 
 */
package es.noletia.clientes.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.noletia.clientes.dao.ListadosDAO;
import es.noletia.clientes.services.ListadosService;

/**
 * @author ramon
 *
 */
@Service
public class ListadosServiceImpl implements ListadosService {
	
	@Autowired
	private ListadosDAO listadosDAO;

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.ListadosService#buscaListadoEmails(java.util.Map)
	 */
	@Override
	public List<String> buscaListadoEmails(Map<String, Object> parametros) {
		return listadosDAO.buscaListadosEmails(parametros);
	}

	/**
	 * @return the listadosDAO
	 */
	public ListadosDAO getListadosDAO() {
		return listadosDAO;
	}

	/**
	 * @param listadosDAO the listadosDAO to set
	 */
	public void setListadosDAO(ListadosDAO listadosDAO) {
		this.listadosDAO = listadosDAO;
	}

}
