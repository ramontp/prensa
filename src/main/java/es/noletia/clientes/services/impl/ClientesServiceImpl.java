/**
 * 
 */
package es.noletia.clientes.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.noletia.clientes.dao.CategoriaDAO;
import es.noletia.clientes.dao.ClienteCategoriaDAO;
import es.noletia.clientes.dao.ClienteDAO;
import es.noletia.clientes.dao.ContactoDAO;
import es.noletia.clientes.modelo.Categoria;
import es.noletia.clientes.modelo.Cliente;
import es.noletia.clientes.modelo.ClienteCategoria;
import es.noletia.clientes.modelo.Contacto;
import es.noletia.clientes.services.ClientesService;

/**
 * @author ramon
 *
 */
@Service
@Transactional
public class ClientesServiceImpl implements ClientesService {

	@Autowired
	private ClienteDAO clienteDAO;
	@Autowired
	private ContactoDAO contactoDAO;
	@Autowired
	private CategoriaDAO categoriaDAO;
	@Autowired
	private ClienteCategoriaDAO clienteCategoriaDAO;
	
	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#alta(java.lang.Object)
	 */
	@Override
	public void alta(Cliente object) {
		clienteDAO.alta(object);
		
		// los contactos
		for (Contacto cont:object.getListacontactos()){
			// fijamos la referencia del cliente en los contactos
			cont.setCliente(object);
			// damos de alta los contactos
			contactoDAO.alta(cont);
		}
		
		// las categorias
		for (Categoria cat:object.getListacategorias()){
			ClienteCategoria cc = new ClienteCategoria();
			cc.setIdcategoria(cat.getIdcategoria());
			cc.setIdcliente(object.getIdcliente());
			clienteCategoriaDAO.alta(cc);
		}
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#borra(java.lang.Object)
	 */
	@Override
	public void borra(Cliente object) {
		clienteDAO.borra(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#borraPorId(java.lang.Long)
	 */
	@Override
	public void borraPorId(Long id) {
		clienteDAO.borraPorId(id);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#actualiza(java.lang.Object)
	 */
	@Override
	public void actualiza(Cliente object) {
		// actualizamos los datos del cliente
		clienteDAO.actualiza(object);
		
		// actualizamos los datos de los contacto
		for(Contacto con:object.getListacontactos()){
			con.setCliente(object);
			if (con.getIdcontacto() != null){
				// actualizamos contacto
				contactoDAO.actualiza(con);
			} else {
				contactoDAO.alta(con);
			}
		}

		// actualizamos los datos de las categorias
		clienteCategoriaDAO.borraPorCliente(object.getIdcliente());
		for(Categoria cat:object.getListacategorias()){
			ClienteCategoria cc = new ClienteCategoria();
			cc.setIdcategoria(cat.getIdcategoria());
			cc.setIdcliente(object.getIdcliente());
			clienteCategoriaDAO.alta(cc);
		}
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getElemento(java.lang.Object)
	 */
	@Override
	public Cliente getElemento(Cliente object) {
		return clienteDAO.getElemento(object);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getElementoPorId(java.lang.Long)
	 */
	@Override
	public Cliente getElementoPorId(Long id) {
		return clienteDAO.getElementoPorId(id);
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getListaElementos()
	 */
	@Override
	public List<Cliente> getListaElementos() {
		return clienteDAO.getListaElementos();
	}

	/* (non-Javadoc)
	 * @see es.noletia.clientes.services.CRUDService#getElementosFiltrados(java.util.Map)
	 */
	@Override
	public List<Cliente> getElementosFiltrados(Map<String, Object> parametros) {
		return clienteDAO.getElementosFiltrados(parametros);
	}

	@Override
	public void borraContacto(Long idcontacto) {
		contactoDAO.borraPorId(idcontacto);
	}

	/**
	 * @return the clienteDAO
	 */
	public ClienteDAO getClienteDAO() {
		return clienteDAO;
	}

	/**
	 * @param clienteDAO the clienteDAO to set
	 */
	public void setClienteDAO(ClienteDAO clienteDAO) {
		this.clienteDAO = clienteDAO;
	}

	/**
	 * @return the contactoDAO
	 */
	public ContactoDAO getContactoDAO() {
		return contactoDAO;
	}

	/**
	 * @param contactoDAO the contactoDAO to set
	 */
	public void setContactoDAO(ContactoDAO contactoDAO) {
		this.contactoDAO = contactoDAO;
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

	/**
	 * @return the clienteCategoriaDAO
	 */
	public ClienteCategoriaDAO getClienteCategoriaDAO() {
		return clienteCategoriaDAO;
	}

	/**
	 * @param clienteCategoriaDAO the clienteCategoriaDAO to set
	 */
	public void setClienteCategoriaDAO(ClienteCategoriaDAO clienteCategoriaDAO) {
		this.clienteCategoriaDAO = clienteCategoriaDAO;
	}

}
