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

import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.service.OpdrachtService;
import nl.youngcapital.match.service.OpdrachtgeverService;


@RestController
@RequestMapping("api/opdracht")
public class OpdrachtController {
	
	@Autowired
	private OpdrachtService opdrachtService;
	
	@GetMapping
	public List<Opdracht> findAll() {
		return opdrachtService.findAll();
	}
	
	@PostMapping
	public Opdracht create(@RequestBody Opdracht opdracht) {
		return this.opdrachtService.createOrUpdate(opdracht);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.opdrachtService.deleteById(id);
	}
	
}
