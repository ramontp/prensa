/**
 * 
 */
package es.noletia.clientes.struts;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.validation.SkipValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.opensymphony.xwork2.validator.annotations.RequiredStringValidator;
import com.opensymphony.xwork2.validator.annotations.StringLengthFieldValidator;
import com.opensymphony.xwork2.validator.annotations.Validations;

import es.noletia.clientes.modelo.Categoria;
import es.noletia.clientes.modelo.Cliente;
import es.noletia.clientes.modelo.Contacto;
import es.noletia.clientes.modelo.Provincia;
import es.noletia.clientes.services.CategoriasService;
import es.noletia.clientes.services.ClientesService;
import es.noletia.clientes.services.ProvinciasService;

/**
 * @author ramon
 * 
 */
@Component
@Scope("prototype")
@Validations
public class ClientesAction extends ComunAction {
	/**
	 * Logger for this class
	 */
	private static final Logger logger = Logger.getLogger(ClientesAction.class);

	private static final long serialVersionUID = 1L;

	@Autowired
	private ClientesService clientesService;
	@Autowired
	private ProvinciasService provinciasService;
	@Autowired
	private CategoriasService categoriasService;

	private List<Cliente> listaClientes;
	private List<Provincia> listaProvincias;

	private Long idcliente;
	private String empresa;
	private String datosfiscales;
	private Long provincia;
	private Date fechault;
	private String contactado;
	private String observaciones;
	private String contactos;
	private List<Contacto> listacontactos;
	private List<Categoria> listacategorias;
	private Long idcontacto;
	private String categoriasseleccionadas;

	// campos del buscador
	private String empresab;
	private String contactob;
	private String emailb;
	private Boolean muestraBuscador;

	// para mostrar los mensajes
	private String mensaje;
	
	

	@Override
	public void prepare() throws Exception {
		// TODO Auto-generated method stub
		super.prepare();
		//listacategorias = categoriasService.getListaElementos();
		//listaProvincias = provinciasService.getListaElementos();
	}

	/**
	 * Método de entrada que muestra los clientes a editar y los listados
	 * resultantes de realizar una búsqueda
	 * 
	 * @return Action.SUCCESS
	 * */
	@SuppressWarnings("unchecked")
	@SkipValidation
	public String listadoCliente() {
		try {
			listacategorias = categoriasService.getListaElementos();
			// comprobamos si estamos editando un cliente
			if (session.get("cliente") != null) {
				Cliente cli = (Cliente) session.get("cliente");
				idcliente = cli.getIdcliente();
				empresa = cli.getEmpresa();
				datosfiscales = cli.getDatosfiscales();
				if (cli.getProvincia() != null) {
					provincia = cli.getProvincia().getIdprovincia();
				}
				fechault = cli.getFechault();
				contactado = cli.getContactado();
				observaciones = cli.getObservaciones();
				listacontactos = cli.getListacontactos();
				List<Categoria> listacategoriasseleccionadas = cli
						.getListacategorias();
				estableceCategoriasSeleccionadas(listacategoriasseleccionadas);
				// borramos el dato de la sesión
				session.remove("cliente");
			}

			// si hemos realizado una búsqueda
			if (session.get("listaClientes") != null) {
				listaClientes = (List<Cliente>) session.get("listaClientes");
			} else {
				listaClientes = clientesService.getListaElementos();
			}
			muestraBuscador = (Boolean) session.get("muestraBuscador");
			listaProvincias = provinciasService.getListaElementos();
			if (session.get("mensaje") != null) {
				mensaje = (String) session.get("mensaje");
				session.remove("mensaje");
			}
		} catch (Exception e) {
			logger.error("Error en listadoCliente.", e);
			mensaje = "Se ha producido un error en la aplicación. Consúlte el log para más información.";
		} finally {
			// borramos el valor de pagina en sesion
			session.remove("pagina");
		}

		return SUCCESS;
	}

	/**
	 * Método privado que marca aquellas categorias que estuvieran seleccionadas
	 * 
	 * @param List
	 *            <Categoria> listacategoriasseleccionadas
	 * */
	private void estableceCategoriasSeleccionadas(
			List<Categoria> listacategoriasseleccionadas) {

		for (Categoria cat : listacategoriasseleccionadas) {
			if (listacategorias.indexOf(cat) > -1) {
				(listacategorias.get(listacategorias.indexOf(cat)))
						.setSeleccionado(true);
			}
		}

	}

