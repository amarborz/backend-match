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

import nl.youngcapital.match.api.dto.OpdrachtDTO;
import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.model.Vacature;
import nl.youngcapital.match.service.OpdrachtService;
import nl.youngcapital.match.service.VacatureService;

@RestController
@RequestMapping("api/opdracht")
public class OpdrachtController {

	@Autowired
	private OpdrachtService opdrachtService;
	
	@Autowired
	private VacatureService vacatureService;

	
	@GetMapping
	public List<OpdrachtDTO> findAllOpdrachten() {
	    return opdrachtService.getAllOpdrachten();
	}

	@GetMapping("{id}")
	public ResponseEntity<OpdrachtDTO> findOpdrachtById(@PathVariable long id) {
	    Optional<OpdrachtDTO> optionalOpdracht = opdrachtService.findOpdrachtById(id);
	    if (optionalOpdracht.isPresent()) {
	        return ResponseEntity.ok(optionalOpdracht.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}

	@PostMapping
	public Opdracht create(@RequestBody Opdracht opdracht) {
		return this.opdrachtService.createOrUpdate(opdracht);
	}

	@PostMapping("/{vacatureId}")
	public Opdracht createOpdrachtVoorVacature(@PathVariable long vacatureId, @RequestBody Opdracht opdracht) {
		Optional<Vacature> optionalVacature = vacatureService.findById(vacatureId);

		if (optionalVacature.isPresent()) {
			Vacature vacature = optionalVacature.get();
			opdracht.setVacature(vacature);
		}

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
