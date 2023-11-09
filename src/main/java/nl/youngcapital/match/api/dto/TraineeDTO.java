package nl.youngcapital.match.api.dto;

import nl.youngcapital.match.model.Trainee;

public class TraineeDTO {
	private String naam;
	private String email;
	private String foto;
	private String telefoon;
	private String richting;
	private String cv;
	private String bio;
	private String motivatie;
	private String woonplaats;
	
	public TraineeDTO(Trainee trainee) {
		this.naam = trainee.getNaam();
		this.email = trainee.getEmail();
		this.foto = trainee.getFoto();
		this.telefoon = trainee.getTelefoon();
		this.richting = trainee.getRichting();
		this.cv = trainee.getCv();
		this.bio = trainee.getBio();
		this.motivatie = trainee.getMotivatie();
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTelefoon() {
		return telefoon;
	}

	public void setTelefoon(String telefoon) {
		this.telefoon = telefoon;
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

	public String getMotivatie() {
		return motivatie;
	}

	public void setMotivatie(String motivatie) {
		this.motivatie = motivatie;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}
	
}
