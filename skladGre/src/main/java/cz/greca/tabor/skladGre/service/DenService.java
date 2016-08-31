package cz.greca.tabor.skladGre.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.Den;
import cz.greca.tabor.skladGre.repository.DenRepository;

@Service
public class DenService {

	static Logger log = Logger.getLogger(DenService.class);
	
//	@PersistenceContext 
//	private EntityManager entityManager;

	@Autowired
	private DenRepository denRepository;

	public void save(Den taborovyDen) {
		denRepository.save(taborovyDen);
	}

	public void delete(Den taborovyDen) {
		denRepository.delete(taborovyDen);
	}
	
	public void deleteAll() {
		denRepository.deleteAll();
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
	
	 

}
