package nl.youngcapital.match.persistence;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import nl.youngcapital.match.model.Talentmanager;
import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.model.Vacature;

@Repository
public interface TraineeRepository extends JpaRepository<Trainee, Long> {

	List<Trainee> findByTalentmanager(Talentmanager talentmanager);
	
	Optional<Trainee> findByEmail(String email);

	Optional<Trainee> findByEmail(String email);

}
