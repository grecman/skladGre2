package cz.greca.tabor.skladGre.service;

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

	public List<Sklad> findAll() {
		return skladRepository.findAll();
	}

	public Sklad findOne(int id) {
		return skladRepository.findOne(id);
	}
}
