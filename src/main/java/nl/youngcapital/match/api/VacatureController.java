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

import nl.youngcapital.match.model.Vacature;
import nl.youngcapital.match.service.VacatureService;

@RestController
@RequestMapping("api/vacature")
public class VacatureController {
	
	@Autowired
	private VacatureService vacatureService;
	
	@GetMapping
	public List<Vacature> findAll() {
		return vacatureService.findAll();
	}
	
	@PostMapping
	public Vacature create(@RequestBody Vacature vacature) {
		return this.vacatureService.createOrUpdate(vacature);
	}
	
	@DeleteMapping("{id}")
	public void deleteById(@PathVariable long id) {
		this.vacatureService.deleteById(id);
	}
	
}
