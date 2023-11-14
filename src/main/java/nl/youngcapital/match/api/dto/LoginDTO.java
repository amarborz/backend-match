package nl.youngcapital.match.api.dto;

import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.model.Persoon;
import nl.youngcapital.match.model.Talentmanager;
import nl.youngcapital.match.model.Trainee;

public class LoginDTO {
	
	private long id;
	private String naam;
	private String wachtwoord;
	private String email;
	private String accountType;
	
	public LoginDTO(Persoon persoon) {
		if (persoon instanceof Trainee) {
			accountType = "trainee";
		} else if (persoon instanceof Talentmanager) {
			accountType = "talentmanager";
		} else if (persoon instanceof Opdrachtgever) {
			accountType = "opdrachtgever";
		}
		
		this.id = persoon.getId();
		this.naam = persoon.getNaam();
		this.wachtwoord = persoon.getWachtwoord();
		this.email = persoon.getEmail();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getWachtwoord() {
		return wachtwoord;
	}

	public void setWachtwoord(String wachtwoord) {
		this.wachtwoord = wachtwoord;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	
}
