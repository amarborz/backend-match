package nl.youngcapital.match.model;

import java.util.List;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Opdrachtgever")
public class Opdrachtgever extends Persoon {
	private String omschrijving;

	@OneToMany(mappedBy = "opdrachtgever", cascade = CascadeType.ALL)
	private List<Vacature> vacatures;
	
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	public List<Vacature> getVacatures() {
		return vacatures;
	}
	public void setVacatures(List<Vacature> vacatures) {
		this.vacatures = vacatures;
	}

	@Override
	public String getRole() {
		return "ROLE_OPDRACHTGEVER";
	}
}
