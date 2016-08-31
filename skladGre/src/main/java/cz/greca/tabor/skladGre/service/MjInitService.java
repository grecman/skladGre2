package cz.greca.tabor.skladGre.service;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.Mj;
import cz.greca.tabor.skladGre.entity.RoleList;

@Service
public class MjInitService {

	static Logger log = Logger.getLogger(MjInitService.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private MjService mjService;

	// public static String removeDiacritics(String s) {
	// return Normalizer.normalize(s,
	// Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	// }

	public void init() throws ParseException {

		log.debug("###\t Zakladam merne jednotky (dosavadni budou smazany).");

		mjService.deleteAll();

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

	}
}
