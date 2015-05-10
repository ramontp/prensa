/**
 * 
 */
/*
package es.noletia.clientes.struts;

import org.apache.log4j.Logger;

import java.util.List;

import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import es.noletia.clientes.modelo.Categoria;
import es.noletia.clientes.services.CategoriasService;

/**
 * @author ramon
 *
 * /
@Component
@Scope("prototype")
@Validations
public class CategoriasAction extends ComunAction {
	/**
	 * Logger for this class
	 * /
	private static final Logger logger = Logger
		.getLogger(CategoriasAction.class);

	private static final long serialVersionUID = 1L;
	@Autowired
	private CategoriasService categoriasService;

	private Long idcategoria;
	private String nombrecategoria;
	private List<Categoria> listaCategorias;
	
	private String mensaje;
	
	/**
	 * Método de entrada para mostrar el inicio y las categorias a editar
	 * 
	 * @return Action.SUCCESS
	 * * /
	@SkipValidation
	public String listadoCategorias(){
		if (session.get("categoria")!=null){
			Categoria cat = (Categoria) session.get("categoria");
			idcategoria = cat.getIdcategoria();
			nombrecategoria = cat.getNombrecategoria();
			
			// borramos el elemento de la sesión
			session.remove("categoria");
		}
		
		if (session.get("mensaje") != null){
			mensaje = (String)session.get("mensaje");
			session.remove("mensaje");
		}
		
		listaCategorias = categoriasService.getListaElementos();
		
		return SUCCESS;
	}
	
	/**
	 * Método para dar de alta una categoria
	 * 
	 * @return Action.SUCCESS
	 * * /
	public String altaCategoria(){
		try{
			Categoria cat = new Categoria();
			cat.setNombrecategoria(nombrecategoria);
			
			categoriasService.alta(cat);
			mensaje = "La categoria se ha dado de alta correctamente";
		} catch (Exception e) {
			logger.error("Error en altaCategoria", e);
			mensaje = "Se ha producido un error en la aplicación. Consúlte el log para más información.";
		}
		session.put("mensaje", mensaje);
		
		return SUCCESS;
	}
	
	/**
	 * Método para borrar una categoria
	 * 
	 * @return Action.SUCCESS
	 * * /
	@SkipValidation
	public String borraCategoria(){
		try{
			categoriasService.borraPorId(idcategoria);
			mensaje = "Se ha borrado correctamente la categoria";
		} catch (Exception e){
			logger.error("Error en borraCategoria", e);
			mensaje = "Se ha producido un error en la aplicación. Consúlte el log para más información.";
		}
		session.put("mensaje", mensaje);
		
		return SUCCESS;
	}
	
	/**
	 * Método para mostrar los datos de la categoria para su edición
	 * 
	 * @return Action.SUCCESS
	 * * /
	@SkipValidation
	public String editaCategoria(){
		try{
			session.put("categoria", categoriasService.getElementoPorId(idcategoria));
		} catch (Exception e){
			logger.error("Error en borraCategoria", e);
			mensaje = "Se ha producido un error en la aplicación. Consúlte el log para más información.";
			session.put("mensaje", mensaje);
		}
		
		return SUCCESS;
	}
	
	/**
	 * Método que guarda la actualización de los datos de una categoria
	 * 
	 * @return Action.SUCCESS
	 * * /
	public String actualizaCategoria(){
		try{
			Categoria cat = new Categoria();
			cat.setIdcategoria(idcategoria);
			cat.setNombrecategoria(nombrecategoria);
			
			categoriasService.actualiza(cat);
			mensaje = "Se ha actualizado la categoria correctamente";
		} catch(Exception e){
			logger.error("Error en borraCategoria", e);
			mensaje = "Se ha producido un error en la aplicación. Consúlte el log para más información.";
		}
		session.put("mensaje", mensaje);
		
		return SUCCESS;
	}

	/**
	 * @return the idcategoria
	 * /
	public Long getIdcategoria() {
		return idcategoria;
	}

	/**
	 * @param idcategoria the idcategoria to set
	 * /
	public void setIdcategoria(Long idcategoria) {
		this.idcategoria = idcategoria;
	}

	/**
	 * @return the nombrecategoria
	 * /
	public String getNombrecategoria() {
		return nombrecategoria;
	}

	/**
	 * @param nombrecategoria the nombrecategoria to set
	 * /
	@RequiredStringValidator
	public void setNombrecategoria(String nombrecategoria) {
		this.nombrecategoria = nombrecategoria;
	}

	/**
	 * @return the listaCategorias
	 * /
	public List<Categoria> getListaCategorias() {
		return (listaCategorias!=null)?listaCategorias:categoriasService.getListaElementos();
	}

	/**
	 * @param listaCategorias the listaCategorias to set
	 * /
	public void setListaCategorias(List<Categoria> listaCategorias) {
		this.listaCategorias = listaCategorias;
	}

	/**
	 * @return the categoriasService
	 * /
	public CategoriasService getCategoriasService() {
		return categoriasService;
	}

	/**
	 * @param categoriasService the categoriasService to set
	 * /
	public void setCategoriasService(CategoriasService categoriasService) {
		this.categoriasService = categoriasService;
	}

	/**
	 * @return the mensaje
	 * /
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje the mensaje to set
	 * /
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}
}
*/