package nl.youngcapital.match.api;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.match.api.dto.TalentmanagerDTO;
import nl.youngcapital.match.api.dto.TraineeDTO;
import nl.youngcapital.match.api.dto.TraineeStatusVanTalentmanagersDTO;
import nl.youngcapital.match.api.dto.VacatureDTO;
import nl.youngcapital.match.model.Talentmanager;
import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.service.TalentmanagerService;
import nl.youngcapital.match.service.TraineeService;

@RestController
@RequestMapping("api/talentmanager")
public class TalentmanagerController {

	@Autowired
	private TalentmanagerService talentmanagerService;

	@Autowired
	private TraineeService traineeService;

	@GetMapping
	public List<TalentmanagerDTO> findAll() {
		return talentmanagerService.getAllTalentmanagers();
	}
	

	@GetMapping("{id}")
	public ResponseEntity<TalentmanagerDTO> findTalentmanagerById(@PathVariable long id) {
	    Optional<TalentmanagerDTO> optionalTalentmanager = this.talentmanagerService.findTalentmanagerById(id);
	    if (optionalTalentmanager.isPresent()) {
	        return ResponseEntity.ok(optionalTalentmanager.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@PostMapping
	public Talentmanager create(@RequestBody Talentmanager talentmanager) {
		return this.talentmanagerService.createOrUpdate(talentmanager);
	}

	@GetMapping("{id}/trainees")
	public ResponseEntity<List<TraineeDTO>> findTraineesByTalentmanagerId(@PathVariable long id) {
		List<TraineeDTO> trainees = talentmanagerService.findTraineesByTalentmanagerId(id);
		if (!trainees.isEmpty()) {
			return ResponseEntity.ok(trainees);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	 @GetMapping("{id}/trainee-status")
	    public ResponseEntity<List<TraineeStatusVanTalentmanagersDTO>> getTraineeStatusForTalentmanager(@PathVariable long id) {  
		 List<TraineeStatusVanTalentmanagersDTO> traineeStatus = talentmanagerService.getTraineeStatusForTalentmanager(id);
	        return ResponseEntity.ok(traineeStatus);
	    }

		
	@PutMapping("{id}")
	public ResponseEntity<Talentmanager> updateById(@PathVariable long id, @RequestBody Talentmanager input) {
		Optional<Talentmanager> optionalTarget = this.talentmanagerService.findById(id);

		if (optionalTarget.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Talentmanager target = optionalTarget.get();
		target.setNaam(input.getNaam());
		target.setEmail(input.getEmail());
		target.setFoto(input.getFoto());
		target.setTelefoon(input.getTelefoon());

		if (input.getTrainees() != null) {
			for (Trainee trainee : input.getTrainees()) {
				Optional<Trainee> optionalTrainee = this.traineeService.findById(trainee.getId());
				if (optionalTrainee.isPresent()) {
					Trainee existingTrainee = optionalTrainee.get();
					existingTrainee.setTalentmanager(target);
//					target.getTrainees().add(existingTrainee);
				}
			}
		}

		Talentmanager updated = this.talentmanagerService.createOrUpdate(target);
		return ResponseEntity.ok(updated);
	}
	@PutMapping("password/{id}")
	public ResponseEntity<Talentmanager> updatePasswordById(@PathVariable long id, @RequestBody Talentmanager input) {
		Optional<Talentmanager> optionalTarget = this.talentmanagerService.findById(id);

		if (optionalTarget.isEmpty()) {
			return ResponseEntity.notFound().build();
		}

		Talentmanager target = optionalTarget.get();
		target.setWachtwoord(input.getWachtwoord());

		Talentmanager updated = this.talentmanagerService.createOrUpdate(target);
		return ResponseEntity.ok(updated);
	}
	

	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.talentmanagerService.deleteById(id);
	}
}
