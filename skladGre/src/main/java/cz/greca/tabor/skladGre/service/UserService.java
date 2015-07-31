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
	
	public void save(User user) {
		userRepository.save(user);
	}
	
	public void delete(User user) {
		userRepository.delete(user);
	}

	public List<User> findAll() {
		return userRepository.findAll();
	}

	public User findOne(int id) {
		return userRepository.findOne(id);
	}
	
	public User findbyNick(String nick) {
		return userRepository.findbyNick(nick);
	}

}