	/**
	 * Método que permite dar de alta un cliente
	 * 
	 * @return Action.SUCCESS
	 * */
	public String altaCliente() {
		try {
			Cliente cliente = new Cliente();
			cliente.setEmpresa(empresa);
			cliente.setDatosfiscales(datosfiscales);
			cliente.setProvincia(provinciasService.getElementoPorId(provincia));
			cliente.setFechault(fechault);
			cliente.setContactado(contactado);
			cliente.setObservaciones(observaciones);
			cliente.setListacontactos(obtieneListaContactos(contactos));
			cliente.setListacategorias(obtieneListaCategorias(categoriasseleccionadas));

			clientesService.alta(cliente);

			// mostramos de nuevo el alta
			session.remove("muestraBuscador");
			// mostramos mensaje
			mensaje = "El cliente '" + empresa
					+ "' se ha dado de alta correctamente";
		} catch (Exception e) {
			logger.error("Error en altaCliente.", e);
			mensaje = "Se ha producido un error en la aplicación. Consúlte el log para más información.";
		}
		session.put("mensaje", mensaje);

		return SUCCESS;
	}

	/**
	 * Método privado que recupera la lista de categorias seleccionadas
	 * 
	 * @param catsel
	 *            , cadena con la lista de categorias seleccionadas
	 * @return List<Categoria>, lista de categorias seleccionadas
	 * */
	private List<Categoria> obtieneListaCategorias(String catsel) {
		List<Categoria> listacategorias = new ArrayList<Categoria>();
		String[] arr1 = catsel.split("#");
		for (String cat : arr1) {
			String[] arr2 = cat.split(":");
			if ("true".equals(arr2[1])) {
				Categoria categoria = categoriasService.getElementoPorId(Long
						.valueOf(arr2[0].substring(arr2[0].indexOf('-')+1)));
				listacategorias.add(categoria);
			}
		}
		return listacategorias;
	}

	/**
	 * Método privado que obtiene la lista de contactos a partir de un cadena
	 * con los datos encadenados
	 * 
	 * @param contactos2
	 *            , cadena con los datos de los contactos encadenados
	 * @return List<Contacto>, lista de contactos
	 * */
	private List<Contacto> obtieneListaContactos(String contactos2) {
		List<Contacto> listaContactos = new ArrayList<Contacto>();
		if (!contactos2.equals("")) {
			String[] array1 = contactos2.split(",");
			for (int i = 0; i < array1.length; i++) {
				// procesamos los contactos
				String cont = eliminacorchetes(array1[i]);
				Contacto contaux = new Contacto();
				String[] array2 = cont.split("\\|");
				// fijamos los datos si hay al menos un valor
				if (!array2[0].equals("-") || !array2[1].equals("-")
						|| !array2[2].equals("-") || !array2[3].equals("-")) {
					contaux.setContacto((!array2[0].equals("-")) ? array2[0]
							: null);
					contaux.setDepartamento((!array2[1].equals("-")) ? array2[1]
							: null);
					contaux.setEmail((!array2[2].equals("-")) ? array2[2]
							: null);
					contaux.setTelefono((!array2[3].equals("-")) ? array2[3]
							: null);
					contaux.setIdcontacto((!array2[4].equals("-")) ? Long
							.valueOf(array2[4]) : null);

					listaContactos.add(contaux);
				}
			}
		}

		return listaContactos;
	}

	/**
	 * Método privado que elimina los corchetes del principio y del final de una
	 * cadena
	 * 
	 * @param string
	 *            , cadena con los corchetes
	 * @return String, cadena sin los corchetes
	 * */
	private String eliminacorchetes(String string) {
		return string.substring(1, string.length() - 1);
	}

	/**
	 * Método para borrar un cliente
	 * 
	 * @return Action.SUCCESS
	 * */
	@SkipValidation
	public String borraCliente() {
		try {
			clientesService.borraPorId(idcliente);
			// mostramos mensaje
			mensaje = "El cliente ha sido eliminado de la base de datos";
		} catch (Exception e) {
			logger.error("Error en borraCliente", e);
			mensaje = "Se ha producido un error en la aplicación. Consúlte el log para más información.";
		}
		session.put("mensaje", mensaje);

		return SUCCESS;
	}

	/**
	 * Método para mostrar los datos de un cliente para su edición
	 * 
	 * @return Action.SUCCESS
	 * */
	@SkipValidation
	public String editaCliente() {
		try {
			Cliente cli = clientesService.getElementoPorId(idcliente);
			session.put("cliente", cli);

			// evitamos que se muestre el buscador
			session.remove("muestraBuscador");
		} catch (Exception e) {
			logger.error("Error en editaCliente", e);
			mensaje = "Se ha producido un error en la aplicación. Consúlte el log para más información.";
			session.put("mensaje", mensaje);
		}

		return SUCCESS;
	}

