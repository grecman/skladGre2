package cz.greca.tabor.skladGre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.greca.tabor.skladGre.entity.User;


public interface UserRepository extends JpaRepository<User, Long> {

	List<User> findAllByOrderByNickAsc();

	User findOneByNick(String nick);
	
//	@Query("SELECT g FROM User g WHERE g.role= ?1")  // tady ano! :)
//	List<User> findNickByRole(String role);
	
	//List<User> findTop3ByOrderByLevelAsc(); // priklad

}

