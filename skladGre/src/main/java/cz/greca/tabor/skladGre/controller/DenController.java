package cz.greca.tabor.skladGre.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import cz.greca.tabor.skladGre.entity.Den;
import cz.greca.tabor.skladGre.entity.Mj;
import cz.greca.tabor.skladGre.entity.Potravina;
import cz.greca.tabor.skladGre.entity.Sklad;
import cz.greca.tabor.skladGre.obj.FormObject;
import cz.greca.tabor.skladGre.service.DenService;
import cz.greca.tabor.skladGre.service.MjService;
import cz.greca.tabor.skladGre.service.PotravinaService;
import cz.greca.tabor.skladGre.service.SkladService;

@Controller
@RequestMapping("/td")
public class DenController {
	
	@Autowired
	private DenService denService;
	
	@Autowired
	private PotravinaService potravinaService;
	
	@Autowired
	private MjService mjService;
	
	@Autowired
	private SkladService skladService;
	
	private static final Logger log = Logger.getLogger(DenController.class);
	
	@RequestMapping("/seznam")
	public String seznamDnu(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t seznamDnu()");
		ses.setAttribute("pageTitle", "Seznam táborových dnů");
		
		List<Den> td = denService.findAll();
		model.addAttribute("tdList", td);
		model.addAttribute("today", new Date());
		
		if (!ses.getAttribute("vybranyDenId").toString().isEmpty()) {
			
			List<Mj> mjList = mjService.findAll();
			model.addAttribute("mjList", mjList);
			
			Den d = denService.findOne(Long.valueOf(ses.getAttribute("vybranyDenId").toString()));
			model.addAttribute("vybranyDen", d);
			
			List<Sklad> sk = skladService.findByDayOrderByJmenoAsc(d.getDen());
			model.addAttribute("skladDenList", sk);
		}
		
		return "dny";
	}
	
	@RequestMapping("/vytvorDny")
	public String vytvorDny(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t vytvorDny(" + formObject.getPrvniDen() + " - " + formObject.getPocetTaborovychDnu() + ", " + formObject.getNorma() + ")");
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		for (int i = 0; i < formObject.getPocetTaborovychDnu(); i++) {
			Calendar c = Calendar.getInstance();
			c.setTime(sdf.parse(formObject.getPrvniDen()));
			c.add(Calendar.DATE, i);
			
			Den d = new Den();
			d.setDen(c.getTime());
			d.setNorma(formObject.getNorma());
			d.setPoradi(i + 1);
			denService.save(d);
		}
		return "redirect:/gre/td/seznam";
	}
	
	@RequestMapping("/deleteAll")
	public String deleteAll(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t deleteAll()");
		denService.deleteAll();
		ses.setAttribute("vybranyDenId", "");
		return "redirect:/gre/td/seznam";
	}
	
	@RequestMapping("/vybratDen/{idDen}")
	public String vybratDen(@PathVariable long idDen, FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t vybratDen(" + idDen + ")");
		
		Den d = denService.findOne(idDen);
		ses.setAttribute("vybranyDenId", d.getId());
		
		return "redirect:/gre/td/seznam";
	}
	
	@RequestMapping("/zrusitVybranyDen")
	public String zrusitVybranyDen(HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t zrusitVybranyDen()");
		
		ses.setAttribute("vybranyDenId", "");
		
		return "redirect:/gre/td/seznam";
	}
	
	@RequestMapping("/changeNorma")
	public String changeNorma(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) throws ParseException {
		log.debug("###\t changeNorma(" + formObject.getId() + ", " + formObject.getNorma() + ")");
		
		Den d = denService.findOne(formObject.getId());
		d.setNorma(formObject.getNorma());
		denService.save(d);
		
		return "redirect:/gre/td/seznam";
	}
	
	@RequestMapping(headers = "Content-Type=application/json", value = "/autocompleteNazevPotraviny")
	@ResponseBody
	public Iterable<String> autocompleteNazevPotraviny(@RequestParam String string) {
		log.debug("### autocompleteNazevPotraviny:" + string);
		return potravinaService.findPotravinaByString(string);
	}
	
	@RequestMapping("/priradPotravinuDoDne/{denId}")
	public String priradPotravinuDoDne(@PathVariable long denId, FormObject formObject, HttpServletRequest req, HttpSession ses, Model model)
			throws ParseException {
		log.debug("###\t priradPotravinuDoDne(" + formObject.getJmeno() + ", " + formObject.getCena() + ", " + formObject.getMnozstvi() + ", "
				+ formObject.getMernaJednotka() + ", " + formObject.getUctenka() + ")");
				
		Den d = denService.findOne(denId);
		
		Sklad s = new Sklad();
		s.setCena(Float.valueOf(formObject.getCena().replace(",", ".")));
		s.setMnozstvi(Float.valueOf(formObject.getMnozstvi().replace(",", ".")));
		s.setDatumPrijmu(new Date());
		s.setMernaJednotka(formObject.getMernaJednotka());
		s.setDen(d);
		s.setJmenoPotraviny(formObject.getJmeno());
		s.setUctenka(formObject.getUctenka());
		skladService.save(s);
		
		return "redirect:/gre/td/seznam";
	}
	
	@RequestMapping("/smazatPotravinu/{skladId}")
	public String smazatPotravinu(@PathVariable long skladId, HttpServletRequest req, HttpSession ses, Model model)
			throws ParseException {
		log.debug("###\t smazatPotravinu(" + skladId + ")");
				
		skladService.delete(skladService.findOne(skladId));
		
		return "redirect:/gre/td/seznam";
	}
	
}
