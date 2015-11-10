package cz.greca.tabor.skladGre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.greca.tabor.skladGre.entity.Mj;

public interface MjRepository extends JpaRepository<Mj, Long>{

	Mj findOneByMernaJednotka(String mj);

}
