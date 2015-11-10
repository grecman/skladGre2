package cz.greca.tabor.skladGre.repository;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cz.greca.tabor.skladGre.entity.Sklad;

public interface SkladRepository extends JpaRepository<Sklad, Long> {

	@Query("SELECT g FROM Sklad g WHERE rownum()=1 ORDER BY g.uctenka DESC")
	Sklad findMaxUctenka();

	@Query("SELECT g FROM Sklad g WHERE g.den.den = ?1 ORDER BY g.potravina.jmeno Asc")
	List<Sklad> findByDayOrderByJmenoAsc(Date den);
	
	@Query("SELECT g FROM Sklad g WHERE g.den.den = ?1 ORDER BY g.uctenka Asc")
	List<Sklad> findByDayOrderByUctenkaDesc(Date den);

}
