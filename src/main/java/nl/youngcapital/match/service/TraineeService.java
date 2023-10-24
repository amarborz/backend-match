package nl.youngcapital.match.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.persistence.TraineeRepository;

@Service
public class TraineeService {
	
	@Autowired
	private TraineeRepository traineeRepository;
	
	public List<Trainee> findAll() {
		return traineeRepository.findAll();
	}
	
	@Transactional
	public Trainee createOrUpdate(Trainee trainee) {
		return this.traineeRepository.save(trainee);
	}
	
	public void deleteById(long id) {
		this.traineeRepository.deleteById(id);
	}
	
}
