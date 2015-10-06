package cz.greca.tabor.skladGre.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cz.greca.tabor.skladGre.entity.Potravina;


public interface PotravinaRepository extends JpaRepository<Potravina, Long> {

	Potravina findByJmeno(String nazev);

}
