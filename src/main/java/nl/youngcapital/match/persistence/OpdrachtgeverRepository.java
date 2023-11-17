package nl.youngcapital.match.persistence;

import nl.youngcapital.match.model.Opdrachtgever;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OpdrachtgeverRepository extends JpaRepository<Opdrachtgever, Long> {

    Optional<Opdrachtgever> findByEmail(String email);
}
