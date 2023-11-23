package nl.youngcapital.match.api.dto;

import java.util.List;

import jakarta.persistence.OneToMany;
import nl.youngcapital.match.model.Loonstrook;
import nl.youngcapital.match.model.Talentmanager;
import nl.youngcapital.match.model.Trainee;

public class TraineeDTO {

	private long id;
	private String naam;
	private String email;
	private String foto;
	private String telefoon;
	private String richting;
	private String cv;
	private String bio;
	private String motivatie;
	private String woonplaats;

	private TalentmanagerDTO talentmanagerDTO;

	@OneToMany
	private List<Loonstrook> loonstroken;

	public TraineeDTO(Trainee trainee) {
		this.id = trainee.getId();
		this.naam = trainee.getNaam();
		this.email = trainee.getEmail();
		this.foto = trainee.getFoto();
		this.telefoon = trainee.getTelefoon();
		this.richting = trainee.getRichting();
		this.cv = trainee.getCv();
		this.bio = trainee.getBio();
		this.motivatie = trainee.getMotivatie();
		this.woonplaats = trainee.getWoonplaats();
		this.loonstroken = trainee.getLoonstroken();

		Talentmanager tm = trainee.getTalentmanager();
		if (tm != null) {
			this.talentmanagerDTO = new TalentmanagerDTO(trainee.getTalentmanager());
		}
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getCv() {
		return cv;
	}

	public void setCv(String cv) {
		this.cv = cv;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getMotivatie() {
		return motivatie;
	}

	public void setMotivatie(String motivatie) {
		this.motivatie = motivatie;
	}

	public String getWoonplaats() {
		return woonplaats;
	}

	public void setWoonplaats(String woonplaats) {
		this.woonplaats = woonplaats;
	}

	public List<Loonstrook> getLoonstroken() {
		return loonstroken;
	}

	public void setLoonstroken(List<Loonstrook> loonstroken) {
		this.loonstroken = loonstroken;
	}

	public void addLoonstrook(Loonstrook ls) {
		this.loonstroken.add(ls);
	}

	public TalentmanagerDTO getTalentmanagerDTO() {
		return talentmanagerDTO;
	}

	public void setTalentmanagerDTO(TalentmanagerDTO talentmanagerDTO) {
		this.talentmanagerDTO = talentmanagerDTO;
	}

}
