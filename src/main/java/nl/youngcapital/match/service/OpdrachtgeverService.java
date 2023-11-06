package nl.youngcapital.match.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.api.dto.OpdrachtgeverOpdrachtDTO;
import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.model.Vacature;
import nl.youngcapital.match.persistence.OpdrachtRepository;
import nl.youngcapital.match.persistence.OpdrachtgeverRepository;

@Service
public class OpdrachtgeverService {
	
	@Autowired
	private OpdrachtgeverRepository opdrachtgeverRepository;
	
	private OpdrachtRepository opdrachtRepository;
	
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

	public OpdrachtgeverOpdrachtDTO findOpdrachten(long id) {
		Optional<Opdrachtgever> optionalOpdrachtgever = this.opdrachtgeverRepository.findById(id);
		if (optionalOpdrachtgever.isPresent()) {
			Opdrachtgever opdrachtgever = optionalOpdrachtgever.get();
			
//			for (Vacature vacature : opdrachtgever.getVacatures()) {
//				if (vacature.getOpdrachtgever())
//			}
			Opdracht opdracht = new Opdracht();
			
			return new OpdrachtgeverOpdrachtDTO(opdracht, opdrachtgever);
		} else {
			return null;
		}
		
	}
	
}
