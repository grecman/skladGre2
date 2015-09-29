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
@RequestMapping("/td")
public class TaborovyDenController {

	@Autowired
	private TaborovyDenService taborovyDenService;

	@Autowired
	private PotravinaService potravinaService;

	@Autowired
	private UserService userService;

	private static final Logger log = Logger.getLogger(TaborovyDenController.class);

	@RequestMapping("/seznam")
	public String taborovyDen(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t taborovyDen()");
		ses.setAttribute("pageTitle", "Seznam táborových dnů");

		return "taboroveDny";
	}
}
