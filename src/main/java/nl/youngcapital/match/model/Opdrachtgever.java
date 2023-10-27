package nl.youngcapital.match.model;

import jakarta.persistence.Entity;

@Entity
public class Opdrachtgever extends Persoon {
	private String plaats;
	private String omschrijving;

	
	public String getPlaats() {
		return plaats;
	}
	public void setPlaats(String plaats) {
		this.plaats = plaats;
	}
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	
	
}
