/**
 * 
 */
package es.noletia.prensa.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.noletia.prensa.dao.ClienteCategoriaDAO;
import es.noletia.prensa.dao.MedioDAO;
import es.noletia.prensa.modelo.Medio;
import es.noletia.prensa.services.MediosService;

/**
 * @author Ramón
 *
 */
@Transactional
@Service
public class MediosServiceImpl implements MediosService {

	@Autowired
	private MedioDAO medioDao;
	@Autowired
	private ClienteCategoriaDAO clienteCategoriaDao;

	/* (non-Javadoc)
	 * @see es.noletia.prensa.services.MediosService#altaMedio(es.noletia.prensa.modelo.Medio)
	 */
	@Override
	public void alta(Medio medio) {
		medioDao.alta(medio);
	}

	@Override
	public void actualiza(Medio medio) {
		medioDao.actualiza(medio);
	}

	@Override
	public void borra(Medio object) {
		medioDao.borra(object);
	}

	@Override
	public void borraPorId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Medio getElemento(Medio object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Medio getElementoPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medio> getListaElementos() {
		return medioDao.getListaElementos();
	}

	@Override
	public List<Medio> getElementosFiltrados(Map<String, Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Medio> getElementosFiltrados(Medio object) {
		return medioDao.getElementosFiltrados(object);
	}

}
