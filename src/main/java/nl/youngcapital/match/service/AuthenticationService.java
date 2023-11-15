package nl.youngcapital.match.service;

import java.util.Optional;

import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.model.Talentmanager;
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
		
		// Talentmanager check
		Optional<Talentmanager> optionalTalentmanager = talentmanagerRepository.findByEmail(email);
		if (optionalTalentmanager.isPresent()) {
			Talentmanager talentmanager = optionalTalentmanager.get();

			// Check passwd
			if (password.equals(talentmanager.getWachtwoord())) {
				// Token aanmaken
				talentmanager.setToken(RandomStringUtils.random(100, true, true));

				// Talentmanager opslaan
				talentmanagerRepository.save(talentmanager);

				// Token terug geven
				return optionalTalentmanager;
			}
		}

		// Opdrachtgever check
		Optional<Opdrachtgever> optionalOpdrachtgever = opdrachtgeverRepository.findByEmail(email);
		if (optionalOpdrachtgever.isPresent()) {
			Opdrachtgever opdrachtgever = optionalOpdrachtgever.get();

			// Check passwd
			if (password.equals(opdrachtgever.getWachtwoord())) {
				// Token aanmaken
				opdrachtgever.setToken(RandomStringUtils.random(100, true, true));

				// Opdrachtgever opslaan
				opdrachtgeverRepository.save(opdrachtgever);

				// Token terug geven
				return optionalOpdrachtgever;
			}
		}

		return Optional.empty();
	}

}
