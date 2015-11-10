package cz.greca.tabor.skladGre.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.greca.tabor.skladGre.obj.FormObject;

@Controller
@RequestMapping("/osazenstvo")
public class OsazenstvoController {

	private static final Logger log = Logger.getLogger(OsazenstvoController.class);

	@RequestMapping(value = "/vyberTyp")
	public String vyberTyp(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t vyberTyp()");
		
		ses.setAttribute("pageTitle", "Seznamy personálu a dětí");

		return "osazenstvo";

	}



}
