package nl.youngcapital.match.api.dto;

import java.time.LocalDate;
import java.util.List;

import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.model.Vacature;
import nl.youngcapital.match.model.Opdrachtgever;

public class OpdrachtgeverOpdrachtDTO {
	private String opdrachtgeverNaam;
	private List<Vacature> vacatures;
	private List<String> opdrachtStandplaats;

	public OpdrachtgeverOpdrachtDTO(List<Vacature> vacatures, Opdrachtgever opdrachtgever) {
		this.opdrachtgeverNaam = opdrachtgever.getNaam();
		this.vacatures = vacatures;
	}

	public String getOpdrachtgeverNaam() {
		return opdrachtgeverNaam;
	}

	public void setOpdrachtgeverNaam(String opdrachtgeverNaam) {
		this.opdrachtgeverNaam = opdrachtgeverNaam;
	}

	public List<String> getOpdrachtStandplaats() {
		return opdrachtStandplaats;
	}

	public void setOpdrachtStandplaats(List<String> opdrachtStandplaats) {
		this.opdrachtStandplaats = opdrachtStandplaats;
	}

	public List<Vacature> getVacatures() {
		return vacatures;
	}

	public void setVacatures(List<Vacature> vacatures) {
		this.vacatures = vacatures;
	}

	
}
