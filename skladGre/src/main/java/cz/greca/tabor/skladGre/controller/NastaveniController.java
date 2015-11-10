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
import cz.greca.tabor.skladGre.obj.FormObject;
import cz.greca.tabor.skladGre.service.MjService;

@Controller
@RequestMapping("/nastaveni")
public class NastaveniController {

	private static final Logger log = Logger.getLogger(NastaveniController.class);

	@Autowired
	private MjService mjService;

	@RequestMapping("")
	public String nastaveni(FormObject formObject, HttpServletRequest req, HttpSession ses, Model model) {
		log.debug("###\t nastaveni()");

		ses.setAttribute("pageTitle", "Nastavení různých hodnot");

		if (mjService.findAll().size() != 7) {
			log.debug("###\t Neexistuji merne jednotky nebo jich je malo ... zakladam.");
			mjService.deleteAll();
			try {
				{
					Mj mj = new Mj();
					mj.setMernaJednotka("ks");
					mj.setPopis("kusy");
					mjService.save(mj);
				}
				{
					Mj mj = new Mj();
					mj.setMernaJednotka("g");
					mj.setPopis("gram");
					mjService.save(mj);
				}
				{
					Mj mj = new Mj();
					mj.setMernaJednotka("kg");
					mj.setPopis("kilogram");
					mjService.save(mj);
				}
				{
					Mj mj = new Mj();
					mj.setMernaJednotka("ml");
					mj.setPopis("mililitr");
					mjService.save(mj);
				}
				{
					Mj mj = new Mj();
					mj.setMernaJednotka("l");
					mj.setPopis("litr");
					mjService.save(mj);
				}
				{
					Mj mj = new Mj();
					mj.setMernaJednotka("mm");
					mj.setPopis("milimetr");
					mjService.save(mj);
				}
				{
					Mj mj = new Mj();
					mj.setMernaJednotka("cm2");
					mj.setPopis("centimetr ctverecny");
					mjService.save(mj);
				}
			} catch (Exception e) {
				log.error(e);
			}

		}

		//mjService.delete(mjService.findOneByMernaJednotka("cm2"));

		List<Mj> mjList = mjService.findAll();
		model.addAttribute("mjList", mjList);

		return "nastaveni";

	}

}
