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

import nl.youngcapital.match.api.dto.OpdrachtenVanOpdrachtgeverDTO;
import nl.youngcapital.match.api.dto.VacatureDTO;
import nl.youngcapital.match.model.Vacature;
import nl.youngcapital.match.service.VacatureService;

@RestController
@RequestMapping("api/vacature")
public class VacatureController {
	
	@Autowired
	private VacatureService vacatureService;
	
	@GetMapping
	public List<VacatureDTO> findAllVacatures() {
	    return vacatureService.getAllVacatures();
	}

	@GetMapping("{id}")
	public ResponseEntity<VacatureDTO> findVacatureById(@PathVariable long id) {
	    Optional<VacatureDTO> optionalVacature = vacatureService.findVacatureById(id);
	    if (optionalVacature.isPresent()) {
	        return ResponseEntity.ok(optionalVacature.get());
	    } else {
	        return ResponseEntity.notFound().build();
	    }
	}
	
	@GetMapping("/opdrachtgever/{opdrachtgeverId}")
	public ResponseEntity<List<VacatureDTO>> findVacatureByOpdrachtgeverId(@PathVariable long opdrachtgeverId) {
		List<VacatureDTO> vacatures = vacatureService.findVacatureByOpdrachtgever(opdrachtgeverId);
		if (!vacatures.isEmpty()) {
			return ResponseEntity.ok(vacatures);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Vacature> updateById(@PathVariable long id, @RequestBody Vacature input) {
		Optional<Vacature> optionalTarget = this.vacatureService.findById(id);
		
		if (optionalTarget.isEmpty()) {
			return null;
		}
	
		Vacature target = optionalTarget.get();
		target.setPlaats(input.getPlaats());
		target.setAdres(input.getAdres());
		target.setOmschrijving(input.getOmschrijving());
		target.setVereisten(input.getVereisten());
		target.setUren(input.getUren());
		target.setDuur(input.getDuur());
		target.setTitel(input.getTitel());
		target.setPublicatieDatum(input.getPublicatieDatum());
		target.setStartDatum(input.getStartDatum());
		target.setEindDatum(input.getEindDatum());
		
		Vacature updated = this.vacatureService.createOrUpdate(target);
		return ResponseEntity.ok(updated);
				
	}
	
	@PostMapping
	public Vacature create(@RequestBody Vacature vacature) {
		return this.vacatureService.createOrUpdate(vacature);
	}
	
	@PostMapping("{opdrachtgeverId}")
	public Vacature createAndAddOpdrachtgever(@PathVariable long opdrachtgeverId,@RequestBody Vacature vacature) {
		return this.vacatureService.createAndLinkOpdrachtgever(vacature, opdrachtgeverId);
	}
	
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.vacatureService.deleteById(id);
	}
	
}
