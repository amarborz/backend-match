package nl.youngcapital.match.service;

import java.util.Optional;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.model.Persoon;
import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.persistence.OpdrachtgeverRepository;
import nl.youngcapital.match.persistence.TalentmanagerRepository;
import nl.youngcapital.match.persistence.TraineeRepository;

@Service
public class AuthenticationService {

	@Autowired
	private TraineeRepository traineeRepository;

	@Autowired
	private TalentmanagerRepository talentmanagerRepository;

	@Autowired
	private OpdrachtgeverRepository opdrachtgeverRepository;

	public Optional<? extends Persoon> authenticate(String email, String password) {
		Optional<Trainee> optionalTrainee = traineeRepository.findByEmail(email);
		if (optionalTrainee.isPresent()) {
			Trainee trainee = optionalTrainee.get();

			// Check passwd
			if (password.equals(trainee.getWachtwoord())) {
				// Token aanmaken
				trainee.setToken(RandomStringUtils.random(100, true, true));

				// Trainee opslaan
				traineeRepository.save(trainee);

				// Token terug geven
				return optionalTrainee;
			}
		}
		
		// TODO Talentmanager check
		
		// TODO Opdrachtgever check
		
		return Optional.empty();
	}

}
