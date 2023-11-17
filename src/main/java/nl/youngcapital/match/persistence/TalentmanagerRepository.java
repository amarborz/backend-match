package nl.youngcapital.match.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.youngcapital.match.model.Talentmanager;
import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.model.Vacature;

import java.util.Optional;

@Repository
public interface TalentmanagerRepository extends JpaRepository<Talentmanager, Long> {

    Optional<Talentmanager> findByEmail(String email);
}
