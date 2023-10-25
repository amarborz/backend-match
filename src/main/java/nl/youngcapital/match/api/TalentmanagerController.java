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

import nl.youngcapital.match.model.Talentmanager;
import nl.youngcapital.match.service.TalentmanagerService;


@RestController
@RequestMapping("api/talentmanager")
public class TalentmanagerController {
	
	@Autowired
	private TalentmanagerService talentmanagerService;
	
	@GetMapping
	public List<Talentmanager> findAll() {
		return talentmanagerService.findAll();
	}
	
	
	@GetMapping("{id}")
	public ResponseEntity<Talentmanager> findById(@PathVariable long id) {
		Optional<Talentmanager> optionalTalentmanager = this.talentmanagerService.findById(id);
		
		if(optionalTalentmanager.isPresent()) {
			Talentmanager result = optionalTalentmanager.get();
			return ResponseEntity.ok(result);
		} else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@PostMapping
	public Talentmanager create(@RequestBody Talentmanager talentmanager) {
		return this.talentmanagerService.createOrUpdate(talentmanager);
	}
	
	@PutMapping("{id}")
	public ResponseEntity<Talentmanager> updateById(@PathVariable long id, @RequestBody Talentmanager input) {
		Optional<Talentmanager> optionalTarget = this.talentmanagerService.findById(id);
		
		if (optionalTarget.isPresent()) {
			
		}
	
		Talentmanager target = optionalTarget.get();
		target.setNaam(input.getNaam());
		target.setWachtwoord(input.getWachtwoord());
		target.setEmail(input.getEmail());
		target.setFoto(input.getFoto());
		target.setTelefoon(input.getTelefoon());
		
		Talentmanager updated = this.talentmanagerService.createOrUpdate(target);
		return ResponseEntity.ok(updated);
				
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.talentmanagerService.deleteById(id);
	}
	
}
