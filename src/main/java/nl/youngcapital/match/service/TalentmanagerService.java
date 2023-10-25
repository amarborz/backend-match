package nl.youngcapital.match.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;
import nl.youngcapital.match.model.Talentmanager;
import nl.youngcapital.match.persistence.TalentmanagerRepository;

@Service
public class TalentmanagerService {
	
	@Autowired
	private TalentmanagerRepository talentmanagerRepository;
	
	public List<Talentmanager> findAll() {
		return talentmanagerRepository.findAll();
	}
	
	@Transactional
	public Talentmanager createOrUpdate(Talentmanager talentmanager) {
		return this.talentmanagerRepository.save(talentmanager);
	}
	
	public void deleteById(long id) {
		this.talentmanagerRepository.deleteById(id);
	}
	
}
