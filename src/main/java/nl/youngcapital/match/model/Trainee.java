package nl.youngcapital.match.model;


import jakarta.persistence.Entity;

@Entity
public class Trainee extends Persoon {

	
	private String richting;
	private String cv;
	private String motivatie;
	private String bio;
	
	
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
	
	
}
