/**
 *
 */
package es.noletia.prensa.services.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import es.noletia.prensa.dao.ContactoDAO;
import es.noletia.prensa.modelo.Contacto;
import es.noletia.prensa.modelo.Filtro;
import es.noletia.prensa.services.ContactosService;

/**
 * @author Ramón
 *
 */
@Transactional
@Service
public class ContactosServiceImpl implements ContactosService {

    @Autowired
    private ContactoDAO contactoDAO;

    @Override
    public void alta(Contacto object) {
        contactoDAO.alta(object);
    }

    @Override
    public void borra(Contacto object) {
        contactoDAO.borra(object);
    }

    @Override
    public void borraPorId(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void actualiza(Contacto object) {
        contactoDAO.actualiza(object);
    }

    @Override
    public Contacto getElemento(Contacto object) {
        return contactoDAO.getElemento(object);
    }

    @Override
    public Contacto getElementoPorId(Long id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public List<Contacto> getListaElementos() {
        return contactoDAO.getListaElementos();
    }

    @Override
    public List<Contacto> getElementosFiltrados(Map<String, Object> parametros) {
        return contactoDAO.getElementosFiltrados(parametros);
    }

    @Override
    public List<Contacto> getElementosFiltrados(Contacto object) {
        return contactoDAO.getElementosFiltrados(object);
    }

    @Override
    public List<Contacto> getContactosListado(Filtro filtro) {
        return contactoDAO.getContactosListado(filtro);
    }

    @Override
    public void setDestacado(Contacto contacto) {
        contactoDAO.setDestacado(contacto);
    }

    @Override
    public void setFotografo(Contacto contacto) {
        contactoDAO.setFotografo(contacto);
    }

}
