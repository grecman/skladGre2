package cz.greca.tabor.skladGre.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.RoleList;
import cz.greca.tabor.skladGre.repository.RoleListRepository;

@Service
public class RoleListService {

	static Logger log = Logger.getLogger(RoleListService.class);

	@Autowired
	private RoleListRepository roleListRepository;

	public void save(RoleList role) {
		roleListRepository.save(role);
	}

	public void delete(RoleList role) {
		roleListRepository.delete(role);
	}
	
	public void deleteAll() {
		roleListRepository.deleteAll();
	}
	
	public List<RoleList> findAll() {
		return roleListRepository.findAll();
	}
	
	public List<RoleList> findAllByOrderByRoleDesc() {
		return roleListRepository.findAllByOrderByRoleDesc();
	}
	
	public RoleList findOne(long id) {
		return roleListRepository.findOne(id);
	}
	
	public RoleList findOneByRole(String role) {
		log.trace("### findOneByRole("+role+")");
		return roleListRepository.findOneByRole(role);
	}
	

}
