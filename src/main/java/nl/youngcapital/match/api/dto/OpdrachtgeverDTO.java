package nl.youngcapital.match.api.dto;

import nl.youngcapital.match.model.Opdrachtgever;

public class OpdrachtgeverDTO {
	private long id;
	private String naam;
	private String email;
	private String foto;
	private String telefoon;
	private String omschrijving;

	public OpdrachtgeverDTO(Opdrachtgever opdrachtgever) {
		this.id = opdrachtgever.getId();
		this.naam = opdrachtgever.getNaam();
		this.email = opdrachtgever.getEmail();
		this.foto = opdrachtgever.getFoto();
		this.telefoon = opdrachtgever.getTelefoon();
		this.omschrijving = opdrachtgever.getOmschrijving();
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

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	
}
