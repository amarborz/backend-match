package nl.youngcapital.match.model;


import java.util.List;


import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Trainee")
public class Trainee extends Persoon {
	
	private String richting;
	private String cv;
	private String motivatie;
	private String bio;
	private String woonplaats;
	
	@OneToMany
	private List<Loonstrook> loonstroken;
	
	@ManyToOne
	@JoinColumn(name = "talentmanager_id")
	private Talentmanager talentmanager;
	
	@OneToMany(mappedBy = "trainee", cascade = CascadeType.ALL)
	private List<Opdracht> opdrachten;
	
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
	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}
	public Talentmanager getTalentmanager() {
		return talentmanager;
	}
	public void setTalentmanager(Talentmanager talentmanager) {
		this.talentmanager = talentmanager;
	}
	public List<Opdracht> getOpdrachten() {
		return opdrachten;
	}
	public void setOpdrachten(List<Opdracht> opdrachten) {
		this.opdrachten = opdrachten;
	}
	public List<Loonstrook> getLoonstroken() {
		return loonstroken;
	}
	public void setLoonstroken(List<Loonstrook> loonstroken) {
		this.loonstroken = loonstroken;
	}
	public void addLoonstrook(Loonstrook ls) {
		this.loonstroken.add(ls);
	}
	
	@Override
	public String getRole() {
		return "ROLE_TRAINEE";
	}
}
