package nl.youngcapital.match.service;

import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.persistence.OpdrachtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OpdrachtService {
	
	@Autowired
	private OpdrachtRepository opdrachtRepository;
	
	public List<Opdracht> findAll() {
		return opdrachtRepository.findAll();
	}
	
	public Optional<Opdracht> findById(long id) {
		return this.opdrachtRepository.findById(id);
	}

	public Opdracht createOrUpdate(Opdracht opdracht) {
		return this.opdrachtRepository.save(opdracht);
	}
	
	public void deleteById(long id) {
		this.opdrachtRepository.deleteById(id);
	}
	
}
