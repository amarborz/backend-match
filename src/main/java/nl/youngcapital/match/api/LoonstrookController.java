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

import nl.youngcapital.match.model.Loonstrook;
import nl.youngcapital.match.service.LoonstrookService;


@RestController
@RequestMapping("api/loonstrook")
public class LoonstrookController {
	
	@Autowired
	private LoonstrookService loonstrookService;
	
	@GetMapping
	public List<Loonstrook> findAll() {
		return loonstrookService.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Loonstrook> findById(@PathVariable long id) {
		Optional<Loonstrook> optionalLoonstrook = this.loonstrookService.findById(id);
		
		if(optionalLoonstrook.isPresent()) {
			Loonstrook result = optionalLoonstrook.get();
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Loonstrook create(@RequestBody Loonstrook loonstrook) {
		return this.loonstrookService.createOrUpdate(loonstrook);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Loonstrook> updateById(@PathVariable long id, @RequestBody Loonstrook input) {
		Optional<Loonstrook> optionalTarget = this.loonstrookService.findById(id);
		
		if (optionalTarget.isEmpty()) {
			return null;
		}
	
		Loonstrook target = optionalTarget.get();
		target.setSalarisBedrag(input.getSalarisBedrag());
		target.setPeriode(input.getPeriode());
		target.setUitbetaald(input.isUitbetaald());
		
		Loonstrook updated = this.loonstrookService.createOrUpdate(target);
		return ResponseEntity.ok(updated);
				
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.loonstrookService.deleteById(id);
	}
	
	@PostMapping("{traineeId}")
	public Loonstrook create2(@PathVariable("traineeId") long traineeId, @RequestBody Loonstrook loonstrook) {
		this.loonstrookService.koppelLoonstrookAanTrainee(traineeId, loonstrook);
		
		return null;
	}
}
