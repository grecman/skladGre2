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
	
	static Logger log = Logger.getLogger(UserService.class); 
		
//	@PersistenceContext
//	private EntityManager entityManager;
	
	public void save(User user) {
		log.trace("###\t save()");
		userRepository.save(user);
	}
	
	public void delete(User user) {
		log.trace("###\t delete()");
		userRepository.delete(user);
	}

	public List<User> findAll() {
		log.trace("###\t findAll()");
		return userRepository.findAll();
	}
	
	public List<User> findAllByOrderByNickAsc() {
		log.trace("###\t findAllByOrderByNickAsc()");
		return userRepository.findAllByOrderByNickAsc();
	}
	
	public User findOne(long id) {
		log.trace("###\t findOne("+id+ ")");
		return userRepository.findOne(id);
	}
	
	public User findOneByNick(String nick) {
		log.trace("###\t findOnebyNick("+nick+ ")");
		return userRepository.findOneByNick(nick);
	}
	
//	public List<User> findNickByRole(String role){
//		log.trace("###\t findNickByRole("+role+ ")");
//		return userRepository.findNickByRole(role);
//	}
	
}
