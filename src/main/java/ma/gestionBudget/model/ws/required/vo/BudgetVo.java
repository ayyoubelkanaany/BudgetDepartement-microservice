package ma.gestionBudget.model.ws.required.vo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;
import com.fasterxml.jackson.annotation.JsonSetter;

public class BudgetVo implements Serializable{

	private Long id;
	private String refBudget;
	private String annee;
	private String description;
	private String creditOuvert;
	private String montantInvestisement;
	private String montantFonctionement;
	private String montantInvestisementRestant;
	private String montantFonctionementRestant;
	private String montantTotal;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getAnnee() {
		return annee;
	}
	public void setAnnee(String annee) {
		this.annee = annee;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreditOuvert() {
		return creditOuvert;
	}
	public void setCreditOuvert(String creditOuvert) {
		this.creditOuvert = creditOuvert;
	}
	public String getMontantInvestisement() {
		return montantInvestisement;
	}
	public void setMontantInvestisement(String montantInvestisement) {
		this.montantInvestisement = montantInvestisement;
	}
	public String getMontantFonctionement() {
		return montantFonctionement;
	}
	public void setMontantFonctionement(String montantFonctionement) {
		this.montantFonctionement = montantFonctionement;
	}
	public String getMontantInvestisementRestant() {
		return montantInvestisementRestant;
	}
	public void setMontantInvestisementRestant(String montantInvestisementRestant) {
		this.montantInvestisementRestant = montantInvestisementRestant;
	}
	public String getMontantFonctionementRestant() {
		return montantFonctionementRestant;
	}
	public void setMontantFonctionementRestant(String montantFonctionementRestant) {
		this.montantFonctionementRestant = montantFonctionementRestant;
	}
	public String getMontantTotal() {
		return montantTotal;
	}
	public void setMontantTotal(String montantTotal) {
		this.montantTotal = montantTotal;
	}
	public String getRefBudget() {
		return refBudget;
	}
	public void setRefBudget(String refBudget) {
		this.refBudget = refBudget;
	}
	
}	