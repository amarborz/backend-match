package nl.youngcapital.match.api.dto;

import java.time.LocalDate;

import nl.youngcapital.match.model.Vacature;

public class VacatureDTO {
	private String standplaats;
	private String omschrijving;
	private String vereisten;
	private int uren;
	private String duur;
	private String titel;
	private LocalDate publicatieDatum;
	private LocalDate startDatum;
	private LocalDate eindDatum;

	public VacatureDTO(Vacature vacature) {
		this.standplaats = vacature.getStandplaats();
		this.omschrijving = vacature.getOmschrijving();
		this.vereisten = vacature.getVereisten();
		this.uren = vacature.getUren();
		this.duur = vacature.getDuur();
		this.titel = vacature.getTitel();
		this.publicatieDatum = vacature.getPublicatieDatum();
		this.startDatum = vacature.getStartDatum();
		this.eindDatum = vacature.getEindDatum();
	}

	public String getStandplaats() {
		return standplaats;
	}

	public void setStandplaats(String standplaats) {
		this.standplaats = standplaats;
	}

	public String getOmschrijving() {
		return omschrijving;
	}

	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}

	public String getVereisten() {
		return vereisten;
	}

	public void setVereisten(String vereisten) {
		this.vereisten = vereisten;
	}

	public int getUren() {
		return uren;
	}

	public void setUren(int uren) {
		this.uren = uren;
	}

	public String getDuur() {
		return duur;
	}

	public void setDuur(String duur) {
		this.duur = duur;
	}

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public LocalDate getPublicatieDatum() {
		return publicatieDatum;
	}

	public void setPublicatieDatum(LocalDate publicatieDatum) {
		this.publicatieDatum = publicatieDatum;
	}

	public LocalDate getStartDatum() {
		return startDatum;
	}

	public void setStartDatum(LocalDate startDatum) {
		this.startDatum = startDatum;
	}

	public LocalDate getEindDatum() {
		return eindDatum;
	}

	public void setEindDatum(LocalDate eindDatum) {
		this.eindDatum = eindDatum;
	}

}
