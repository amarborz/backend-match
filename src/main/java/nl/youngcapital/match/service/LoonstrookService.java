package nl.youngcapital.match.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.model.Loonstrook;
import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.persistence.LoonstrookRepository;
import nl.youngcapital.match.persistence.TraineeRepository;

@Service
public class LoonstrookService {
	
	@Autowired
	private LoonstrookRepository loonstrookRepository;
	@Autowired
	private TraineeRepository traineeRepository;
	
	public List<Loonstrook> findAll() {
		return loonstrookRepository.findAll();
	}
	
	public Optional<Loonstrook> findById(long id) {
		return this.loonstrookRepository.findById(id);
	}

	public Loonstrook createOrUpdate(Loonstrook loonstrook) {
		return this.loonstrookRepository.save(loonstrook);
	}
	
	public void deleteById(long id) {
		this.loonstrookRepository.deleteById(id);
	}

	public void koppelLoonstrookAanTrainee(long traineeId, Loonstrook loonstrook) {
		loonstrook = this.loonstrookRepository.save(loonstrook);
		Trainee trainee = this.traineeRepository.findById(traineeId).get();
		trainee.addLoonstrook(loonstrook);
		this.traineeRepository.save(trainee);
	}
}
