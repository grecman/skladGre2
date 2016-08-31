package cz.greca.tabor.skladGre.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.greca.tabor.skladGre.entity.Mj;
import cz.greca.tabor.skladGre.entity.RoleList;
import cz.greca.tabor.skladGre.obj.FormObject;
import cz.greca.tabor.skladGre.service.MjService;
import cz.greca.tabor.skladGre.service.RoleListService;

@Controller
@RequestMapping("/nastaveni")
public class NastaveniController {

	private static final Logger log = Logger.getLogger(NastaveniController.class);

	@Autowired
	private MjService mjService;

	@Autowired
	private RoleListService roleListService;

	@RequestMapping("")
	public String nastaveni(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t nastaveni()");

		ses.setAttribute("pageTitle", "Nastavení různých hodnot");

		List<Mj> mjList = mjService.findAll();
		model.addAttribute("mjList", mjList);

		List<RoleList> roleList = roleListService.findAll();
		model.addAttribute("roleList", roleList);

		return "nastaveni";

	}

}
