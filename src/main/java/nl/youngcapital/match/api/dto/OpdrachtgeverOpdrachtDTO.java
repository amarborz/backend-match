package nl.youngcapital.match.api.dto;

import java.time.LocalDate;

import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.model.Opdrachtgever;

public class OpdrachtgeverOpdrachtDTO {
	private String opdrachtgeverNaam;
	private LocalDate opdrachtStartDatum;
	
	public OpdrachtgeverOpdrachtDTO(Opdracht opdracht, Opdrachtgever opdrachtgever) {
		opdrachtgeverNaam = opdrachtgever.getNaam();
		opdrachtStartDatum = opdracht.getStartDatum();
	}

	public String getOpdrachtgeverNaam() {
		return opdrachtgeverNaam;
	}

	public void setOpdrachtgeverNaam(String opdrachtgeverNaam) {
		this.opdrachtgeverNaam = opdrachtgeverNaam;
	}

	public LocalDate getOpdrachtStartDatum() {
		return opdrachtStartDatum;
	}

	public void setOpdrachtStartDatum(LocalDate opdrachtStartDatum) {
		this.opdrachtStartDatum = opdrachtStartDatum;
	}
	
	
}
