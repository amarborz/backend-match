package nl.youngcapital.match.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Talentmanager")
public class Talentmanager extends Persoon {

	@OneToMany(mappedBy = "talentmanager", cascade = CascadeType.ALL)
	private List<Trainee> trainees;

	public List<Trainee> getTrainees() {
		return trainees;
	}

	public void setTrainees(List<Trainee> trainees) {
		this.trainees = trainees;
	}	

	@Override
	public String getRole() {
		return "ROLE_TALENTMANAGER";
	}
}
