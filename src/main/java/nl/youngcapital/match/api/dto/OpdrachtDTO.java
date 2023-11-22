package nl.youngcapital.match.api.dto;

import java.time.LocalDate;

import nl.youngcapital.match.model.Opdracht;

public class OpdrachtDTO {
	private long id;
	private String status;
	private LocalDate startDatum;
	private LocalDate eindDatum;
	private long vacatureId;
	private long traineeId;
	private long opdrachtgeverId;
	
	public OpdrachtDTO(Opdracht opdracht) {
		this.id = opdracht.getId();
		this.status = opdracht.getStatus();
		this.startDatum = opdracht.getStartDatum();
		this.eindDatum = opdracht.getEindDatum();
		this.vacatureId = opdracht.getVacature().getId();
		this.traineeId = opdracht.getTrainee().getId();
		this.opdrachtgeverId = opdracht.getVacature().getOpdrachtgever().getId();
	}
	
	public long getOpdrachtgeverId() {
		return opdrachtgeverId;
	}
	public void setOpdrachtgeverId(long opdrachtgeverId) {
		this.opdrachtgeverId = opdrachtgeverId;
	}
	public long getVacatureId() {
		return vacatureId;
	}
	public void setVacatureId(long vacatureId) {
		this.vacatureId = vacatureId;
	}
	public long getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
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
