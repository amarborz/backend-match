package nl.youngcapital.match.api;

import java.util.List;
import java.util.Optional;

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

import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.service.TraineeService;

@RestController
@RequestMapping("api/trainee")
public class TraineeController {
	
	@Autowired
	private TraineeService traineeService;
	
	@GetMapping
	public List<Trainee> findAll() {
		return traineeService.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Trainee> findById(@PathVariable long id) {
		Optional<Trainee> optionalTrainee = this.traineeService.findById(id);
		
		if(optionalTrainee.isPresent()) {
			Trainee result = optionalTrainee.get();
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Trainee create(@RequestBody Trainee trainee) {
		return this.traineeService.createOrUpdate(trainee);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Trainee> updateById(@PathVariable long id, @RequestBody Trainee input) {
		Optional<Trainee> optionalTarget = this.traineeService.findById(id);
		
		if (optionalTarget.isEmpty()) {
			return null;
		}
	
		Trainee target = optionalTarget.get();
		target.setNaam(input.getNaam());
		target.setWachtwoord(input.getWachtwoord());
		target.setEmail(input.getEmail());
		target.setFoto(input.getFoto());
		target.setTelefoon(input.getTelefoon());
		target.setMotivatie(input.getMotivatie());
		target.setRichting(input.getRichting());
		target.setCv(input.getCv());
		target.setBio(input.getBio());
		
		Trainee updated = this.traineeService.createOrUpdate(target);
		return ResponseEntity.ok(updated);
				
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.traineeService.deleteById(id);
	}
	
}
