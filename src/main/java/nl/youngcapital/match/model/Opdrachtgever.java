package nl.youngcapital.match.model;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Opdrachtgever")
public class Opdrachtgever extends Persoon {
	private String plaats;
	private String omschrijving;

	@OneToMany(mappedBy = "opdrachtgever", cascade = CascadeType.ALL)
	private List<Vacature> vacatures;
	
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
	public List<Vacature> getVacatures() {
		return vacatures;
	}
	public void setVacatures(List<Vacature> vacatures) {
		this.vacatures = vacatures;
	}
	
	
}
