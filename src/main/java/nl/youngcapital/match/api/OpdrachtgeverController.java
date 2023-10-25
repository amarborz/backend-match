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

import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.service.OpdrachtgeverService;


@RestController
@RequestMapping("api/opdrachtgever")
public class OpdrachtgeverController {
	
	@Autowired
	private OpdrachtgeverService opdrachtgeverService;
	
	@GetMapping
	public List<Opdrachtgever> findAll() {
		return opdrachtgeverService.findAll();
	}
	
	@PostMapping
	public Opdrachtgever create(@RequestBody Opdrachtgever opdrachtgever) {
		return this.opdrachtgeverService.createOrUpdate(opdrachtgever);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.opdrachtgeverService.deleteById(id);
	}
	
}
