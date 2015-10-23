/**
 * 
 */
package es.noletia.prensa.services.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.noletia.prensa.dao.ContactoDAO;
import es.noletia.prensa.modelo.Contacto;
import es.noletia.prensa.modelo.Filtro;
import es.noletia.prensa.services.ListadosService;

/**
 * @author Ramón
 *
 */
@Service
@Transactional
public class ListadosServiceImpl implements ListadosService {
	
	@Autowired
	private ContactoDAO contactoDAO;

	/* (non-Javadoc)
	 * @see es.noletia.prensa.services.ListadosService#getContactosFiltro(es.noletia.prensa.modelo.Filtro)
	 */
	@Override
	public List<Contacto> getContactosFiltro(Filtro filtro) {
		return contactoDAO.getContactosListado(filtro);
	}

}
