package cz.greca.tabor.skladGre.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.greca.tabor.skladGre.entity.RoleList;

public interface RoleListRepository extends JpaRepository<RoleList, Long>{

	RoleList findOneByRole(String role);

	List<RoleList> findAllByOrderByRoleDesc();
	
}
