/**
 * 
 */
package es.noletia.prensa.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.noletia.prensa.dao.CategoriaDAO;
import es.noletia.prensa.modelo.Categoria;
import es.noletia.prensa.services.CategoriaService;

/**
 * @author Ramón
 *
 */
@Transactional
@Service
public class CategoriasServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;
	

	@Override
	public void borraPorId(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Categoria> getListaElementos() {
		return categoriaDAO.getListaElementos();
	}

	@Override
	public void alta(Categoria object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void borra(Categoria object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualiza(Categoria object) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria getElemento(Categoria object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> getElementosFiltrados(Categoria object) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Categoria getElementoPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> getElementosFiltrados(Map<String, Object> parametros) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Categoria> getTipoSelect(int tipo) {
		// TODO Auto-generated method stub
		return categoriaDAO.getTipoSelect(tipo);
	}

	

}
