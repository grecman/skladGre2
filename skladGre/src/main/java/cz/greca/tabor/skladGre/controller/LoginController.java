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

import cz.greca.tabor.skladGre.entity.Role;
import cz.greca.tabor.skladGre.entity.RoleList;
import cz.greca.tabor.skladGre.entity.Tabor;
import cz.greca.tabor.skladGre.entity.User;
import cz.greca.tabor.skladGre.obj.FormObject;
import cz.greca.tabor.skladGre.service.MjInitService;
import cz.greca.tabor.skladGre.service.MjService;
import cz.greca.tabor.skladGre.service.PotravinaInitService;
import cz.greca.tabor.skladGre.service.PotravinaService;
import cz.greca.tabor.skladGre.service.RoleListInitService;
import cz.greca.tabor.skladGre.service.RoleListService;
import cz.greca.tabor.skladGre.service.RoleService;
import cz.greca.tabor.skladGre.service.TaborService;
import cz.greca.tabor.skladGre.service.UserService;

@Controller
@RequestMapping("/login")
public class LoginController {

	@Autowired
	private UserService userService;

	@Autowired
	private RoleService roleService;

	@Autowired
	private RoleListService roleListService;

	@Autowired
	private RoleListInitService roleListInitService;

	@Autowired
	private MjService mjService;

	@Autowired
	private MjInitService mjInitService;

	@Autowired
	private PotravinaService potravinaService;

	@Autowired
	private PotravinaInitService potravinaInitService;

	@Autowired
	private TaborService taborService;

	private static final Logger log = Logger.getLogger(LoginController.class);

	@RequestMapping(value = "/1")
	public String loginPage(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t loginPage()");
		ses.setAttribute("pageTitle", "Logovací obrazovka");
		ses.setAttribute("userLogin", "");
		ses.setAttribute("userRole", "");
		ses.setAttribute("now", "");

		if (roleListService.findAll().isEmpty()) {
			try {
				roleListInitService.init();
			} catch (ParseException e) {
				log.error("### Inicializace RoleList: " + e);
			}
		}

		if (mjService.findAll().isEmpty()) {
			try {
				mjInitService.init();
			} catch (ParseException e) {
				log.error("### Inicializace mernych jednotek: " + e);
			}
		}

		if (potravinaService.findAll().isEmpty()) {
			try {
				potravinaInitService.init();
			} catch (ParseException e) {
				log.error("### Inicializace seznamu potravin: " + e);
			}
		}

		List<User> u = userService.findAllByOrderByNickAsc();
		model.addAttribute("listUser", u);

		List<Tabor> t = taborService.findAll();
		model.addAttribute("listTabor", t);

		List<RoleList> rl = roleListService.findAll();
		model.addAttribute("listRoleList", rl);

		// ses.setAttribute("userLogin", "GRECA");
		// ses.setAttribute("userRole", "ADMIN");
		// return "redirect:/gre/td/seznam";

		return "login";
	}

	@RequestMapping(value = "/logged")
	public String loggedUser(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t loggedUser(" + ses.getAttribute("userLogin") + ")");
		ses.setAttribute("pageTitle", "Logovací obrazovka (uživatel přihlášen)");

		if (ses.getAttribute("userLogin").toString().isEmpty() || ses.getAttribute("userLogin") == null) {
			ses.setAttribute("errorMessage", "Uživatel není přihlášen.");
			return "redirect:/gre/login/1";
		} else {
			// ses.setAttribute("errorMessage", "");
			User user = userService.findOneByNick(ses.getAttribute("userLogin").toString());
			model.addAttribute("loggedUser", user);

			List<User> u = userService.findAllByOrderByNickAsc();
			model.addAttribute("listUser", u);

			List<Tabor> t = taborService.findAll();
			model.addAttribute("listTabor", t);

			List<RoleList> rl = roleListService.findAll();
			model.addAttribute("listRoleList", rl);

			List<Role> r = roleService.findAllByUser(user);
			model.addAttribute("listRole", r);

			return "login";
		}
	}

	@RequestMapping(value = "/newTabor")
	public String newTabor(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model)
			throws ParseException {
		log.debug("###\t newTabor(" + formObject.getRok() + ", " + formObject.getMisto() + ", " + formObject.getBeh()
				+ ")");

		if (formObject.getMisto().isEmpty() || formObject.getBeh().isEmpty() || formObject.getRok() == null) {
			ses.setAttribute("errorMessage", "Chyba zadání!");
			return "redirect:/gre/errorPage";
		}

		Tabor t = taborService.findOne(formObject.getRok(), formObject.getMisto(), formObject.getBeh());

		if (t == null) {
			Tabor newT = new Tabor();
			newT.setRok(formObject.getRok());
			newT.setMisto(formObject.getMisto());
			newT.setBeh(formObject.getBeh());
			taborService.save(newT);

			ses.setAttribute("errorMessage", "");
		} else {
			ses.setAttribute("errorMessage", "Tabor již existuje!");
		}
		return "redirect:/gre/login/logged";
	}

