package cz.greca.tabor.skladGre.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.Sklad;
import cz.greca.tabor.skladGre.repository.SkladRepository;

@Service
public class SkladService {
	
	@Autowired
	private SkladRepository skladRepository;

	public void save(Sklad sklad) {
		skladRepository.save(sklad);
	}
	
	public void delete(Sklad sklad) {
		skladRepository.delete(sklad);
	}

	public List<Sklad> findAll() {
		return skladRepository.findAll();
	}

	public Sklad findOne(long id) {
		return skladRepository.findOne(id);
	}
	
	public Sklad findMaxUctenka() {
		return skladRepository.findMaxUctenka();
	}
	
	public List<Sklad> findByDayOrderByJmenoAsc(Date den) {
		return skladRepository.findByDayOrderByJmenoAsc(den);
	}
	
	public List<Sklad> findByDayOrderByUctenkaDesc(Date den) {
		return skladRepository.findByDayOrderByUctenkaDesc(den);
	}
	
}
