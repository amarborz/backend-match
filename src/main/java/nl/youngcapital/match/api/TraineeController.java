package nl.youngcapital.match.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.model.Vacature;
import nl.youngcapital.match.service.TraineeService;
import nl.youngcapital.match.service.VacatureService;

@RestController
@RequestMapping("api/trainee")
public class TraineeController {
	
	@Autowired
	private TraineeService traineeService;
	
	@GetMapping
	public List<Trainee> findAll() {
		return traineeService.findAll();
	}
	
	@PostMapping
	public Trainee create(@RequestBody Trainee trainee) {
		return this.traineeService.createOrUpdate(trainee);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.traineeService.deleteById(id);
	}
	
}
