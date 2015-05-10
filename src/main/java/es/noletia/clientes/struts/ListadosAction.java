/**
 * 
 * /
/*
package es.noletia.clientes.struts;

import org.apache.log4j.Logger;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import es.noletia.clientes.modelo.Categoria;
import es.noletia.clientes.modelo.Provincia;
import es.noletia.clientes.services.CategoriasService;
import es.noletia.clientes.services.ListadosService;
import es.noletia.clientes.services.ProvinciasService;

/**
 * @author ramon
 * 
 * /
@Component
@Scope("prototype")
public class ListadosAction extends ComunAction {
	/**
	 * Logger for this class
	 * /
	private static final Logger logger = Logger.getLogger(ListadosAction.class);

	private static final long serialVersionUID = -7649753952205797861L;

	@Autowired
	private ProvinciasService provinciasService;
	@Autowired
	private CategoriasService categoriasService;
	@Autowired
	private ListadosService listadoService;

	private List<Provincia> listaProvincias;
	private List<Categoria> listaCategorias;

	// campos del formulario
	private String empresa;
	private Long provincia;
	private String categoriasseleccionadas;

	private List<String> listaEmails;

	// para los mensajes
	private String mensaje;

	/**
	 * Método de entrada al apartado de listados de emails
	 * 
	 * @return Action.SUCCESS
	 * * /
	public String inicioListados() {
		return SUCCESS;
	}

	/**
	 * Método para realizar las búsquedas de emails
	 * 
	 * @return Action.SUCCESS
	 * * /
	public String buscarListados() {
		try {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("empresa", !"".equals(empresa) ? empresa : null);
			parametros.put("provincia", provincia);
			parametros.put("categorias",
					recuperaCategoriasSeleccionadas(categoriasseleccionadas));
			listaEmails = listadoService.buscaListadoEmails(parametros);
		} catch (Exception e) {
			logger.error("Error en el método buscarListados", e);
			setMensaje("Se ha producido un error en la aplicación. Consulte el log para más información");
		}
		return SUCCESS;
	}

	/**
	 * Método privado para crear una cadena con los id de las categorias
	 * seleccionadas
	 * 
	 * @return Object, String con la cadena de ids separados por comas
	 * * /
	private Object recuperaCategoriasSeleccionadas(String catsel) {
		String resultado = "";
		if (StringUtils.hasText(catsel)){
			String[] arr1 = catsel.split("#");
			for (String cat : arr1) {
				String[] arr2 = cat.split(":");
				if ("true".equals(arr2[1])) {
					resultado += "," + arr2[0].substring(arr2[0].indexOf('-')+1);
				}
			}
		}
		return !"".equals(resultado) ? resultado.substring(1) : null;
	}

	/**
	 * @return the provinciasService
	 * /
	public ProvinciasService getProvinciasService() {
		return provinciasService;
	}

	/**
	 * @param provinciasService
	 *            the provinciasService to set
	 * /
	public void setProvinciasService(ProvinciasService provinciasService) {
		this.provinciasService = provinciasService;
	}

	/**
	 * @return the listaProvincias
	 * /
	public List<Provincia> getListaProvincias() {
		return (listaProvincias != null) ? listaProvincias : provinciasService
				.getListaElementos();
	}

	/**
	 * @param listaProvincias
	 *            the listaProvincias to set
	 * /
	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	/**
	 * @return the listaCategorias
	 * /
	public List<Categoria> getListaCategorias() {
		return (listaCategorias != null) ? listaCategorias : categoriasService
				.getListaElementos();
	}

	/**
	 * @param listaCategorias
	 *            the listaCategorias to set
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
	 * @param categoriasService
	 *            the categoriasService to set
	 * /
	public void setCategoriasService(CategoriasService categoriasService) {
		this.categoriasService = categoriasService;
	}

	/**
	 * @return the empresa
	 * /
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *            the empresa to set
	 * /
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the provincia
	 * /
	public Long getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia
	 *            the provincia to set
	 * /
	public void setProvincia(Long provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the categoriasseleccionadas
	 * /
	public String getCategoriasseleccionadas() {
		return categoriasseleccionadas;
	}

	/**
	 * @param categoriasseleccionadas
	 *            the categoriasseleccionadas to set
	 * /
	public void setCategoriasseleccionadas(String categoriasseleccionadas) {
		this.categoriasseleccionadas = categoriasseleccionadas;
	}

	/**
	 * @return the listadoService
	 * /
	public ListadosService getListadoService() {
		return listadoService;
	}

	/**
	 * @param listadoService
	 *            the listadoService to set
	 * /
	public void setListadoService(ListadosService listadoService) {
		this.listadoService = listadoService;
	}

	/**
	 * @return the listaEmails
	 * /
	public List<String> getListaEmails() {
		return listaEmails;
	}

	/**
	 * @param listaEmails
	 *            the listaEmails to set
	 * /
	public void setListaEmails(List<String> listaEmails) {
		this.listaEmails = listaEmails;
	}

	/**
	 * @return the mensaje
	 * /
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 * /
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

}
*/