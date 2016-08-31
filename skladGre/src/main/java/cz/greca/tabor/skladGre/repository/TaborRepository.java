package cz.greca.tabor.skladGre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import cz.greca.tabor.skladGre.entity.Tabor;

public interface TaborRepository extends JpaRepository<Tabor, Long>{

	@Query("SELECT g FROM Tabor g WHERE g.rok=?1 AND g.misto=?2 AND g.beh=?3 ")
	Tabor findOne(Integer rok, String misto, String beh);
		
}
