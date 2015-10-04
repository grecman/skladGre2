package cz.greca.tabor.skladGre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.greca.tabor.skladGre.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

	//@Query("select u from User u where u.nick = ?1") // toto tady nemusi byt !!!
	User findByNick(String nick);
	
	public List<User> findAllByOrderByNickAsc();
	
	//public List<User> findTop3ByOrderByLevelAsc(); // priklad

}

