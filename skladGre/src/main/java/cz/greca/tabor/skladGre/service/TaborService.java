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
	
	static Logger log = Logger.getLogger(TaborService.class); 
	
	public void save(Tabor t) {
		log.trace("###\t save()");
		taborRepository.save(t);
	}
	
	public void delete(Tabor t) {
		log.trace("###\t delete()");
		taborRepository.delete(t);
	}

	public List<Tabor> findAll() {
		log.trace("###\t findAll()");
		return taborRepository.findAll();
	}
	
	public Tabor findOne(long id) {
		log.trace("###\t findOne("+id+ ")");
		return taborRepository.findOne(id);
	}
	
	public Tabor findOne(Integer rok, String misto, String beh) {
		log.trace("###\t findOne("+rok+","+misto+","+beh+ ")");
		return taborRepository.findOne(rok,misto,beh);
	}
	
	
}
