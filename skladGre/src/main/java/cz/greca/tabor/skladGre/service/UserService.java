package cz.greca.tabor.skladGre.service;

import java.util.List;

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
	
//	@PersistenceContext
//	private EntityManager entityManager;
	
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
	
	public List<User> findAllByOrderByNickAsc() {
		log.debug("###\t findAllByOrderByNickAsc()");
		return userRepository.findAllByOrderByNickAsc();
	}
	
	public User findOne(long id) {
		log.debug("###\t findOne("+id+ ")");
		return userRepository.findOne(id);
	}
	
	public User findByNick(String nick) {
		log.debug("###\t findbyNick("+nick+ ")");
		return userRepository.findByNick(nick);
	}
	
//	public List<User> findNickByRole(String role){
//		log.debug("###\t findNickByRole("+role+ ")");
//		return userRepository.findNickByRole(role);
//	}
	
}
