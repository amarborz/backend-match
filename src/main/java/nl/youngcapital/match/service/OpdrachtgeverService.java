package nl.youngcapital.match.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.persistence.OpdrachtgeverRepository;

@Service
public class OpdrachtgeverService {
	
	@Autowired
	private OpdrachtgeverRepository opdrachtgeverRepository;
	
	public List<Opdrachtgever> findAll() {
		return opdrachtgeverRepository.findAll();
	}
	
	public Optional<Opdrachtgever> findById(long id) {
		return this.opdrachtgeverRepository.findById(id);
	}

	public Opdrachtgever createOrUpdate(Opdrachtgever opdrachtgever) {
		return this.opdrachtgeverRepository.save(opdrachtgever);
	}
	
	public void deleteById(long id) {
		this.opdrachtgeverRepository.deleteById(id);
	}
	
}
