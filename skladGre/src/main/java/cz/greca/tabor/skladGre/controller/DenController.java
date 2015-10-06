package cz.greca.tabor.skladGre.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import cz.greca.tabor.skladGre.entity.Den;
import cz.greca.tabor.skladGre.obj.FormObject;
import cz.greca.tabor.skladGre.service.DenService;

@Controller
@RequestMapping("/td")
public class DenController {

	@Autowired
	private DenService denService;

	private static final Logger log = Logger.getLogger(DenController.class);

	@RequestMapping("/seznam")
	public String seznamDnu(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t seznamDnu()");
		ses.setAttribute("pageTitle", "Seznam táborových dnů");

		List<Den> td = denService.findAll();
		model.addAttribute("listTd", td);

		return "dny";
	}

	@RequestMapping("/vytvorDny")
	public String vytvorDny(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t vytvorDny(" + formObject.getPrvniDen() + " - " + formObject.getPocetTaborovychDnu() + ")");

		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");

		for (int i = 0; i < formObject.getPocetTaborovychDnu(); i++) {
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(formObject.getPrvniDen()));
			c.add(Calendar.DATE, i);

			Den d = new Den();
			d.setDen(sdf.parse(sdf.format(c.getTime())));
			d.setNorma(9000);
			denService.save(d);
		}
		return "redirect:/gre/td/seznam";
	}

	@RequestMapping("/deleteAll")
	public String deleteAll(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t deleteAll()");
		denService.deleteAll();
//		List<Den> d = denService.findAll();
//		for (Den den : d) {
//			denService.delete(den);
//		}
		return "redirect:/gre/td/seznam";
	}

	@RequestMapping("/changeNorma")
	public String changeNorma(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t changeNorma(" + formObject.getId() + ", " + formObject.getNorma() + ")");
		
		Den d = denService.findOne(formObject.getId());
		System.out.println(d.getId()+", "+d.getDen()+", "+d.getNorma());
		d.setNorma(formObject.getNorma());
		denService.save(d);
		
		return "redirect:/gre/td/seznam";
	}

}
