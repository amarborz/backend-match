package nl.youngcapital.match.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.youngcapital.match.model.Loonstrook;

@Repository
public interface LoonstrookRepository extends JpaRepository<Loonstrook, Long> {

}
