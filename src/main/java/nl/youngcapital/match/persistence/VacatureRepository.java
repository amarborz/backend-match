package nl.youngcapital.match.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.youngcapital.match.model.Vacature;

@Repository
public interface VacatureRepository extends JpaRepository<Vacature, Long> {

}
