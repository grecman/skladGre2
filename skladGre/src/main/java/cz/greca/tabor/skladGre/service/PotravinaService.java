package cz.greca.tabor.skladGre.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.Potravina;
import cz.greca.tabor.skladGre.repository.PotravinaRepository;

@Service
public class PotravinaService {

	@SuppressWarnings("unused")
	private static final Logger log = Logger.getLogger(PotravinaService.class);
	
	@Autowired
	private PotravinaRepository potravinaRepository;
	
	@PersistenceContext
	private EntityManager entityManager;

	public void save(Potravina potravina) {
		potravinaRepository.save(potravina);
	}

	public List<Potravina> findAll() {
		return potravinaRepository.findAll();
	}

	public Potravina findOne(int id) {
		return potravinaRepository.findOne(id);
	}

//	public Potravina find(String nazev) {
//		return potravinaRepository.findOne();
//	}
	
//	public void remove(int itemId) {
//		potravinaRepository.remove(itemId);
//	}

//	public void removeAll() {
//		potravinaRepository.removeAll();
//	}
	
	public Iterable<String> findPotravinaByString(String string) {
		//log.debug("\t### findPotravinaByString("+string+")");
		Iterable<String> gre = entityManager
				.createQuery(
						"select u.jmeno from Potravina u where u.jmeno like :string",
						String.class).setParameter("string", string.toUpperCase() + "%")
				.getResultList();
		//log.debug("\t### findPotravinaByString("+gre.toString()+")");
		return gre;
	}

}
