package cz.greca.tabor.skladGre.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class IndexController {

	private static final Logger log = Logger.getLogger(IndexController.class);

	@RequestMapping(value = "/index.html")
	public String index(HttpServletRequest req, HttpSession ses) {
		log.debug("###\t index()");
		ses.setAttribute("userLogin", "");
		ses.setAttribute("userRole", "");
		ses.setAttribute("errorMessage", "");
		ses.setAttribute("vybranyDenId", "");
				
		return "redirect:/gre/login/1";
	}
	
}
