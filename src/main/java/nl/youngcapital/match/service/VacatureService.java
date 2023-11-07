package nl.youngcapital.match.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.api.dto.VacatureDTO;
import nl.youngcapital.match.model.Vacature;
import nl.youngcapital.match.persistence.VacatureRepository;

@Service
public class VacatureService {
	
	@Autowired
	private VacatureRepository vacatureRepository;
	
	public List<Vacature> findAll() {
		return vacatureRepository.findAll();
	}
	
	public Optional<Vacature> findById(long id) {
		return this.vacatureRepository.findById(id);
	}
	
	public List<VacatureDTO> getAllVacatures() {
	    List<Vacature> vacatures = vacatureRepository.findAll();
	    List<VacatureDTO> vacaturesDTO = new ArrayList<>();
	    for (Vacature vacature : vacatures) {
	        vacaturesDTO.add(new VacatureDTO(vacature));
	    }
	    return vacaturesDTO;
	}

	public Optional<VacatureDTO> findVacatureById(long id) {
	    Optional<Vacature> vacature = vacatureRepository.findById(id);
	    return vacature.map(VacatureDTO::new);
	}

	public Vacature createOrUpdate(Vacature vacature) {
		return this.vacatureRepository.save(vacature);
	}
	
	public void deleteById(long id) {
		this.vacatureRepository.deleteById(id);
	}
	
}
