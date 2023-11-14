package nl.youngcapital.match.api.dto;

import java.time.LocalDate;

import nl.youngcapital.match.model.Opdracht;
import nl.youngcapital.match.model.Opdrachtgever;
import nl.youngcapital.match.model.Vacature;

public class OpdrachtenVanTraineeDTO {
	private long vacatureId;
	private String plaats;
	private String adres;
	private String vacatureOmschrijving;
	private String vereisten;
	private int uren;
	private String duur;
	private String titel;
	private LocalDate publicatieDatum;
	
	private long opdrachtId;
	private String status;
	private LocalDate startDatum;
	private LocalDate eindDatum;
	
	private long opdrachtgeverId;
	private String naam;
	private String email;
	private String foto;
	private String telefoon;
	private String bedrijfsOmschrijving;
	
	
	public OpdrachtenVanTraineeDTO(Opdracht opdracht, Vacature vacature, Opdrachtgever opdrachtgever) {
		this.vacatureId = vacature.getId();
		this.plaats = vacature.getPlaats();
		this.adres = vacature.getAdres();
		this.vacatureOmschrijving = vacature.getOmschrijving();
		this.vereisten = vacature.getVereisten();
		this.uren = vacature.getUren();
		this.duur = vacature.getDuur();
		this.titel = vacature.getTitel();
		this.publicatieDatum = vacature.getPublicatieDatum();
		this.startDatum = vacature.getStartDatum();
		this.eindDatum = vacature.getEindDatum();
		
		this.opdrachtId = opdracht.getId();
		this.status = opdracht.getStatus();
		this.startDatum = opdracht.getStartDatum();
		this.eindDatum = opdracht.getEindDatum();
		
		this.opdrachtgeverId = opdrachtgever.getId();
		this.naam = opdrachtgever.getNaam();
		this.email = opdrachtgever.getEmail();
		this.foto = opdrachtgever.getFoto();
		this.telefoon = opdrachtgever.getTelefoon();
		this.bedrijfsOmschrijving = opdrachtgever.getOmschrijving();
	}

	
	public long getVacatureId() {
		return vacatureId;
	}

	public void setVacatureId(long vacatureId) {
		this.vacatureId = vacatureId;
	}

	public long getOpdrachtId() {
		return opdrachtId;
	}

	public void setOpdrachtId(long opdrachtId) {
		this.opdrachtId = opdrachtId;
	}

	public long getOpdrachtgeverId() {
		return opdrachtgeverId;
	}

	public void setOpdrachtgeverId(long opdrachtgeverId) {
		this.opdrachtgeverId = opdrachtgeverId;
	}

	
	public String getPlaats() {
		return plaats;
	}

	public void setPlaats(String standplaats) {
		this.plaats = standplaats;
	}

	public String getAdres() {
		return adres;
	}

	public void setAdres(String adres) {
		this.adres = adres;
	}

	public String getVacatureOmschrijving() {
		return vacatureOmschrijving;
	}

	public void setVacatureOmschrijving(String vacatureOmschrijving) {
		this.vacatureOmschrijving = vacatureOmschrijving;
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

	public String getBedrijfsOmschrijving() {
		return bedrijfsOmschrijving;
	}

	public void setBedrijfsOmschrijving(String bedrijfsOmschrijving) {
		this.bedrijfsOmschrijving = bedrijfsOmschrijving;
	}
	
}
