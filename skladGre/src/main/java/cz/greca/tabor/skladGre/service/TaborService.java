package cz.greca.tabor.skladGre.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.Tabor;
import cz.greca.tabor.skladGre.repository.TaborRepository;


@Service
public class TaborService {
	
	@Autowired
	private TaborRepository taborRepository;
	
	static Logger log = Logger.getLogger("taborLogger"); 
	
	public void save(Tabor t) {
		log.debug("###\t save()");
		taborRepository.save(t);
	}
	
	public void delete(Tabor t) {
		log.debug("###\t delete()");
		taborRepository.delete(t);
	}

	public List<Tabor> findAll() {
		log.debug("###\t findAll()");
		return taborRepository.findAll();
	}
	
	public Tabor findOne(long id) {
		log.debug("###\t findOne("+id+ ")");
		return taborRepository.findOne(id);
	}
	
	
}
