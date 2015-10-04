package cz.greca.tabor.skladGre.controller;

import java.text.ParseException;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.greca.tabor.skladGre.entity.User;
import cz.greca.tabor.skladGre.obj.FormObject;
import cz.greca.tabor.skladGre.service.UserService;

@Controller
@RequestMapping("/login")
public class UserController {

	@Autowired
	private UserService userService;

	private static final Logger log = Logger.getLogger(UserController.class);

	@RequestMapping(value = "/1")
	public String loginPage(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t loginPage()");
		ses.setAttribute("pageTitle", "Logovací obrazovka");
		ses.setAttribute("userLogin", "");
		ses.setAttribute("userRole", "");
		
		ses.setAttribute("userLogin", "GRECA");
		ses.setAttribute("userRole", "ADMIN");
		return "redirect:/gre/td/seznam";

//		List<User> u = userService.findAllByOrderByNickAsc();
//		model.addAttribute("listUser", u);
//		return "login";
	}

	@RequestMapping(value = "/logged")
	public String loggedUser(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t loggedUser(" + ses.getAttribute("userLogin") + " - " + ses.getAttribute("userRole") + ")");
		ses.setAttribute("pageTitle", "Logovací obrazovka (uživatel přihlášen)");

		if (ses.getAttribute("userLogin") == null) {
			ses.setAttribute("errorMessage", "Uživatel není přihlášen.");
			return "redirect:/gre/login/1";
		} else {
			// ses.setAttribute("errorMessage", "");
			List<User> u = userService.findAllByOrderByNickAsc();
			model.addAttribute("listUser", u);
			return "login";
		}
	}

	@RequestMapping(value = "/newUser")
	public String newUser(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t newUser(" + formObject.getNick().toUpperCase() + ", " + formObject.getRole() + ", " + formObject.getPassword() + ")");

		List<User> allU = userService.findAll();
		User u = userService.findbyNick(formObject.getNick().toUpperCase());

		if (formObject.getRole().isEmpty() || formObject.getPassword().isEmpty()) {
			ses.setAttribute("errorMessage", "Heslo nebo role nebyla vyplněna!");
			return "redirect:/gre/errorPage";
		}

		if (u == null) {
			User newUser = new User();
			newUser.setNick(formObject.getNick().toUpperCase());
			if (allU == null || allU.isEmpty()) {
			// prvni uzivatel musi byt vzdy admin!
			newUser.setRole("ADMIN");
			} else if (formObject.getRole() == null || formObject.getRole().isEmpty()) {
			newUser.setRole(formObject.getRole().toUpperCase());
			} else {
			newUser.setRole(formObject.getRole().toUpperCase());
			}
			newUser.setPassword(formObject.getPassword());
			newUser.setPocetPrihlaseni(1);
			newUser.setPosledniPrihlaseni(new Date());
			userService.save(newUser);
			ses.setAttribute("errorMessage", "");
		} else {
			ses.setAttribute("errorMessage", "Uživatel již existuje!");
		}
		return "redirect:/gre/login/logged";
	}

	@RequestMapping(value = "/enterLogin")
	public String enterPwd(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t enterPwd(" + formObject.getNick().toUpperCase() + ", " + formObject.getPassword() + ")");
		User u = userService.findbyNick(formObject.getNick().toUpperCase());
		if (u != null && u.getPassword().startsWith(formObject.getPassword()) && u.getPassword().length() == formObject.getPassword().length()) {
			ses.setAttribute("userLogin", u.getNick());
			ses.setAttribute("userRole", u.getRole());
			ses.setAttribute("errorMessage", "");
			u.setPocetPrihlaseni(u.getPocetPrihlaseni() + 1);
			u.setPosledniPrihlaseni(new Date());
			userService.save(u);
			ses.setAttribute("errorMessage", "");
			return "redirect:/gre/login/logged";
		} else {
			ses.setAttribute("errorMessage", "Nesprávné heslo!");
			return "redirect:/gre/login/1";
		}
	}

	@RequestMapping(value = "/deleteUser/{nick}")
	public String deleteUser(@PathVariable String nick, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t deleteUser(" + nick + ")");

		User u = userService.findbyNick(nick);
		
		if (u.getRole().startsWith("ADMIN")) {
			List<User> ul = userService.findNickByRole("ADMIN");

			if (ul.size() <= 1) {
			ses.setAttribute("errorMessage", "Snažite se smazat posledního ADMINa v aplikaci! Což nelze.");
			return "redirect:/gre/errorPage";
			}
		}

		userService.delete(userService.findbyNick(nick));
		return "redirect:/gre/login/logged";
	}

	@RequestMapping(value = "/changeParamUser")
	public String changeParamUser(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t changeParamUser(" + formObject.getNick() + ", " + formObject.getRole() + ", " + formObject.getPassword() + ")");

		User u = userService.findbyNick(formObject.getNick());
		
		if (u.getRole().startsWith("ADMIN") && !formObject.getRole().startsWith("ADMIN")) {
			List<User> ul = userService.findNickByRole("ADMIN");

			if (ul.size() <= 1) {
			ses.setAttribute("errorMessage", "Snažite se zrušit posledního ADMINa v aplikaci! Což nelze.");
			return "redirect:/gre/errorPage";
			}
		}

		u.setPassword(formObject.getPassword().isEmpty() ? u.getPassword() : formObject.getPassword());
		u.setRole(formObject.getRole());
		userService.save(u);

		return "redirect:/gre/login/logged";
	}

}
