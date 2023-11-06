package nl.youngcapital.match.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.model.Loonstrook;
import nl.youngcapital.match.persistence.LoonstrookRepository;

@Service
public class LoonstrookService {
	
	@Autowired
	private LoonstrookRepository loonstrookRepository;
	
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
}
