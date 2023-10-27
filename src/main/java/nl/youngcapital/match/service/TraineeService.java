package nl.youngcapital.match.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.model.Trainee;
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

	public Trainee createOrUpdate(Trainee trainee) {
		return this.traineeRepository.save(trainee);
	}
	
	public void deleteById(long id) {
		this.traineeRepository.deleteById(id);
	}
	
}
