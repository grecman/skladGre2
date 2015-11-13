package cz.greca.tabor.skladGre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cz.greca.tabor.skladGre.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAllByOrderByNickAsc();

	//@Query("select u from User u where u.nick = ?1") // toto tady nemusi byt !!!
	User findByNick(String nick);
	
//	@Query("SELECT g FROM User g WHERE g.role= ?1")  // tady ano! :)
//	List<User> findNickByRole(String role);
	
	//List<User> findTop3ByOrderByLevelAsc(); // priklad

}

