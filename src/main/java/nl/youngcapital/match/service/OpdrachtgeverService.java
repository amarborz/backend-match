package nl.youngcapital.match.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.api.dto.OpdrachtenVanOpdrachtgeverDTO;
import nl.youngcapital.match.api.dto.OpdrachtgeverDTO;
import nl.youngcapital.match.api.dto.OpdrachtgeverOpdrachtDTO;
import nl.youngcapital.match.api.dto.TalentmanagerDTO;
import nl.youngcapital.match.api.dto.VacatureDTO;
import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.model.Vacature;
import nl.youngcapital.match.persistence.OpdrachtRepository;
import nl.youngcapital.match.persistence.OpdrachtgeverRepository;
import nl.youngcapital.match.persistence.VacatureRepository;

@Service
public class OpdrachtgeverService {

	@Autowired
	private OpdrachtgeverRepository opdrachtgeverRepository;

	@Autowired
	private VacatureRepository vacatureRepository;

	public List<Opdrachtgever> findAll() {
		return opdrachtgeverRepository.findAll();
	}

	public Optional<Opdrachtgever> findById(long id) {
		return this.opdrachtgeverRepository.findById(id);
	}

	public List<OpdrachtgeverDTO> getAllOpdrachtgevers() {
		List<Opdrachtgever> opdrachtgevers = opdrachtgeverRepository.findAll();
		List<OpdrachtgeverDTO> opdrachtgeversDTO = new ArrayList<OpdrachtgeverDTO>();

		for (Opdrachtgever opdrachtgever : opdrachtgevers) {
			opdrachtgeversDTO.add(new OpdrachtgeverDTO(opdrachtgever));
		}
		return opdrachtgeversDTO;
	}

	public Optional<OpdrachtgeverDTO> findOpdrachtgeverById(long id) {
		Optional<Opdrachtgever> opdrachtgever = opdrachtgeverRepository.findById(id);
		return opdrachtgever.map(OpdrachtgeverDTO::new);
	}

	public List<VacatureDTO> findVacaturesByOpdrachtgeverId(long id) {
		Optional<Opdrachtgever> opdrachtgever = opdrachtgeverRepository.findById(id);
		List<VacatureDTO> vacatureDTO = new ArrayList<VacatureDTO>();

		if (opdrachtgever.isPresent()) {
			List<Vacature> vacatures = vacatureRepository.findByOpdrachtgever(opdrachtgever.get());

			for (Vacature vacature : vacatures) {
				vacatureDTO.add(new VacatureDTO(vacature));
			}
		}
		return vacatureDTO;
	}

	public Opdrachtgever createOrUpdate(Opdrachtgever opdrachtgever) {
		return this.opdrachtgeverRepository.save(opdrachtgever);
	}

	public void deleteById(long id) {
		this.opdrachtgeverRepository.deleteById(id);
	}

	public List<OpdrachtenVanOpdrachtgeverDTO> findOpdrachtenByOpdrachtgeverId(long id) {
		Optional<Opdrachtgever> optionalOpdrachtgever = this.opdrachtgeverRepository.findById(id);
		List<OpdrachtenVanOpdrachtgeverDTO> opdrachtenDTO = new ArrayList<OpdrachtenVanOpdrachtgeverDTO>();

		if (optionalOpdrachtgever.isPresent()) {
			Opdrachtgever opdrachtgever = optionalOpdrachtgever.get();
			for (Vacature vacature : opdrachtgever.getVacatures()) {
				for (Opdracht opdracht : vacature.getOpdrachten()) {
					Trainee trainee = opdracht.getTrainee();
					if (trainee != null) {
						opdrachtenDTO.add(new OpdrachtenVanOpdrachtgeverDTO(opdracht, trainee, vacature));
					}
				}
			}
		}
		return opdrachtenDTO;
	}

}
