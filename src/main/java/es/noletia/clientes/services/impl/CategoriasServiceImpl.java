/**
 * 
 */
package es.noletia.clientes.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.noletia.clientes.dao.CategoriaDAO;
import es.noletia.clientes.modelo.Categoria;
import es.noletia.clientes.services.CategoriasService;

/**
 * @author ramon
 *
 */
@Service
public class CategoriasServiceImpl implements CategoriasService {

	@Autowired
	private CategoriaDAO categoriaDAO;
	
	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#alta(java.lang.Object)
	 */
	@Override
	public void alta(Categoria object) {
		categoriaDAO.alta(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#borra(java.lang.Object)
	 */
	@Override
	public void borra(Categoria object) {
		categoriaDAO.borra(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#borraPorId(java.lang.Long)
	 */
	@Override
	public void borraPorId(Long id) {
		categoriaDAO.borraPorId(id);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#actualiza(java.lang.Object)
	 */
	@Override
	public void actualiza(Categoria object) {
		categoriaDAO.actualiza(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getElemento(java.lang.Object)
	 */
	@Override
	public Categoria getElemento(Categoria object) {
		return categoriaDAO.getElemento(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getElementoPorId(java.lang.Long)
	 */
	@Override
	public Categoria getElementoPorId(Long id) {
		return categoriaDAO.getElementoPorId(id);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getListaElementos()
	 */
	@Override
	public List<Categoria> getListaElementos() {
		return categoriaDAO.getListaElementos();
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getElementosFiltrados(java.util.Map)
	 */
	@Override
	public List<Categoria> getElementosFiltrados(Map<String, Object> parametros) {
		return categoriaDAO.getElementosFiltrados(parametros);
	}

	/**
	 * @return the categoriaDAO
	 */
	public CategoriaDAO getCategoriaDAO() {
		return categoriaDAO;
	}

	/**
	 * @param categoriaDAO the categoriaDAO to set
	 */
	public void setCategoriaDAO(CategoriaDAO categoriaDAO) {
		this.categoriaDAO = categoriaDAO;
	}

}
