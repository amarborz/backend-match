package nl.youngcapital.match.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.api.dto.OpdrachtDTO;
import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.persistence.OpdrachtRepository;

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
	
	public List<OpdrachtDTO> getAllOpdrachten() {
	    List<Opdracht> opdrachten = opdrachtRepository.findAll();
	    List<OpdrachtDTO> opdrachtenDTO = new ArrayList<>();
	    for (Opdracht opdracht : opdrachten) {
	        opdrachtenDTO.add(new OpdrachtDTO(opdracht));
	    }
	    return opdrachtenDTO;
	}

	public Optional<OpdrachtDTO> findOpdrachtById(long id) {
	    Optional<Opdracht> opdracht = opdrachtRepository.findById(id);
	    return opdracht.map(OpdrachtDTO::new);
	}

	public Opdracht createOrUpdate(Opdracht opdracht) {
		return this.opdrachtRepository.save(opdracht);
	}
	
	public void deleteById(long id) {
		this.opdrachtRepository.deleteById(id);
	}
	
}
