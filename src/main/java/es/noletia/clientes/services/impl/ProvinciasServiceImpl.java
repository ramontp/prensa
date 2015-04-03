/**
 * 
 */
package es.noletia.clientes.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.noletia.clientes.dao.ProvinciaDAO;
import es.noletia.clientes.modelo.Provincia;
import es.noletia.clientes.services.ProvinciasService;

/**
 * @author ramon
 *
 */
@Service
public class ProvinciasServiceImpl implements ProvinciasService {

	@Autowired
	private ProvinciaDAO provinciaDAO;
	
	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#alta(java.lang.Object)
	 */
	@Override
	public void alta(Provincia object) {
		provinciaDAO.alta(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#borra(java.lang.Object)
	 */
	@Override
	public void borra(Provincia object) {
		provinciaDAO.borra(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#borraPorId(java.lang.Long)
	 */
	@Override
	public void borraPorId(Long id) {
		provinciaDAO.borraPorId(id);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#actualiza(java.lang.Object)
	 */
	@Override
	public void actualiza(Provincia object) {
		provinciaDAO.actualiza(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getElemento(java.lang.Object)
	 */
	@Override
	public Provincia getElemento(Provincia object) {
		return provinciaDAO.getElemento(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getElementoPorId(java.lang.Long)
	 */
	@Override
	public Provincia getElementoPorId(Long id) {
		return provinciaDAO.getElementoPorId(id);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getListaElementos()
	 */
	@Override
	public List<Provincia> getListaElementos() {
		return provinciaDAO.getListaElementos();
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getElementosFiltrados(java.util.Map)
	 */
	@Override
	public List<Provincia> getElementosFiltrados(Map<String, Object> parametros) {
		return provinciaDAO.getElementosFiltrados(parametros);
	}

	/**
	 * @return the provinciaDAO
	 */
	public ProvinciaDAO getProvinciaDAO() {
		return provinciaDAO;
	}

	/**
	 * @param provinciaDAO the provinciaDAO to set
	 */
	public void setProvinciaDAO(ProvinciaDAO provinciaDAO) {
		this.provinciaDAO = provinciaDAO;
	}

}
