package nl.youngcapital.match.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Opdracht {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String status;
	private LocalDate startDatum;
	private LocalDate eindDatum;
	
	
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
