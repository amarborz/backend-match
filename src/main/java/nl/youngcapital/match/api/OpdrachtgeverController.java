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

import nl.youngcapital.match.api.dto.OpdrachtgeverDTO;
import nl.youngcapital.match.api.dto.OpdrachtgeverOpdrachtDTO;
import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.service.OpdrachtgeverService;


@RestController
@RequestMapping("api/opdrachtgever")
public class OpdrachtgeverController {
	
	@Autowired
	private OpdrachtgeverService opdrachtgeverService;
	
	@GetMapping
	public List<OpdrachtgeverDTO> findAll() {
		return opdrachtgeverService.getAllOpdrachtgevers();
	}
	
	@GetMapping("{id}")
	public ResponseEntity<OpdrachtgeverDTO> findOpdrachtgeverById(@PathVariable long id) {
		Optional<OpdrachtgeverDTO> optionalOpdrachtgever = this.opdrachtgeverService.findOpdrachtgeverById(id);
		if(optionalOpdrachtgever.isPresent()) {
			return ResponseEntity.ok(optionalOpdrachtgever.get());
		} else {
			return ResponseEntity.notFound().build();
		}	
	}
	
	@PostMapping
	public Opdrachtgever create(@RequestBody Opdrachtgever opdrachtgever) {
		return this.opdrachtgeverService.createOrUpdate(opdrachtgever);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Opdrachtgever> updateById(@PathVariable long id, @RequestBody Opdrachtgever input) {
		Optional<Opdrachtgever> optionalTarget = this.opdrachtgeverService.findById(id);
		
		if (optionalTarget.isEmpty()) {
			return null;
		}
	
		Opdrachtgever target = optionalTarget.get();
		target.setNaam(input.getNaam());
		target.setWachtwoord(input.getWachtwoord());
		target.setEmail(input.getEmail());
		target.setFoto(input.getFoto());
		target.setTelefoon(input.getTelefoon());
		target.setPlaats(input.getPlaats());
		target.setOmschrijving(input.getOmschrijving());
		
		Opdrachtgever updated = this.opdrachtgeverService.createOrUpdate(target);
		return ResponseEntity.ok(updated);
				
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.opdrachtgeverService.deleteById(id);
	}

}
