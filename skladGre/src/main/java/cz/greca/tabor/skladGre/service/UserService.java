package cz.greca.tabor.skladGre.service;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cz.greca.tabor.skladGre.entity.User;
import cz.greca.tabor.skladGre.repository.UserRepository;


@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	static Logger log = Logger.getLogger("taborLogger"); 
	
	//@PersistenceContext(name = "UserService")
	@PersistenceContext
	private EntityManager entityManager;
	
	public void save(User user) {
		log.debug("###\t save()");
		userRepository.save(user);
	}
	
	public void delete(User user) {
		log.debug("###\t delete()");
		userRepository.delete(user);
	}

	public List<User> findAll() {
		log.debug("###\t findAll()");
		return userRepository.findAll();
	}

	public User findOne(int id) {
		log.debug("###\t findOne("+id+ ")");
		return userRepository.findOne(id);
	}
	
	public User findbyNick(String nick) {
		log.debug("###\t findbyNick("+nick+ ")");
		return userRepository.findbyNick(nick);
	}
	
	public List<User> findNickByRole(String role){
		List<User> gre;
		log.debug("###\t findNickByRole("+role+ ")");
		try {
			gre = entityManager.createQuery("SELECT g FROM User g WHERE g.role=:role ", User.class).setParameter("role", role).getResultList();
		} catch (NoResultException e) {
			return null;
		}
		return gre;
	}

}
