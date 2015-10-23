/**
 * 
 */
package es.noletia.prensa.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.noletia.prensa.dao.AmbitoDAO;
import es.noletia.prensa.modelo.Ambito;
import es.noletia.prensa.services.AmbitosService;

/**
 * @author Ramón
 *
 */
@Transactional
@Service
public class AmbitosServiceImpl implements AmbitosService {

	@Autowired
	private AmbitoDAO ambitoDAO;
	
	@Override
	public void alta(Ambito object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borra(Ambito object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borraPorId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualiza(Ambito object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Ambito getElemento(Ambito object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Ambito getElementoPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ambito> getListaElementos() {
		return ambitoDAO.getListaElementos();
	}

	@Override
	public List<Ambito> getElementosFiltrados(Map<String, Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Ambito> getElementosFiltrados(Ambito object) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
