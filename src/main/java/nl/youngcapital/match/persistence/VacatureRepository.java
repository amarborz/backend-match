package nl.youngcapital.match.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.model.Vacature;

@Repository
public interface VacatureRepository extends JpaRepository<Vacature, Long> {

	List<Vacature> findByOpdrachtgever(Opdrachtgever opdrachtgever);

}