	/**
	 * Método para actualizar los datos de un cliente
	 * 
	 * @return Action.SUCCESS
	 * */
	public String actualizaCliente() {
		try {
			Cliente cliente = new Cliente();
			cliente.setIdcliente(idcliente);
			cliente.setEmpresa(empresa);
			cliente.setDatosfiscales(datosfiscales);
			cliente.setProvincia(provinciasService.getElementoPorId(provincia));
			cliente.setFechault(fechault);
			cliente.setContactado(contactado);
			cliente.setObservaciones(observaciones);
			cliente.setListacontactos(obtieneListaContactos(contactos));
			cliente.setListacategorias(obtieneListaCategorias(categoriasseleccionadas));

			clientesService.actualiza(cliente);
			// mostramos mensaje
			mensaje = "El cliente '" + empresa
					+ "' se ha actualizado correctamente";
		} catch (Exception e) {
			logger.error("Error en actualizaCliente.", e);
			mensaje = "Se ha producido un error en la aplicación. Consúlte el log para más información.";
		}
		session.put("mensaje", mensaje);

		return SUCCESS;
	}

	/**
	 * Método para borrar un cliente
	 * 
	 * @return Action.SUCCESS
	 * */
	@SkipValidation
	public String borraContacto() {
		PrintWriter writer = null;
		try {
			clientesService.borraContacto(idcontacto);
			writer = ServletActionContext.getResponse().getWriter();
			writer.print("ok");
			writer.flush();
			writer.close();
		} catch (IOException ex) {
			logger.error("Error en borraContacto.", ex);
		} catch (Exception e) {
			logger.error("Error en borraContacto.", e);
		}

		return NONE;
	}

	/**
	 * Método para buscar un cliente
	 * 
	 * @return Action.SUCCESS
	 * */
	@SkipValidation
	public String buscaCliente() {
		try {
			Map<String, Object> parametros = new HashMap<String, Object>();
			parametros.put("empresa", empresab);
			parametros.put("contacto", contactob);
			parametros.put("email", emailb);
			parametros.put("categorias", obtieneListaCategorias(categoriasseleccionadas));

			listaClientes = clientesService.getElementosFiltrados(parametros);
			session.put("listaClientes", listaClientes);
			session.put("muestraBuscador", true);
		} catch (Exception e) {
			logger.error("Error en buscaCliente.", e);
			mensaje = "Se ha producido un error en la aplicación. Consúlte el log para más información.";
			session.put("mensaje", mensaje);
		}

		return SUCCESS;
	}
	
	@SkipValidation
	public String paginaCliente(){
		session.put("pagina", true);
		return SUCCESS;
	}

	/**
	 * @return the listaProvincias
	 */
	public List<Provincia> getListaProvincias() {
		return (listaProvincias != null) ? listaProvincias : provinciasService
				.getListaElementos();
	}

	/**
	 * @param listaProvincias
	 *            the listaProvincias to set
	 */
	public void setListaProvincias(List<Provincia> listaProvincias) {
		this.listaProvincias = listaProvincias;
	}

	/**
	 * @return the empresa
	 */
	public String getEmpresa() {
		return empresa;
	}

	/**
	 * @param empresa
	 *            the empresa to set
	 */
	@RequiredStringValidator(message = "El campo 'Medio' no puede estar vacío")
	public void setEmpresa(String empresa) {
		this.empresa = empresa;
	}

	/**
	 * @return the datosfiscales
	 */
	public String getDatosfiscales() {
		return datosfiscales;
	}

	/**
	 * @param datosfiscales
	 *            the datosfiscales to set
	 */
	@StringLengthFieldValidator(message = "El campo datos fiscales no puede exceder de 1000 caracteres.", maxLength = "1000")
	public void setDatosfiscales(String datosfiscales) {
		this.datosfiscales = datosfiscales;
	}

	/**
	 * @return the provincia
	 */
	public Long getProvincia() {
		return provincia;
	}

	/**
	 * @param provincia
	 *            the provincia to set
	 */
	public void setProvincia(Long provincia) {
		this.provincia = provincia;
	}

	/**
	 * @return the fechault
	 */
	public Date getFechault() {
		return fechault;
	}

	/**
	 * @param fechault
	 *            the fechault to set
	 */
	public void setFechault(Date fechault) {
		this.fechault = fechault;
	}

	/**
	 * @return the contactado
	 */
	public String getContactado() {
		return contactado;
	}

	/**
	 * @param contactado
	 *            the contactado to set
	 */
	public void setContactado(String contactado) {
		this.contactado = contactado;
	}

