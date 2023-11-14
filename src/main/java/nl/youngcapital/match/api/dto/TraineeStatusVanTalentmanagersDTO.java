package nl.youngcapital.match.api.dto;

import java.time.LocalDate;

import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.model.Trainee;
import nl.youngcapital.match.model.Vacature;

public class TraineeStatusVanTalentmanagersDTO {
	private long traineeId;
	private String naam;
	private String email;
	private String foto;
	private String telefoon;
	private String richting;
	
	private long opdrachtId;
	private String status;
	private LocalDate startDatum;
	private LocalDate eindDatum;
	
	private long vacatureId;
	private String titel;
	
	private long opdrachtgeverId;
	private String opdrachtgeverNaam;
	private String opdrachtgeverEmail;
	private String opdrachtgeverFoto;
	private String opdrachtgeverTelefoon;
	private String opdrachtgeverOmschrijving;
	
	public TraineeStatusVanTalentmanagersDTO(Opdracht opdracht, Opdrachtgever opdrachtgever, Trainee trainee, Vacature vacature) {
		this.traineeId = trainee.getId();
		this.naam = trainee.getNaam();
		this.email = trainee.getEmail();
		this.foto = trainee.getFoto();
		this.telefoon = trainee.getTelefoon();
		this.richting = trainee.getRichting();
		
		this.opdrachtId = opdracht.getId();
		this.status = opdracht.getStatus();
		this.startDatum = opdracht.getStartDatum();
		this.eindDatum = opdracht.getEindDatum();
		
		this.vacatureId = vacature.getId();
		this.titel = vacature.getTitel();
		
		this.opdrachtgeverId = opdrachtgever.getId();
		this.opdrachtgeverNaam = opdrachtgever.getNaam();
		this.opdrachtgeverEmail = opdrachtgever.getEmail();
		this.opdrachtgeverFoto = opdrachtgever.getFoto();
		this.opdrachtgeverTelefoon = opdrachtgever.getTelefoon();
		this.opdrachtgeverOmschrijving = opdrachtgever.getOmschrijving();
	}
	
	public TraineeStatusVanTalentmanagersDTO(Trainee trainee) {
		this.naam = trainee.getNaam();
		this.email = trainee.getEmail();
		this.foto = trainee.getFoto();
		this.telefoon = trainee.getTelefoon();
		this.richting = trainee.getRichting();
	}

	
	
	public long getTraineeId() {
		return traineeId;
	}

	public void setTraineeId(long traineeId) {
		this.traineeId = traineeId;
	}

	public long getOpdrachtId() {
		return opdrachtId;
	}

	public void setOpdrachtId(long opdrachtId) {
		this.opdrachtId = opdrachtId;
	}

	public long getVacatureId() {
		return vacatureId;
	}

	public void setVacatureId(long vacatureId) {
		this.vacatureId = vacatureId;
	}

	public long getOpdrachtgeverId() {
		return opdrachtgeverId;
	}

	public void setOpdrachtgeverId(long opdrachtgeverId) {
		this.opdrachtgeverId = opdrachtgeverId;
	}

	public String getNaam() {
		return naam;
	}

	public void setNaam(String naam) {
		this.naam = naam;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFoto() {
		return foto;
	}

	public void setFoto(String foto) {
		this.foto = foto;
	}

	public String getTelefoon() {
		return telefoon;
	}

	public void setTelefoon(String telefoon) {
		this.telefoon = telefoon;
	}

	public String getRichting() {
		return richting;
	}

	public void setRichting(String richting) {
		this.richting = richting;
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

	public String getTitel() {
		return titel;
	}

	public void setTitel(String titel) {
		this.titel = titel;
	}

	public String getOpdrachtgeverNaam() {
		return opdrachtgeverNaam;
	}

	public void setOpdrachtgeverNaam(String opdrachtgeverNaam) {
		this.opdrachtgeverNaam = opdrachtgeverNaam;
	}

	public String getOpdrachtgeverEmail() {
		return opdrachtgeverEmail;
	}

	public void setOpdrachtgeverEmail(String opdrachtgeverEmail) {
		this.opdrachtgeverEmail = opdrachtgeverEmail;
	}

	public String getOpdrachtgeverFoto() {
		return opdrachtgeverFoto;
	}

	public void setOpdrachtgeverFoto(String opdrachtgeverFoto) {
		this.opdrachtgeverFoto = opdrachtgeverFoto;
	}

	public String getOpdrachtgeverTelefoon() {
		return opdrachtgeverTelefoon;
	}

	public void setOpdrachtgeverTelefoon(String opdrachtgeverTelefoon) {
		this.opdrachtgeverTelefoon = opdrachtgeverTelefoon;
	}

	public String getOpdrachtgeverOmschrijving() {
		return opdrachtgeverOmschrijving;
	}

	public void setOpdrachtgeverOmschrijving(String opdrachtgeverOmschrijving) {
		this.opdrachtgeverOmschrijving = opdrachtgeverOmschrijving;
	}
	
}
