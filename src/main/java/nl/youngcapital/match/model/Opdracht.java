package nl.youngcapital.match.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "Opdracht")
public class Opdracht {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private String status;
	private LocalDate startDatum;
	private LocalDate eindDatum;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "vacature_id")
	private Vacature vacature;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "trainee_id")
	private Trainee trainee;
	
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
	public long getId() {
		return id;
	}
	
	public Vacature getVacature() {
		return vacature;
	}
	public void setVacature(Vacature vacature) {
		this.vacature = vacature;
	}
	public Trainee getTrainee() {
		return trainee;
	}
	public void setTrainee(Trainee trainee) {
		this.trainee = trainee;
	}	
	
	
}