	/**
	 * @return the observaciones
	 */
	public String getObservaciones() {
		return observaciones;
	}

	/**
	 * @param observaciones
	 *            the observaciones to set
	 */
	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	/**
	 * @return the clientesService
	 */
	public ClientesService getClientesService() {
		return clientesService;
	}

	/**
	 * @param clientesService
	 *            the clientesService to set
	 */
	public void setClientesService(ClientesService clientesService) {
		this.clientesService = clientesService;
	}

	/**
	 * @return the listaClientes
	 */
	public List<Cliente> getListaClientes() {
		return (listaClientes != null) ? listaClientes : clientesService
				.getListaElementos();
	}

	/**
	 * @param listaClientes
	 *            the listaClientes to set
	 */
	public void setListaClientes(List<Cliente> listaClientes) {
		this.listaClientes = listaClientes;
	}

	/**
	 * @return the provinciasService
	 */
	public ProvinciasService getProvinciasService() {
		return provinciasService;
	}

	/**
	 * @param provinciasService
	 *            the provinciasService to set
	 */
	public void setProvinciasService(ProvinciasService provinciasService) {
		this.provinciasService = provinciasService;
	}

	/**
	 * @return the contactos
	 */
	public String getContactos() {
		return contactos;
	}

	/**
	 * @param contactos
	 *            the contactos to set
	 */
	public void setContactos(String contactos) {
		this.contactos = contactos;
	}

	/**
	 * @return the idcliente
	 */
	public Long getIdcliente() {
		return idcliente;
	}

	/**
	 * @param idcliente
	 *            the idcliente to set
	 */
	public void setIdcliente(Long idcliente) {
		this.idcliente = idcliente;
	}

	/**
	 * @return the listacontactos
	 */
	public List<Contacto> getListacontactos() {
		return listacontactos;
	}

	/**
	 * @param listacontactos
	 *            the listacontactos to set
	 */
	public void setListacontactos(List<Contacto> listacontactos) {
		this.listacontactos = listacontactos;
	}

	/**
	 * @return the idcontacto
	 */
	public Long getIdcontacto() {
		return idcontacto;
	}

	/**
	 * @param idcontacto
	 *            the idcontacto to set
	 */
	public void setIdcontacto(Long idcontacto) {
		this.idcontacto = idcontacto;
	}

	/**
	 * @return the empresab
	 */
	public String getEmpresab() {
		return empresab;
	}

	/**
	 * @param empresab
	 *            the empresab to set
	 */
	public void setEmpresab(String empresab) {
		this.empresab = empresab;
	}

	/**
	 * @return the contactob
	 */
	public String getContactob() {
		return contactob;
	}

	/**
	 * @param contactob
	 *            the contactob to set
	 */
	public void setContactob(String contactob) {
		this.contactob = contactob;
	}

	/**
	 * @return the muestraBuscador
	 */
	public Boolean getMuestraBuscador() {
		return muestraBuscador;
	}

	/**
	 * @param muestraBuscador
	 *            the muestraBuscador to set
	 */
	public void setMuestraBuscador(Boolean muestraBuscador) {
		this.muestraBuscador = muestraBuscador;
	}

	/**
	 * @return the mensaje
	 */
	public String getMensaje() {
		return mensaje;
	}

	/**
	 * @param mensaje
	 *            the mensaje to set
	 */
	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	/**
	 * @return the listacategorias
	 */
	public List<Categoria> getListacategorias() {
		return (listacategorias != null) ? listacategorias : categoriasService
				.getListaElementos();
	}

	/**
	 * @param listacategorias
	 *            the listacategorias to set
	 */
	public void setListacategorias(List<Categoria> listacategorias) {
		this.listacategorias = listacategorias;
	}

	/**
	 * @return the categoriasService
	 */
	public CategoriasService getCategoriasService() {
		return categoriasService;
	}

	/**
	 * @param categoriasService
	 *            the categoriasService to set
	 */
	public void setCategoriasService(CategoriasService categoriasService) {
		this.categoriasService = categoriasService;
	}

	/**
	 * @return the categoriasseleccionadas
	 */
	public String getCategoriasseleccionadas() {
		return categoriasseleccionadas;
	}

	/**
	 * @param categoriasseleccionadas
	 *            the categoriasseleccionadas to set
	 */
	public void setCategoriasseleccionadas(String categoriasseleccionadas) {
		this.categoriasseleccionadas = categoriasseleccionadas;
	}

	public String getEmailb() {
		return emailb;
	}

	public void setEmailb(String emailb) {
		this.emailb = emailb;
	}

}
