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
import cz.greca.tabor.skladGre.service.TaborovyDenService;
import cz.greca.tabor.skladGre.service.UserService;

@Controller
@RequestMapping()
public class IndexController {

	public static String removeDiacritics(String s) {
		return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

	@Autowired
	private TaborovyDenService taborovyDenService;

	@Autowired
	private PotravinaService potravinaService;

	@Autowired
	private UserService userService;

	private static final Logger log = Logger.getLogger(IndexController.class);

	@RequestMapping(value = "/")
	public String loginPage(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t Logovaci obrazovka ... ");
		ses.setAttribute("pageTitle", "Logovací obrazovka");
		ses.setAttribute("userLogin", "");
		ses.setAttribute("userRole", "");
		
		List<User> u = userService.findAll();
		model.addAttribute("listUser", u);
		
		return "index";
	}
	
	@RequestMapping(value = "/enterLogin")
	public String enterPwd(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t enterPwd(" + formObject.getNick().toUpperCase()+", "+formObject.getPassword()+")");
		User u = userService.findbyNick(formObject.getNick().toUpperCase());
		if (u!=null && u.getPassword().startsWith(formObject.getPassword()) && u.getPassword().length()==formObject.getPassword().length()) {
			ses.setAttribute("userLogin", u.getNick());
			ses.setAttribute("userRole", u.getRole());
			ses.setAttribute("errorMessage", "");
			u.setPocetPrihlaseni(u.getPocetPrihlaseni()+1);
			u.setPosledniPrihlaseni(new Date());
			userService.save(u);
			return "redirect:/td";
		} else {
			ses.setAttribute("errorMessage", "Nesprávné heslo!");
			return "redirect:/";
		}
	}
		
	@RequestMapping(value = "/td")
	public String taborovyDen(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t taborovyDen()");
		ses.setAttribute("pageTitle", "Seznam táborových dnů");

		return "taboroveDny";
	}

	@RequestMapping(value = "/potraviny")
	public String seznamPotravin(Potravina potravina, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t potraviny: " + potravina.getJmeno());

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