	@RequestMapping(value = "/newUser")
	public String newUser(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model)
			throws ParseException {
		log.debug("###\t newUser(" + formObject.getNick().toUpperCase() + ", " + formObject.getPassword() + ", "
				+ formObject.getAdmin() + ")");

		if (formObject.getNick().isEmpty() || formObject.getPassword().isEmpty()) {
			ses.setAttribute("errorMessage", "Chyba zadání!");
			return "redirect:/gre/errorPage";
		}

		User u = userService.findOneByNick(formObject.getNick().toUpperCase());

		if (u == null) {
			User newUser = new User();
			newUser.setNick(formObject.getNick().toUpperCase());
			newUser.setPassword(formObject.getPassword());
			newUser.setPocetPrihlaseni(1);
			newUser.setPosledniPrihlaseni(new Date());
			newUser.setAdmin(userService.findAll().isEmpty() ? true : formObject.getAdmin());
			userService.save(newUser);

			ses.setAttribute("errorMessage", "");
		} else {
			ses.setAttribute("errorMessage", "Uživatel již existuje!");
		}
		return "redirect:/gre/login/logged";
	}

	@RequestMapping(value = "/enterLogin")
	public String enterPwd(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model)
			throws ParseException {
		log.debug("###\t enterPwd(" + formObject.getNick().toUpperCase() + ", " + formObject.getPassword() + ")");
		User u = userService.findOneByNick(formObject.getNick().toUpperCase());
		if (u != null && u.getPassword().startsWith(formObject.getPassword())
				&& u.getPassword().endsWith(formObject.getPassword())
				&& u.getPassword().length() == formObject.getPassword().length()) {
			ses.setAttribute("userLogin", u.getNick());
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

		userService.delete(userService.findOneByNick(nick));
		return "redirect:/gre/login/logged";
	}

	@RequestMapping(value = "/changeParamUser")
	public String changeParamUser(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t changeParamUser(" + formObject.getId() + ", " + formObject.getNick() + ", "
				+ formObject.getPassword() + ", " + formObject.getAdmin() + ")");

		User u = userService.findOne(formObject.getId());

		if (!formObject.getNick().isEmpty() && userService.findOneByNick(formObject.getNick()) != null) {
			ses.setAttribute("errorMessage", "Změnu nicku nelze provést, uživatel již existuje!");
			return "redirect:/gre/errorPage";
		}

		u.setNick(formObject.getNick().isEmpty() ? u.getNick() : formObject.getNick().toUpperCase());
		u.setPassword(formObject.getPassword().isEmpty() ? u.getPassword() : formObject.getPassword());

		if (formObject.getAdmin()) {
			u.setAdmin(true);
		} else {
			List<User> uAll = userService.findAll();
			int pocetAdminu = 0;
			for (User user : uAll) {
				if (user.getAdmin())
					pocetAdminu++;
			}
			if (pocetAdminu >= 2) {
				u.setAdmin(false);
			} else {
				log.debug("###\t Snazis se odebrat posledniho admina, coz nelze!");
			}

		}

		userService.save(u);

		return "redirect:/gre/login/logged";

	}

	@RequestMapping(value = "/deleteTabor/{id}")
	public String deleteTabor(@PathVariable long id, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t deleteTabor(" + id + ")");

		taborService.delete(taborService.findOne(id));
		return "redirect:/gre/login/logged";
	}

	@RequestMapping(value = "/changeParamTabor")
	public String changeParamTabor(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t changeParamTabor(" + formObject.getId() + ", " + formObject.getRok() + ", "
				+ formObject.getMisto() + ", " + formObject.getBeh() + ")");

		Tabor t = taborService.findOne(formObject.getId());
		t.setRok(formObject.getRok() == null ? t.getRok() : formObject.getRok());
		t.setMisto(formObject.getMisto().isEmpty() ? t.getMisto() : formObject.getMisto());
		t.setBeh(formObject.getBeh().isEmpty() ? t.getBeh() : formObject.getBeh());
		taborService.save(t);

		return "redirect:/gre/login/logged";

	}

	@RequestMapping(value = "/setRole")
	public String setRole(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t setRole(" + formObject.getNick() + ", " + formObject.getRole() + ", " + formObject.getId()
				+ ")");
		
		User u = userService.findOneByNick(formObject.getNick());
		Tabor t = taborService.findOne(formObject.getId());
		RoleList rl = roleListService.findOneByRole(formObject.getRole());
		
			
		Role existujiciRole = roleService.findOneByUserAndTabor(u.getId(), t.getId());
		
		if(existujiciRole == null){
			log.debug("###\t Zakladam novou roli: "+u.getNick()+"\t"+rl.getRole()+"\t"+t.getRok()+"-"+t.getMisto()+"-"+t.getBeh());
			Role r = new Role();
			r.setUser(u);
			r.setTabor(t);
			r.setRoleList(rl);
			roleService.save(r);
		} else {
			log.debug("###\t Zmena role pro "+u.getNick()+"\t"+t.getRok()+"-"+t.getMisto()+"-"+t.getBeh()+"\tna"+rl.getRole());
			existujiciRole.setRoleList(rl);
		}

		return "redirect:/gre/login/logged";

	}

}
