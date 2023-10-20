package nl.youngcapital.match.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Vacature {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private String titel;
	private String vereisten;
	private String omschrijving;
	private String uitstroomrichting;
	private String remote_hybrid;
	private String vestiging;
	private boolean beschikbaar;
	private int opdrachtduur;
	private int uren;
	
	public String getTitel() {
		return titel;
	}
	public void setTitel(String titel) {
		this.titel = titel;
	}
	
	public String getVereisten() {
		return vereisten;
	}
	public void setVereisten(String vereisten) {
		this.vereisten = vereisten;
	}
	
	public String getOmschrijving() {
		return omschrijving;
	}
	public void setOmschrijving(String omschrijving) {
		this.omschrijving = omschrijving;
	}
	
	public String getUitstroomrichting() {
		return uitstroomrichting;
	}
	public void setUitstroomrichting(String uitstroomrichting) {
		this.uitstroomrichting = uitstroomrichting;
	}
	
	public String getRemote_hybrid() {
		return remote_hybrid;
	}
	public void setRemote_hybrid(String remote_hybrid) {
		this.remote_hybrid = remote_hybrid;
	}
	
	public String getVestiging() {
		return vestiging;
	}
	public void setVestiging(String vestiging) {
		this.vestiging = vestiging;
	}
	
	public boolean isBeschikbaar() {
		return beschikbaar;
	}
	public void setBeschikbaar(boolean beschikbaar) {
		this.beschikbaar = beschikbaar;
	}
	
	public int getOpdrachtduur() {
		return opdrachtduur;
	}
	public void setOpdrachtduur(int opdrachtduur) {
		this.opdrachtduur = opdrachtduur;
	}
	
	public int getUren() {
		return uren;
	}
	public void setUren(int uren) {
		this.uren = uren;
	}
	
}
