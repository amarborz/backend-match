package nl.youngcapital.match.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.api.dto.TalentmanagerDTO;
import nl.youngcapital.match.model.Talentmanager;
import nl.youngcapital.match.persistence.TalentmanagerRepository;

@Service
public class TalentmanagerService {

	@Autowired
	private TalentmanagerRepository talentmanagerRepository;

	public List<Talentmanager> findAll() {
		return talentmanagerRepository.findAll();
	}

	public Optional<Talentmanager> findById(long id) {
		return this.talentmanagerRepository.findById(id);
	}
	
	public List<TalentmanagerDTO> getAllTalentmanagers() {
		List<Talentmanager> talentmanagers = talentmanagerRepository.findAll();
		List<TalentmanagerDTO> talentmanagersDTO = new ArrayList<TalentmanagerDTO>();
		for (Talentmanager talentmanager : talentmanagers) {
			talentmanagersDTO.add(new TalentmanagerDTO(talentmanager));
		}
		return talentmanagersDTO;
	}

	public Optional<TalentmanagerDTO> findTalentmanagerById(long id) {
	    Optional<Talentmanager> talentmanager = this.talentmanagerRepository.findById(id);
	    return talentmanager.map(TalentmanagerDTO::new);
	}

	public Talentmanager createOrUpdate(Talentmanager talentmanager) {
		return this.talentmanagerRepository.save(talentmanager);
	}

	public void deleteById(long id) {
		this.talentmanagerRepository.deleteById(id);
	}

}
