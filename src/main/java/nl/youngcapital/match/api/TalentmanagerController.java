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
	
	@PostMapping
	public Talentmanager create(@RequestBody Talentmanager talentmanager) {
		return this.talentmanagerService.createOrUpdate(talentmanager);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.talentmanagerService.deleteById(id);
	}
	
}
