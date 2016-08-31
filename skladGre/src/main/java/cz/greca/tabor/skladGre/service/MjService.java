package cz.greca.tabor.skladGre.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.Mj;
import cz.greca.tabor.skladGre.repository.MjRepository;

@Service
public class MjService {

	static Logger log = Logger.getLogger(MjService.class);
	
//	@PersistenceContext 
//	private EntityManager entityManager;

	@Autowired
	private MjRepository mjRepository;

	public void save(Mj mj) {
		mjRepository.save(mj);
	}

	public void delete(Mj mj) {
		mjRepository.delete(mj);
	}
	
	public void deleteAll() {
		mjRepository.deleteAll();
	}
	
	public List<Mj> findAll() {
		return mjRepository.findAll();
	}
	
	public Mj findOne(long id) {
		return mjRepository.findOne(id);
	}
	
	public Mj findOneByMernaJednotka(String mj) {
		return mjRepository.findOneByMernaJednotka(mj);
	}
//	
//	private Sort sortByDenAsc(){
//		return new Sort(Sort.Direction.ASC, "den");
//	}
//
//	public Den findOne(long id) {
//		return denRepository.findOne(id);
//	}
	
	 

}
