package cz.greca.tabor.skladGre.controller;

import java.text.Normalizer;
import java.text.ParseException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.greca.tabor.skladGre.entity.Potravina;
import cz.greca.tabor.skladGre.obj.FormObject;
import cz.greca.tabor.skladGre.service.PotravinaService;

@Controller
@RequestMapping("/potravina")
public class PotravinaController {

	public static String removeDiacritics(String s) {
		return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

	@Autowired
	private PotravinaService potravinaService;

	private static final Logger log = Logger.getLogger(PotravinaController.class);

	@RequestMapping(value = "/seznam")
	public String seznamPotravin(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t seznamPotravin()");
		ses.setAttribute("pageTitle", "Seznam potravin");

		List<Potravina> p = potravinaService.findAll();
		model.addAttribute("listPotravina", p);

		return "potraviny";
	}

	@RequestMapping(headers = "Content-Type=application/json", value = "/autocompleteNazevPotraviny")
	@ResponseBody
	public Iterable<String> autocompleteNazevPotraviny(@RequestParam String string) {
		log.debug("### autocompleteNazevPotraviny:" + string);
		return potravinaService.findPotravinaByString(string);
	}

	@RequestMapping(value = "/nova")
	public String nova(FormObject formObject, HttpServletRequest req, HttpSession session, Model model) throws ParseException {
		log.debug("### nova("+formObject.getJmeno()+")");

		 Potravina p = new Potravina();
		 p.setJmeno(removeDiacritics(formObject.getJmeno().toUpperCase()));
		 potravinaService.save(p);

		return "redirect:/gre/potravina/seznam";
	}

	@RequestMapping(value = "/deleteAll")
	public String deleteAll(FormObject formObject, HttpServletRequest req, HttpSession session, Model model) throws ParseException {
		log.debug("### deleteAll()");
		
		potravinaService.deleteAll();
		
		return "redirect:/gre/potravina/seznam";
	}

	@RequestMapping(value = "/delete/{id}")
	public String delete(@PathVariable Long id, HttpServletRequest req, HttpSession session, Model model) throws ParseException {
		log.debug("### delete(" + id + ")");
		
		potravinaService.delete(potravinaService.findOne(id));
		
		return "redirect:/gre/potravina/seznam";
	}

	@RequestMapping(value = "/edit")
	public String edit(FormObject formObject, HttpServletRequest req, HttpSession session, Model model) throws ParseException {
		log.debug("### edit(" +formObject.getId()+", "+ formObject.getJmeno() + ")");
		
		Potravina p = potravinaService.findOne(formObject.getId());
		p.setJmeno(formObject.getJmeno().isEmpty() ? p.getJmeno() : removeDiacritics(formObject.getJmeno().toUpperCase()));
		potravinaService.save(p);
		
		return "redirect:/gre/potravina/seznam";
	}

}
