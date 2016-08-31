package cz.greca.tabor.skladGre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cz.greca.tabor.skladGre.entity.Role;
import cz.greca.tabor.skladGre.entity.User;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findOneByRoleList(long roleListId);

	List<Role> findAllByUser(User user);

	@Query("SELECT g FROM Role g WHERE g.user.id=?1 AND g.tabor.id=?2") 
	Role findOneByUserAndTabor(Long idUser, Long idTabor);

}
