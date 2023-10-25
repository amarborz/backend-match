package nl.youngcapital.match.model;

import jakarta.persistence.Entity;

@Entity
public class Opdrachtgever extends Persoon {
	private String omschrijving;

	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	
	
}
