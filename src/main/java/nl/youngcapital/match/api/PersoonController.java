package nl.youngcapital.match.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import nl.youngcapital.match.api.dto.LoginDTO;
import nl.youngcapital.match.api.dto.TraineeDTO;
import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.model.Talentmanager;
import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.service.OpdrachtgeverService;
import nl.youngcapital.match.service.TalentmanagerService;
import nl.youngcapital.match.service.TraineeService;

@RestController
@RequestMapping("api/persoon")
public class PersoonController {
	
	@Autowired
	private TraineeService traineeService;
	
	@Autowired
	private TalentmanagerService talentmanagerService;
	
	@Autowired
	private OpdrachtgeverService opdrachtgeverService;
	
	@GetMapping
	public List<LoginDTO> findPersoon() {
	    List<LoginDTO> loginDTO = new ArrayList<LoginDTO>();
	    List<Trainee> trainees = traineeService.findAll();
	    List<Talentmanager> talentmanagers = talentmanagerService.findAll();
	    List<Opdrachtgever> opdrachtgevers = opdrachtgeverService.findAll();
	    
	    for (Trainee trainee : trainees) {
	        LoginDTO login = new LoginDTO(trainee);
	        loginDTO.add(login);
	    }

	    for (Talentmanager talentmanager : talentmanagers) {
	        LoginDTO login = new LoginDTO(talentmanager);
	        loginDTO.add(login);
	    }

	    for (Opdrachtgever opdrachtgever : opdrachtgevers) {
	        LoginDTO login = new LoginDTO(opdrachtgever);
	        loginDTO.add(login);
	    }
	    
	    return loginDTO;
	}
}
>>>>>>> 3947e59244cbcc00e84c121c8763effe16329d5c
