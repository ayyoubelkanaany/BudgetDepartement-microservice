package ma.gestionBudget.bean;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
public class BudgetDepartement implements Serializable{
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String refBudget;
	private String reference;
	private String refDepartement;
	private Double montantInvestisement;
	private Double montantFonctionement;
	private Double montantInvestisementRestant;
	private Double montantFonctionementRestant;
	private Double montantTotal;
	
	public BudgetDepartement() {
		super();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRefBudget() {
		return refBudget;
	}

	public void setRefBudget(String refBudget) {
		this.refBudget = refBudget;
	}

	public String getRefDepartement() {
		return refDepartement;
	}

	public void setRefDepartement(String refDepartement) {
		this.refDepartement = refDepartement;
	}

	public Double getMontantInvestisement() {
		return montantInvestisement;
	}

	public void setMontantInvestisement(Double montantInvestisement) {
		this.montantInvestisement = montantInvestisement;
	}

	public Double getMontantFonctionement() {
		return montantFonctionement;
	}

	public void setMontantFonctionement(Double montantFonctionement) {
		this.montantFonctionement = montantFonctionement;
	}

	public Double getMontantInvestisementRestant() {
		return montantInvestisementRestant;
	}

	public void setMontantInvestisementRestant(Double montantInvestisementRestant) {
		this.montantInvestisementRestant = montantInvestisementRestant;
	}

	public Double getMontantFonctionementRestant() {
		return montantFonctionementRestant;
	}

	public void setMontantFonctionementRestant(Double montantFonctionementRestant) {
		this.montantFonctionementRestant = montantFonctionementRestant;
	}

	public Double getMontantTotal() {
		return montantTotal;
	}

	public void setMontantTotal(Double montantTotal) {
		this.montantTotal = montantTotal;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}


	
	
		
}
