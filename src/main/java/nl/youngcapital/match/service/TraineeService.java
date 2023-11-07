package nl.youngcapital.match.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.api.dto.OpdrachtenVanOpdrachtgeverDTO;
import nl.youngcapital.match.api.dto.OpdrachtenVanTraineeDTO;
import nl.youngcapital.match.api.dto.TraineeDTO;
import nl.youngcapital.match.api.dto.VacatureDTO;
import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.model.Vacature;
import nl.youngcapital.match.persistence.TraineeRepository;

@Service
public class TraineeService {

	@Autowired
	private TraineeRepository traineeRepository;

	public List<Trainee> findAll() {
		return traineeRepository.findAll();
	}

	public Optional<Trainee> findById(long id) {
		return this.traineeRepository.findById(id);
	}

	public List<TraineeDTO> getAllTrainees() {
		List<Trainee> trainees = traineeRepository.findAll();
		List<TraineeDTO> traineesDTO = new ArrayList<>();
		for (Trainee trainee : trainees) {
			traineesDTO.add(new TraineeDTO(trainee));
		}
		return traineesDTO;
	}

	public Optional<TraineeDTO> findTraineeById(long id) {
		Optional<Trainee> trainee = traineeRepository.findById(id);
		return trainee.map(TraineeDTO::new);
	}

	public List<OpdrachtenVanTraineeDTO> findOpdrachtenByTraineeId(long id) {
		Optional<Trainee> optionalTrainee = this.traineeRepository.findById(id);
		List<OpdrachtenVanTraineeDTO> opdrachtenDTO = new ArrayList<OpdrachtenVanTraineeDTO>();

		if (optionalTrainee.isPresent()) {
			Trainee trainee = optionalTrainee.get();
			for (Opdracht opdracht : trainee.getOpdrachten()) {
				Vacature vacature = opdracht.getVacature();
				if (vacature != null) {
					Opdrachtgever opdrachtgever = vacature.getOpdrachtgever();
					if (opdrachtgever != null) {
						opdrachtenDTO.add(new OpdrachtenVanTraineeDTO(opdracht, vacature, opdrachtgever));
					}
				}
			}
		}
		return opdrachtenDTO;
	}

	public Trainee createOrUpdate(Trainee trainee) {
		return this.traineeRepository.save(trainee);
	}

	public void deleteById(long id) {
		this.traineeRepository.deleteById(id);
	}

}
