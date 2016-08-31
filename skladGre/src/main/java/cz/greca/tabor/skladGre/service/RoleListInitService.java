package cz.greca.tabor.skladGre.service;

import java.text.ParseException;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.RoleList;

@Service
public class RoleListInitService {

	static Logger log = Logger.getLogger(RoleListInitService.class);

	@PersistenceContext
	private EntityManager entityManager;

	@Autowired
	private RoleListService roleListService;

	// public static String removeDiacritics(String s) {
	// return Normalizer.normalize(s,
	// Normalizer.Form.NFD).replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
	// }

	public void init() throws ParseException {
		
		log.debug("###\t Zakladam zakladni role (dosavadni budou smazany).");
		
		roleListService.deleteAll();

		{
			RoleList p = new RoleList();
			p.setRole("WRITER");
			p.setPopis("Hospodář, zástupce hosodáře");
			roleListService.save(p);
		}
		{
			RoleList p = new RoleList();
			p.setRole("READER");
			p.setPopis("Vedoucí tábora, kontrola, atd.");
			roleListService.save(p);
		}
		{
			RoleList p = new RoleList();
			p.setRole("READER_NO_COSTS");
			p.setPopis("Reader bez nákladů");
			roleListService.save(p);
		}

	}

}
