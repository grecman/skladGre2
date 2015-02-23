package cz.greca.tabor.skladGre.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.greca.tabor.skladGre.entity.Potravina;
import cz.greca.tabor.skladGre.entity.TaborovyDen;
import cz.greca.tabor.skladGre.service.PotravinaService;
import cz.greca.tabor.skladGre.service.TaborovyDenService;

@Controller
@RequestMapping()
public class IndexController {

	@Autowired
	private TaborovyDenService taborovyDenService;

	@Autowired
	private PotravinaService potravinaService;

	private static final Logger log = Logger.getLogger(IndexController.class);

	@RequestMapping(value = "/")
	public String uvodniStranka(HttpServletRequest req, HttpSession session, Model model) {
		log.debug("\t### uvodniStranka ... ");

		List<TaborovyDen> td = taborovyDenService.findAll();
		model.addAttribute("listTd", td);
		
		List<Potravina> p = potravinaService.findAll();
		model.addAttribute("listPot", p);
		
		return "index";
	}

	@RequestMapping(value = "/potraviny")
	public String seznamPotravin(Potravina potravina, HttpServletRequest req, HttpSession session, Model model) {
		log.debug("\t### potraviny: "+potravina.getJmeno());
		return "potraviny";
	}
	
	@RequestMapping(headers = "Content-Type=application/json", value = "/autocompleteNazevPotraviny")
	@ResponseBody
	public Iterable<String> autocompleteNazevPotraviny(@RequestParam String string) {
		log.debug("\t### autocompleteNazevPotraviny:"+string);
		return potravinaService.findPotravinaByString(string);
	}
}
