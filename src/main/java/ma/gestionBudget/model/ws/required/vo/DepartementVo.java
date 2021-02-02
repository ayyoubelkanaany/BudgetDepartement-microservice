package ma.gestionBudget.model.ws.required.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.engine.jdbc.SerializableBlobProxy;

public class DepartementVo implements Serializable{

private Long id;
private String libelle;
private String refDepartement;
public Long getId() {
	return id;
}
public void setId(Long id) {
	this.id = id;
}

public String getLibelle() {
	return libelle;
}
public void setLibelle(String libelle) {
	this.libelle = libelle;
}
public DepartementVo() {
	super();

}
public DepartementVo(Long id, String libelle) {
	super();
	this.id = id;
	libelle = libelle;
}
public String getRefDepartement() {
	return refDepartement;
}
public void setRefDepartement(String refDepartement) {
	this.refDepartement = refDepartement;
}


}
