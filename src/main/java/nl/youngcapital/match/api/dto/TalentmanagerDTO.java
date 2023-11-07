package nl.youngcapital.match.api.dto;

import nl.youngcapital.match.model.Talentmanager;

public class TalentmanagerDTO  {
	private String naam;
	private String email;
	private String foto;
	private String telefoon;
	
	public TalentmanagerDTO(Talentmanager talentmanager) {
		this.naam = talentmanager.getNaam();
		this.email = talentmanager.getEmail();
		this.foto = talentmanager.getFoto();
		this.telefoon = talentmanager.getTelefoon();
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
	
}
