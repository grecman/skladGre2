package cz.greca.tabor.skladGre.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cz.greca.tabor.skladGre.entity.Den;
import cz.greca.tabor.skladGre.repository.DenRepository;

@Service
public class DenService {

	static Logger log = Logger.getLogger(Den.class);

	@Autowired
	private DenRepository denRepository;

	@Transactional
	public void save(Den taborovyDen) {
		denRepository.save(taborovyDen);
	}

	@Transactional
	public void remove(Den taborovyDen) {
		denRepository.delete(taborovyDen);
	}

	public List<Den> findAll() {
		return denRepository.findAll(sortByDenAsc());
	}
	
	private Sort sortByDenAsc(){
		return new Sort(Sort.Direction.ASC, "den");
	}

	public Den findOne(long id) {
		return denRepository.findOne(id);
	}
	/*
	 * @PersistenceContext(name = "TaborovyDenService") private EntityManager
	 * entityManager;
	 * 
	 * public void addTaborovyDen(TaborovyDen TaborovyDen) { log.trace(
	 * "###\t\t addTaborovyDen("+TaborovyDen+")");
	 * entityManager.persist(TaborovyDen); }
	 * 
	 * public void updateTaborovyDen(TaborovyDen TaborovyDen) { log.trace(
	 * "###\t\t updateTaborovyDen("+TaborovyDen+")");
	 * entityManager.merge(TaborovyDen); }
	 * 
	 * public void removeTaborovyDen(TaborovyDen TaborovyDen) { log.trace(
	 * "###\t\t removeTaborovyDen("+TaborovyDen+")"); TaborovyDen u =
	 * getTaborovyDen(TaborovyDen.getId()); entityManager.remove(u); }
	 * 
	 * 
	 * 
	 * public List<TaborovyDen> getTaborovyDens() { log.trace(
	 * "###\t\t getTaborovyDens();"); return entityManager.createQuery(
	 * "SELECT u FROM TaborovyDen u ORDER BY u.den ",
	 * TaborovyDen.class).getResultList(); }
	 */
}
