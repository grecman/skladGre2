package cz.greca.tabor.skladGre.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class ErrorPageController {


	private static final Logger log = Logger.getLogger(ErrorPageController.class);

	@RequestMapping(value = "/errorPage")
	public String errorPage(Model model, HttpServletRequest req, HttpSession ses) {
		log.debug("###\t errorPage("+ses.getAttribute("errorMessage")+")");
		ses.setAttribute("pageTitle", "Stránka chybových hlášení");
		
		model.addAttribute("errorMsg", ses.getAttribute("errorMessage"));
		ses.setAttribute("errorMessage", "");

		return "errorPage";
	}
	
}
