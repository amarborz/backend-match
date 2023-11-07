package nl.youngcapital.match.api.dto;

import java.time.LocalDate;

import nl.youngcapital.match.model.Opdracht;

public class OpdrachtDTO {
	private String status;
	private LocalDate startDatum;
	private LocalDate eindDatum;
	
	public OpdrachtDTO(Opdracht opdracht) {
		this.status = opdracht.getStatus();
		this.startDatum = opdracht.getStartDatum();
		this.eindDatum = opdracht.getEindDatum();
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
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
