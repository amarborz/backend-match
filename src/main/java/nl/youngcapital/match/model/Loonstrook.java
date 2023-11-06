package nl.youngcapital.match.model;


import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Loonstrook {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private int salarisBedrag;
	private LocalDate periode;
	private boolean uitbetaald;
	
	
	public long getId() {
		return id;
	}
	public int getSalarisBedrag() {
		return salarisBedrag;
	}
	public void setSalarisBedrag(int salarisBedrag) {
		this.salarisBedrag = salarisBedrag;
	}
	public LocalDate getPeriode() {
		return periode;
	}
	public void setPeriode(LocalDate periode) {
		this.periode = periode;
	}
	public boolean isUitbetaald() {
		return uitbetaald;
	}
	public void setUitbetaald(boolean uitbetaald) {
		this.uitbetaald = uitbetaald;
	}
	@Override
	public String toString() {
	    return "Loonstrook{" +
	           "id=" + id +
	           ", salarisBedrag=" + salarisBedrag +
	           ", periode=" + periode +
	           ", uitbetaald=" + uitbetaald +
	           '}';
	}
}
