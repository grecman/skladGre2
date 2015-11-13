package cz.greca.tabor.skladGre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.greca.tabor.skladGre.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findOneByRole(String role);

}
