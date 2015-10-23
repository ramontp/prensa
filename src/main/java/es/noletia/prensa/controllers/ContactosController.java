/**
 * 
 */
package es.noletia.prensa.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import es.noletia.prensa.modelo.Contacto;
import es.noletia.prensa.services.ContactosService;

/**
 * @author Ramón
 *
 */
@Controller
public class ContactosController {

	@Autowired
	private ContactosService contactoService;
	
	@RequestMapping(value="/contactos", method= RequestMethod.GET)
	public ModelAndView inicio(){
		return new ModelAndView("contactos");
	}
	
	@RequestMapping(value = "/buscaContactos", method = RequestMethod.POST)
	public @ResponseBody List<Contacto> buscaContactos(@RequestBody Contacto contacto){
		return contactoService.getElementosFiltrados(contacto);
	}
	
	@RequestMapping(value="/contactos/addContacto", method=RequestMethod.POST)
	public @ResponseBody void addContacto(@RequestBody Contacto contacto){
		contactoService.alta(contacto);
	}

	@RequestMapping(value="/contactos/updateContacto", method=RequestMethod.POST)
	public @ResponseBody void updateContacto(@RequestBody Contacto contacto){
		contactoService.actualiza(contacto);
	}

	@RequestMapping(value="/contactos/borraContacto", method=RequestMethod.POST)
	public @ResponseBody void borraContacto(@RequestBody Contacto contacto){
		contactoService.borra(contacto);
	}

	@RequestMapping(value="/contactos/setDestacado", method=RequestMethod.POST)
	public @ResponseBody void setDestacado(@RequestBody Contacto contacto){
		contactoService.setDestacado(contacto);
	}
}
