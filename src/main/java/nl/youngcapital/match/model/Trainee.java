package nl.youngcapital.match.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Trainee")
public class Trainee extends Persoon {

	
	private String richting;
	private String cv;
	private String motivatie;
	private String bio;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "talentmanager_id")
	private Talentmanager talentmanager;
	
	public String getMotivatie() {
		return motivatie;
	}
	public void setMotivatie(String motivatie) {
		this.motivatie = motivatie;
	}
	public String getRichting() {
		return richting;
	}
	public void setRichting(String richting) {
		this.richting = richting;
	}
	public String getCv() {
		return cv;
	}
	public void setCv(String cv) {
		this.cv = cv;
	}
	public String getBio() {
		return bio;
	}
	public void setBio(String bio) {
		this.bio = bio;
	}
	
	public Talentmanager getTalentmanager() {
		return talentmanager;
	}
	public void setTalentmanager(Talentmanager talentmanager) {
		this.talentmanager = talentmanager;
	}
	
	
}
