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

import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.service.OpdrachtService;


@RestController
@RequestMapping("api/opdracht")
public class OpdrachtController {
	
	@Autowired
	private OpdrachtService opdrachtService;
	
	@GetMapping
	public List<Opdracht> findAll() {
		return opdrachtService.findAll();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<Opdracht> findById(@PathVariable long id) {
		Optional<Opdracht> optionalOpdracht = this.opdrachtService.findById(id);
		
		if(optionalOpdracht.isPresent()) {
			Opdracht result = optionalOpdracht.get();
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Opdracht create(@RequestBody Opdracht opdracht) {
		return this.opdrachtService.createOrUpdate(opdracht);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Opdracht> updateById(@PathVariable long id, @RequestBody Opdracht input) {
		Optional<Opdracht> optionalTarget = this.opdrachtService.findById(id);
		
		if (optionalTarget.isEmpty()) {
			return null;
		}
	
		Opdracht target = optionalTarget.get();
		target.setStatus(input.getStatus());
		target.setStartDatum(input.getStartDatum());
		target.setEindDatum(input.getEindDatum());
		
		Opdracht updated = this.opdrachtService.createOrUpdate(target);
		return ResponseEntity.ok(updated);
				
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.opdrachtService.deleteById(id);
	}
	
}
