package cz.greca.tabor.skladGre.controller;

import java.text.Normalizer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping()
public class IndexController {

	public static String removeDiacritics(String s) {
		return Normalizer.normalize(s, Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	}

	private static final Logger log = Logger.getLogger(IndexController.class);

	@RequestMapping(value = "/index.html")
	public String index(HttpServletRequest req, HttpSession ses) {
		log.debug("###\t index()");
		ses.setAttribute("userLogin", "");
		ses.setAttribute("userRole", "");
		ses.setAttribute("errorMessage", "");

		return "redirect:/gre/login/1";
	}
	
}
