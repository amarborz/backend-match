package nl.youngcapital.match.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.persistence.OpdrachtRepository;
import nl.youngcapital.match.persistence.OpdrachtgeverRepository;

@Service
public class OpdrachtService {
	
	@Autowired
	private OpdrachtRepository opdrachtRepository;
	
	public List<Opdracht> findAll() {
		return opdrachtRepository.findAll();
	}
	
	@Transactional
	public Opdracht createOrUpdate(Opdracht opdracht) {
		return this.opdrachtRepository.save(opdracht);
	}
	
	public void deleteById(long id) {
		this.opdrachtRepository.deleteById(id);
	}
	
}
