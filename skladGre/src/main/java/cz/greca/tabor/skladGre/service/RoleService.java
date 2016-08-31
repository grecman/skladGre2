package cz.greca.tabor.skladGre.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.Role;
import cz.greca.tabor.skladGre.entity.User;
import cz.greca.tabor.skladGre.repository.RoleRepository;

@Service
public class RoleService {

	static Logger log = Logger.getLogger(RoleService.class);

	@Autowired
	private RoleRepository roleRepository;

	public void save(Role role) {
		log.trace("### save()");
		roleRepository.save(role);
	}

	public void delete(Role role) {
		log.trace("### delete()");
		roleRepository.delete(role);
	}
	
	public void deleteAll() {
		log.trace("### deleteAll()");
		roleRepository.deleteAll();
	}
	
	public List<Role> findAll() {
		log.trace("### findAll()");
		return roleRepository.findAll();
	}
	
	public List<Role> findAllByUser(User user) {
		log.trace("### findAllByUser("+user+")");
		return roleRepository.findAllByUser(user);
	}
	
	public Role findOne(long id) {
		log.trace("### findOne("+id+")");
		return roleRepository.findOne(id);
	}
	
	public Role findOneByUserAndTabor(Long idUser, Long idTabor) {
		log.trace("### findOneByUserAndTabor("+idUser+","+idTabor+")");
		return roleRepository.findOneByUserAndTabor(idUser,idTabor);
	}
	
	

}
