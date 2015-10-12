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
import es.noletia.prensa.modelo.Filtro;
import es.noletia.prensa.services.ListadosService;

/**
 * @author Ramón
 *
 */
@Controller
public class ListadosController {
	
	@Autowired
	private ListadosService listadoService;

	@RequestMapping(value="/listados", method= RequestMethod.GET)
	public ModelAndView inicio(){
		return new ModelAndView("listados");
	}
	
	@RequestMapping(value="/listados/filtraContactos", method=RequestMethod.POST)
	public @ResponseBody List<Contacto> filtraContactos(@RequestBody Filtro filtro){
		return listadoService.getContactosFiltro(filtro);
	}
}
