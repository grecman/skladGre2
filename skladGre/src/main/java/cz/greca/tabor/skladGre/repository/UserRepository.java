package cz.greca.tabor.skladGre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cz.greca.tabor.skladGre.entity.User;


public interface UserRepository extends JpaRepository<User, Integer> {

	@Query("select u from User u where u.nick = ?1")
	User findbyNick(String nick);

}

