package nl.youngcapital.match.model;


import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "Vacature")
public class Vacature {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String standplaats;
	private String omschrijving;
	private String vereisten;
	private int uren;
	private String duur;
	private String titel;
	private LocalDate publicatieDatum;
	private LocalDate startDatum;
	private LocalDate eindDatum;
	
	@OneToMany(mappedBy = "vacature", cascade = CascadeType.ALL)
	private List<Opdracht> opdrachten;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "opdrachtgever_id")
	private Opdrachtgever opdrachtgever;
	
	public long getId() {
		return id;
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
	
	
	public List<Opdracht> getOpdrachten() {
		return opdrachten;
	}
	public void setOpdrachten(List<Opdracht> opdrachten) {
		this.opdrachten = opdrachten;
	}
	public Opdrachtgever getOpdrachtgever() {
		return opdrachtgever;
	}
	public void setOpdrachtgever(Opdrachtgever opdrachtgever) {
		this.opdrachtgever = opdrachtgever;
	}	
	
}
