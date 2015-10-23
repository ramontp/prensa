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

import es.noletia.prensa.dao.CategoriaDAO;
import es.noletia.prensa.modelo.Ambito;
import es.noletia.prensa.modelo.Categoria;
import es.noletia.prensa.modelo.Medio;
import es.noletia.prensa.services.AmbitosService;
import es.noletia.prensa.services.MediosService;

/**
 * @author Ramón
 *
 */
@Controller
public class MediosController {

	@Autowired
	private CategoriaDAO categoriaDao;
	@Autowired
	private AmbitosService ambitoService;
	@Autowired
	private MediosService mediosService;
	
	@RequestMapping(value="/medios", method= RequestMethod.GET)
	public ModelAndView inicio(){
		return new ModelAndView("medios");
	}
	
	@RequestMapping(value="/medios/getMediosSelect", method = RequestMethod.GET)
	public @ResponseBody List<Medio> getMediosSelect(){
		return mediosService.getListaElementos(); //medioDao.getMediosSelect();
	}

	@RequestMapping(value="/medios/getTipos1Select", method = RequestMethod.GET)
	public @ResponseBody List<Categoria> getTipos1Select(){
		return categoriaDao.getTipoSelect(1);
	}

	@RequestMapping(value="/medios/getTipos2Select", method = RequestMethod.GET)
	public @ResponseBody List<Categoria> getTipos2Select(){
		return categoriaDao.getTipoSelect(2);
	}

	@RequestMapping(value="/medios/getAmbitos", method = RequestMethod.GET)
	public @ResponseBody List<Ambito> getAmbitosSelect(){
		return ambitoService.getListaElementos();
	}
	
	@RequestMapping(value="/medios/buscaMedios", method = RequestMethod.POST)
	public @ResponseBody List<Medio> findMedios(@RequestBody Medio medio){
		return mediosService.getElementosFiltrados(medio); //medioDao.getElementosFiltrados(medio);
	}
	
	@RequestMapping(value="/medios/addMedio", method=RequestMethod.POST)
	public @ResponseBody void addMedio(@RequestBody Medio medio){
		mediosService.alta(medio);
	}

	@RequestMapping(value="/medios/updateMedio", method=RequestMethod.POST)
	public @ResponseBody void updateMedio(@RequestBody Medio medio){
		mediosService.actualiza(medio);
	}

	@RequestMapping(value="/medios/borraMedio", method=RequestMethod.POST)
	public @ResponseBody void borraMedio(@RequestBody Medio medio){
		mediosService.borra(medio);
	}


}
