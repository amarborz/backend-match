package nl.youngcapital.match.api.dto;

import nl.youngcapital.match.model.Opdrachtgever;

public class OpdrachtgeverDTO {
	private String naam;
	private String email;
	private String foto;
	private String telefoon;
	private String plaats;
	private String omschrijving;

	public OpdrachtgeverDTO(Opdrachtgever opdrachtgever) {
		this.naam = opdrachtgever.getNaam();
		this.email = opdrachtgever.getEmail();
		this.foto = opdrachtgever.getFoto();
		this.telefoon = opdrachtgever.getTelefoon();
		this.plaats = opdrachtgever.getPlaats();
		this.omschrijving = opdrachtgever.getOmschrijving();
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
