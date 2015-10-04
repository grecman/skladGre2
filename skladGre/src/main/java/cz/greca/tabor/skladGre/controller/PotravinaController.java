package cz.greca.tabor.skladGre.controller;

import java.text.Normalizer;
import java.text.ParseException;
import java.util.Date;
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
import cz.greca.tabor.skladGre.entity.User;
import cz.greca.tabor.skladGre.obj.FormObject;
import cz.greca.tabor.skladGre.service.PotravinaService;
import cz.greca.tabor.skladGre.service.DenService;
import cz.greca.tabor.skladGre.service.UserService;

@Controller
@RequestMapping("/potravina")
public class PotravinaController {

	public static String removeDiacritics(String s) {
		return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

	@Autowired
	private DenService taborovyDenService;

	@Autowired
	private PotravinaService potravinaService;

	@Autowired
	private UserService userService;

	private static final Logger log = Logger.getLogger(PotravinaController.class);

	@RequestMapping(value = "/potraviny")
	public String seznamPotravin(Potravina potravina, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t seznamPotravin()");
		ses.setAttribute("pageTitle", "Seznam potravin");

		return "potraviny";
	}

	@RequestMapping(headers = "Content-Type=application/json", value = "/autocompleteNazevPotraviny")
	@ResponseBody
	public Iterable<String> autocompleteNazevPotraviny(@RequestParam String string) {
		log.debug("### autocompleteNazevPotraviny:" + string);
		return potravinaService.findPotravinaByString(string);
	}

	@RequestMapping(value = "/potravina/nova")
	public String novaPotravina(Potravina potravina, HttpServletRequest req, HttpSession session, Model model) throws ParseException {
		log.debug("### novaPotravina()");

		Potravina p = new Potravina();
		p.setJmeno(removeDiacritics("ANANAS"));
		potravinaService.save(p);

		return "redirect:/";
	}

}
