package nl.youngcapital.match.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import nl.youngcapital.match.api.dto.TalentmanagerDTO;
import nl.youngcapital.match.api.dto.TraineeDTO;
import nl.youngcapital.match.api.dto.TraineeStatusVanTalentmanagersDTO;
import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.model.Talentmanager;
import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.model.Vacature;
import nl.youngcapital.match.persistence.TalentmanagerRepository;
import nl.youngcapital.match.persistence.TraineeRepository;

@Service
public class TalentmanagerService {

	@Autowired
	private TalentmanagerRepository talentmanagerRepository;

	@Autowired
	private TraineeRepository traineeRepository;

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

	public List<TraineeDTO> findTraineesByTalentmanagerId(long id) {
		Optional<Talentmanager> talentmanager = talentmanagerRepository.findById(id);
		List<TraineeDTO> traineeDTO = new ArrayList<TraineeDTO>();

		if (talentmanager.isPresent()) {
			List<Trainee> trainees = traineeRepository.findByTalentmanager(talentmanager.get());

			for (Trainee trainee : trainees) {
				traineeDTO.add(new TraineeDTO(trainee));
			}
		}
		return traineeDTO;
	}

	public Talentmanager createOrUpdate(Talentmanager talentmanager) {
		return this.talentmanagerRepository.save(talentmanager);
	}

	public void deleteById(long id) {
		this.talentmanagerRepository.deleteById(id);
	}

	public List<TraineeStatusVanTalentmanagersDTO> getTraineeStatusForTalentmanager(long id) {
		Optional<Talentmanager> optionalTalentmanager = this.talentmanagerRepository.findById(id);
		List<TraineeStatusVanTalentmanagersDTO> traineeStatusDTO = new ArrayList<TraineeStatusVanTalentmanagersDTO>();

		if (optionalTalentmanager.isPresent()) {
			Talentmanager talentmanager = optionalTalentmanager.get();
			List<Trainee> trainees = talentmanager.getTrainees();

			for (Trainee trainee : trainees) {
				List<Opdracht> opdrachten = trainee.getOpdrachten();
				if (opdrachten != null && !opdrachten.isEmpty()) {
					for (Opdracht opdracht : opdrachten) {
						Vacature vacature = opdracht.getVacature();
						Opdrachtgever opdrachtgever = vacature.getOpdrachtgever();

						traineeStatusDTO
								.add(new TraineeStatusVanTalentmanagersDTO(opdracht, opdrachtgever, trainee, vacature));
					}
				} else {
					traineeStatusDTO.add(new TraineeStatusVanTalentmanagersDTO(trainee));
				}
			}
		}
		return traineeStatusDTO;
	}

}
