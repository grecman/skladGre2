package cz.greca.tabor.skladGre.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.Role;
import cz.greca.tabor.skladGre.repository.RoleRepository;

@Service
public class RoleService {

	static Logger log = Logger.getLogger(Role.class);

	@Autowired
	private RoleRepository roleRepository;

	public void save(Role role) {
		roleRepository.save(role);
	}

	public void delete(Role role) {
		roleRepository.delete(role);
	}
	
	public void deleteAll() {
		roleRepository.deleteAll();
	}
	
	public List<Role> findAll() {
		return roleRepository.findAll();
	}
	
	public Role findOne(long id) {
		return roleRepository.findOne(id);
	}
	
	public Role findOneByRole(String role) {
		return roleRepository.findOneByRole(role);
	}

	 

}
